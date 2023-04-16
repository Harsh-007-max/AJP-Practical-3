import java.sql.*;
public class Prog23 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            String url = "jdbc:mysql://localhost/product_data";
            String username = "root";
            Connection conn = DriverManager.getConnection(url, username, "");
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM Product where Price >= 1000 ";
            ResultSet rs=st.executeQuery(sql);
            System.out.println("Successfully Fetched Rows...");
            System.out.println("ID|\tName|\tPrice|\tQuantity\n");
            while (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");
                System.out.println(id +"|\t"+name+"|\t"+ price+"|\t"+ quantity);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("Query IS Wrong Please Try Again"+se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

