import java.sql.*;
public class Prog24 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            String url = "jdbc:mysql://localhost/Product_Data";
            String username = "root";
            Connection conn = DriverManager.getConnection(url, username, "");
            Statement st = conn.createStatement();
            String sql = "update Product set Quantity=Quantity+100 where Price<1000 ";
            int affectedRows=st.executeUpdate(sql);
            System.out.println("Updated "+affectedRows+" Rows...");
            String sqlSelect = "SELECT * FROM Product;";
            ResultSet rs= st.executeQuery(sqlSelect);
            System.out.println("ID|\t|Name|\t|Price|\t|Quantity\n");
            while (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");
                System.out.println(id +"|\t|"+name+"|\t|"+ price+"|\t|"+ quantity);
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

