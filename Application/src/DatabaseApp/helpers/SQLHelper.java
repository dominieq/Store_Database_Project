package DatabaseApp.helpers;

import DatabaseApp.DatabaseApp;
import DatabaseApp.models.Warehouse;
import DatabaseApp.models.Worker;

import java.sql.*;
import java.util.Properties;

/**
 * TODO comments
 */
public class SQLHelper {

    private DatabaseApp app;

    private Connection conn;

    /**
     * Creates SQLHelper object. Establishes connection with database.
     * When error occurs function exits application otherwise proceeds to work.
     */
    public SQLHelper(DatabaseApp app) {

        this.app = app;

        Properties connectionProps = new Properties();
        connectionProps.put("user", "inf132326");
        connectionProps.put("password", "inf132326");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//admlab2.cs.put.poznan.pl:1521/dblab02_students.cs.put.poznan.pl",
                    connectionProps);
            System.out.println("Connection with database established.");
        } catch (Exception exception) {
            // System.out.println("Couldn't connect with database.");
            System.out.println("Couldn't establish connection. Emergency start.");
            // System.exit(1);
            this.app.setEmergencyStart(true);
        }

    }

    /**
     * Carries out SQL SELECT query. Returns selected items.
     * @param relation String
     * @return ResultSet
     */
    private ResultSet selectALL(String relation){

        Statement stmt;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from " + relation);
        } catch (SQLException exception) {
            System.out.println("Couldn't execute SELECT query.");
        }
        return rs;

    }

    /**
     * Fills observable warehouse's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillWarehouses() {
        ResultSet rsWarehouse = selectALL("warehouse");
        try{
            while (rsWarehouse.next()) {
                this.app.getWarehouses().add(new Warehouse(
                        rsWarehouse.getInt(1), rsWarehouse.getString(2)));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable worker's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillWorkers() {
        ResultSet rsWorker = selectALL("worker");

        try{
            while (rsWorker.next()) {
                Worker worker = new Worker(
                        rsWorker.getInt(1), rsWorker.getString(2),
                        rsWorker.getString(3), rsWorker.getString(4),
                        rsWorker.getString(5), rsWorker.getString(6),
                        rsWorker.getString(7), rsWorker.getInt(8));
                this.app.getWorkers().add(worker);
                for (Warehouse warehouse : this.app.getWarehouses()) {
                    if (warehouse.getIndexString().equals(worker.getWarehouseIndexString())) {
                        warehouse.addWorker(worker);
                    }
                }
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }
}
