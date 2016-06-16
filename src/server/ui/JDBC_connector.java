package server.ui;

import java.sql.*;

import server.ui.ServerInterface;

public class JDBC_connector {

	public static void connect(String host, String port, String serviceName,
			String user, String pass) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@" + host + ":" + port + ":"
					+ serviceName;
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ServerInterface.setConnStatusField(true);
//			System.out.println("hello");

			try {
				con.close();
				System.out.println("test completed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("hello");
//			return st;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
