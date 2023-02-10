package lk.ijse.SpiceWholesaleShop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/SpiceWholesaleShop", "root", "1234");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance() throws SQLException {
        return (null == dbConnection) ? dbConnection = new DBConnection() : dbConnection;
    }
    public Connection getConnection() {
        return connection;
    }

}
