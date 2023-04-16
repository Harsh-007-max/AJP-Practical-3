import java.sql.*;
import java.util.Scanner;

public class Prog22 {
    public static void main(String[] args) {
        int q, n;
        double price;
        String nm="";
        Scanner sc = new Scanner(System.in);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");

            String url = "jdbc:mysql://localhost/product_data";
            String username = "root";

            Connection conn = DriverManager.getConnection(url, username, "");

            Statement st = conn.createStatement();

            System.out.println("How Many Rows You Want To Enter: ");
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.println("Enter Name Of Product: ");
                nm = sc.next();
                System.out.println("Enter Price Of Product:");
                price = sc.nextDouble();
                System.out.println("Enter Quantity Of Product:");
                q = sc.nextInt();
                String sql = "insert into product (Name, Price, Quantity) values('" + nm + "','" + price + "','" + q+ "')";
                st.execute(sql);
                System.out.println("1 row inserted..");
                sc.close();
            }
        } catch (SQLException se) {
            System.out.println("Query IS Wrong Please Try Again" + se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
