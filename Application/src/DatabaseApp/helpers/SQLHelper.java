package DatabaseApp.helpers;

import DatabaseApp.DatabaseApp;
import DatabaseApp.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

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
            exception.printStackTrace();
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

    /**
     * Fills observable category's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillCategories() {
        ResultSet rsCategory = selectALL("category");
        try{
            while (rsCategory.next()) {
                this.app.getCategories().add(new Category(
                        rsCategory.getInt(1), rsCategory.getString(2)));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable courier's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillCouriers() {
        ResultSet rsCourier = selectALL("courier");
        try{
            while (rsCourier.next()) {
                this.app.getCouriers().add(new Courier(
                        rsCourier.getInt(1), rsCourier.getString(2)));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable merchandise's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillMerchandises() {
        ResultSet rsMerchandise = selectALL("merchandise");
        try{
            while (rsMerchandise.next()) {
                int t_producer_int = rsMerchandise.getInt(5);
                Producer t_producer = null;
                for (Producer producer : this.app.getProducers()) {
                    if (producer.getIndex() == t_producer_int) {
                        t_producer = producer;
                        break;
                    }
                }
                int t_category_int = rsMerchandise.getInt(6);
                Category t_category = null;
                for (Category category : this.app.getCategories()) {
                    if (category.getIndex() == t_category_int) {
                        t_category = category;
                        break;
                    }
                }
                this.app.getMerchandise().add(new Merchandise(
                        rsMerchandise.getInt(1), rsMerchandise.getString(2),
                        rsMerchandise.getFloat(3), rsMerchandise.getFloat(4), t_producer, t_category));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable order's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillOrders() {
        ResultSet rsOrder = selectALL("w_order");
        try{
            while (rsOrder.next()) {
                int t_recipient_int = rsOrder.getInt(5);
                Recipient t_recipient = null;
                for (Recipient recipient : this.app.getRecipients()) {
                    if (recipient.getIndex() == t_recipient_int) {
                        t_recipient = recipient;
                        break;
                    }
                }
                int t_courier_int = rsOrder.getInt(4);
                Courier t_courier = null;
                for (Courier courier : this.app.getCouriers()) {
                    if (courier.getIndex() == t_courier_int) {
                        t_courier = courier;
                        break;
                    }
                }
                this.app.getOrders().add(new Order(
                        rsOrder.getInt(1), rsOrder.getDate(2),
                        rsOrder.getDate(3), t_recipient, t_courier));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable packdelivery's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillPackDeliveries() {
        ResultSet rsPackDelivery = selectALL("packdelivery");
        try{
            while (rsPackDelivery.next()) {
                int t_supply_int = rsPackDelivery.getInt(1);
                Supply t_supply = null;
                for (Supply supply : this.app.getSupplies()) {
                    if (supply.getInvoiceNumber() == t_supply_int) {
                        t_supply = supply;
                        break;
                    }
                }
                Stock t_stock = this.getThisStock(rsPackDelivery.getInt(2), rsPackDelivery.getInt(3));

                this.app.getPackDeliveries().add(new PackDelivery(
                        rsPackDelivery.getInt(4), t_supply,
                        t_stock));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable packorder's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillPackOrders() {
        ResultSet rsPackOrder = selectALL("packorder");
        try{
            while (rsPackOrder.next()) {
                int t_order_int = rsPackOrder.getInt(1);
                Order t_order = null;
                for (Order order : this.app.getOrders()) {
                    if (order.getInvoiceNumber() == t_order_int) {
                        t_order = order;
                        break;
                    }
                }

                Stock t_stock = this.getThisStock(rsPackOrder.getInt(2), rsPackOrder.getInt(3));


                this.app.getPackOrders().add(new PackOrder(
                        rsPackOrder.getInt(4), t_order,
                        t_stock));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }
    
    /**
     * Fills observable producer's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillProducers() {
        ResultSet rsProducer = selectALL("producer");
        try{
            while (rsProducer.next()) {
                this.app.getProducers().add(new Producer(
                        rsProducer.getInt(1), rsProducer.getString(2), rsProducer.getString(3), rsProducer.getString(4), rsProducer.getString(5), rsProducer.getString(6)));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable recipient's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillRecipients() {
        ResultSet rsRecipient = selectALL("recipient");
        try{
            while (rsRecipient.next()) {
                this.app.getRecipients().add(new Recipient(
                        rsRecipient.getInt(1),
                        rsRecipient.getString(2),
                        rsRecipient.getString(3),
                        rsRecipient.getString(4),
                        rsRecipient.getString(5)));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable stock's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillStocks() {
        ResultSet rsStock = selectALL("stock");
        try{
            while (rsStock.next()) {
                int t_merchandise_int = rsStock.getInt(2);
                Merchandise t_merchandise = null;
                for (Merchandise merchandise : this.app.getMerchandise()) {
                    if (merchandise.getIndex() == t_merchandise_int) {
                        t_merchandise = merchandise;
                        break;
                    }
                }
                int t_warehouse_int = rsStock.getInt(3);
                Warehouse t_warehouse = null;
                for (Warehouse warehouse : this.app.getWarehouses()) {
                    if (warehouse.getIndex() == t_warehouse_int) {
                        t_warehouse = warehouse;
                        break;
                    }
                }
                this.app.getStocks().add(new Stock(
                        rsStock.getInt(1), t_merchandise, t_warehouse));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable supplier's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillSuppliers() {
        ResultSet rsSupplier = selectALL("supplier");
        try{
            while (rsSupplier.next()) {
                this.app.getSuppliers().add(new Supplier(
                        rsSupplier.getInt(1), rsSupplier.getString(2), rsSupplier.getString(3), rsSupplier.getString(4), rsSupplier.getString(5)));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /**
     * Fills observable supply's list with information from database.
     * When an error occurs function returns exception otherwise returns null.
     * @return Exception
     */
    public Exception fillSupplies() {
        ResultSet rsSupply = selectALL("supply");
        try{
            while (rsSupply.next()) {
                int t_supplier_int = rsSupply.getInt(4);
                Supplier t_supplier = null;
                for (Supplier supplier : this.app.getSuppliers()) {
                    if (supplier.getIndex() == t_supplier_int) {
                        t_supplier = supplier;
                        break;
                    }
                }
                this.app.getSupplies().add(new Supply(
                        rsSupply.getInt(1), rsSupply.getDate(2), rsSupply.getDate(3), t_supplier));
            }
        } catch (Exception exception) {
            return exception;
        }

        return null;
    }

    /*
     * for Stock
     */
    private Stock getThisStock(int merchandise_int, int warehouse_int) {
        for (Stock stock : this.app.getStocks()) {
            if (stock.getMerchandise().getIndex() == merchandise_int && stock.getWarehouse().getIndex() == warehouse_int) {
                return stock;
            }
        }
        System.out.println(7);
        return null;
    }

    public void insertInto (String sqldmlinsertcode){

        Statement stmt;
        int rows;
        try {
            stmt = conn.createStatement();
            System.out.println(sqldmlinsertcode);
            rows = stmt.executeUpdate(sqldmlinsertcode);
            System.out.println(rows + " for 'INSERT'");
        } catch (SQLException exception) {
            System.out.println("Couldn't execute INSERT INTO query.");
            System.out.println("Error Code: " + exception.getErrorCode());
            System.out.println("SQLState: " + exception.getSQLState());
        }

    }

    public void deleteFrom (String sqldmldeletecode){

        Statement stmt;
        int rows;
        try {
            stmt = conn.createStatement();
            System.out.println(sqldmldeletecode);
            rows = stmt.executeUpdate(sqldmldeletecode);
            System.out.println(rows + " for 'DELETE'");
        } catch (SQLException exception) {
            System.out.println("Couldn't execute DELETE FROM query.");
            System.out.println("Error Code: " + exception.getErrorCode());
            System.out.println("SQLState: " + exception.getSQLState());
        }

    }

    public void updateWhere (String sqldmlupdatecode){

        Statement stmt;
        int rows;
        try {
            stmt = conn.createStatement();
            System.out.println(sqldmlupdatecode);
            rows = stmt.executeUpdate(sqldmlupdatecode);
            System.out.println(rows + " for 'UPDATE'");
        } catch (SQLException exception) {
            System.out.println("Couldn't execute UPDATE WHERE query.");
            System.out.println("Error Code: " + exception.getErrorCode());
            System.out.println("SQLState: " + exception.getSQLState());
        }

    }

    /**
     * TODO comments
     * @param sqlSelectCode String
     */
    public List<Integer> searchWhere (String sqlSelectCode){
        try {
            Statement stmt = conn.createStatement();
            System.out.println(sqlSelectCode);
            ResultSet resultSet = stmt.executeQuery(sqlSelectCode);
            List<Integer> results = new ArrayList<>();
            while (resultSet.next()) {
                results.add(resultSet.getInt(1));
                System.out.println(results.get(results.size() - 1));
            }
            return results;
        } catch (SQLException exception) {
            String title = "SQLException";
            String content = "Couldn't execute SELECT WHERE query.\n" +
                    "Error Code: " + exception.getErrorCode() + "\n" +
                    "SQLState: " + exception.getSQLState();
            System.out.println(content);
            this.app.showError(title, content);
            return null;
        }
    }
}
