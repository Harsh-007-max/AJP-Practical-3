import java.sql.*;
public class Prog21 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            String url = "jdbc:mysql://localhost/product_data";
            String username = "root";
            Connection conn = DriverManager.getConnection(url, username, "");
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE Product(ID INT NOT NULL AUTO_INCREMENT, Name VARCHAR(60), Price DOUBLE, Quantity INT,PRIMARY KEY (ID))";
            st.executeUpdate(sql);
            System.out.println("Table created successfully...");
        } catch (SQLException se) {
            System.out.println("Query is Wrong Please Try Again" + se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
