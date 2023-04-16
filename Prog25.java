import java.sql.*;
import java.util.Scanner;
public class Prog25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            String url = "jdbc:mysql://localhost/product_data";
            String username = "root";
            Connection conn = DriverManager.getConnection(url, username, "");
            System.out.println("Connected..");
            Statement st = conn.createStatement();
            System.out.println("Enter ID of Product You Want To Delete:");
            id=sc.nextInt();
            String sql = "delete from Product where ID='"+id+"'";
            st.executeUpdate(sql);
            System.out.println("Successfully Deleted Row...");
            String sqlSelect = "SELECT Count(*) FROM Product;";
            ResultSet rs= st.executeQuery(sqlSelect);
            rs.next();
            int count=rs.getInt(1);
            System.out.println(count+" Number Of Rows Had By Product Table...");
            st.close();
            conn.close();
            sc.close();
        } catch (SQLException se) {
            System.out.println("Query IS Wrong Please Try Again"+se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}