package DatabaseConnection;

import java.sql.*;

public class DBConnect {

    static String url = "jdbc:postgresql://localhost:5432/mydatabase";
    static Connection conn = null;

    public static Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, "postgres", "120903");
            System.out.println("Bağlandi.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}