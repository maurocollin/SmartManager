package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

    public static final String URL = "jdbc:mariadb://191.252.218.249:3306/agenda";
    public static final String USER = "mauro";
    public static final String PASSWORD = "q1w2e3"; // Replace with your database password

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Use the appropriate driver class for MariaDB
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return con;
    }
}

