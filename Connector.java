package u24096017_assignment4;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author lesed
 */
public class Connector {
    // ✅ Connection URL to your MariaDB DB
    private static final String url = "jdbc:mariadb://localhost:3307/northwind";
    private static final String user = "root"; 
    private static final String password = "Fifalesedi05"; 
  public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    public static void main(String[] args) {
        Connection conn = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // ✅ Load MariaDB driver
            Class.forName("org.mariadb.jdbc.Driver");

            // ✅ Connect to the DB
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");

         
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

           
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " from " + rs.getString("city"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed.");
        } finally {
            // ✅ Close connection
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
           scanner.close();
        }
    }
}
