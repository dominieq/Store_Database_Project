package DatabaseApp;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLHelper {

    private Connection conn=null;

    public SQLHelper() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "inf132326");
        connectionProps.put("password", "inf132326");
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//admlab2.cs.put.poznan.pl:1521/dblab02_students.cs.put.poznan.pl"
                    , connectionProps);
            System.out.println("Połączono z bazą danych");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseApp.class.getName()).log(Level.SEVERE,
                    "nie udało się połączyć z bazą danych", ex);
            System.exit(-1);
        }
    }

    //potencjalny SQL injection
    public ResultSet selectALL(String skad){

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from " + skad);
        } catch (SQLException ex) {
            System.out.println("Bład wykonania polecenia" + ex.toString());
        }
        return rs;
    }
}
