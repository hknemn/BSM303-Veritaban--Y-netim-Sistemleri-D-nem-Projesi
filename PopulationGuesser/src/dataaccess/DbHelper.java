package dataaccess;

import java.sql.*;

public class DbHelper {

    private String userName = "root";
    private String password = "*********";
    private String dbUrl = "jdbc:mysql://localhost:3306/{?}";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage(SQLException exception) {
        System.out.println("Error message: " + exception.getMessage());
        System.out.println("Error code: " + exception.getErrorCode());
    }
}
