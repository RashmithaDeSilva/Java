import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
    
    public static void main(String[] args) {
        
        // 1. Run the Drivers
        // 2. Create a Conection
        // 3. Create a Statement
        // 4. Define a SQL
        // 5. Execute/Post the SQL
        
        
        // >>>>> 1. Run the Drivers
        try {
            // Loard(Run) Driver softwhear into ram
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found ...!");
        }
        
        
        // >>>>> 2. Create a Conection
        Connection connection = null;
        try {
            
            // Create conection with MqSql Database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/thogakade",
                    "root",
                    "1234"
            );
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        // >>>>> 3. Create a Statement
        Statement stm = null;
        try {
            // Create  link with MySql to execute SQL queries
            stm = connection.createStatement();    
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        // >>>>> 4. Define a SQL
            // SQL queries
        String SQL = "SELECT * FROM customer";
        int res = 0;
        
        try {
            // Execute SQL querie
            //res = stm.executeUpdate(SQL);
            
            ResultSet reset = stm.executeQuery(SQL);
            
            while (reset.next()) {
                String id = reset.getString("id");
                String name = reset.getString("name");
                String address = reset.getString("address");
                double salary = reset.getDouble("salary");
            
                System.out.println(id+"\t"+name+"\t"+address+"\t"+salary);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        // >>>>> 5. Execute/Post the SQL
        if (res > 0) {
            System.out.println("SQL queries execute successfully");
        }
        
        
    }
    
}