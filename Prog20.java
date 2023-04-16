import java.sql.*;
class Prog20 {
	public static void main(String[]args){
		try {
			Connection c;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			c = DriverManager.getConnection("jdbc:odbc:access");
			System.out.println("Connection Successful");
			c.close();
		}
		catch(Exception e){
			System.out.println("Errorrrr"+e);
			e.printStackTrace();
		}
	}
}