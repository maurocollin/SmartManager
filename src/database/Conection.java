package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    public static final String URL = "jdbc:mariadb://191.252.218.249:3306/app_java";
    public static final String USER = "mauro";
    public static final String PASSWORD = "q1w2e3";
    
    // MÉTODO RESPONSAVEL POR CONECTAR DO BANCO DE DADOS
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return con;
    }

}
