package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_f", "root", "system");

//			conn = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","system");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}