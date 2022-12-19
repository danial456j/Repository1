package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Server.EchoServer;
import ocsf.server.AbstractServer;

public class DBController {
	private static Connection conn;

	public DBController() {
		connectToDB();
	}

	public static void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ekrut?serverTimezone=IST", "root", "Danial.jar12");
			// DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
			System.out.println("SQL connection succeed");
			// printCourses(conn);
		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public void parsingTheData(AbstractServer server, Object msg) {
		saveUserToDB((ArrayList<String>) msg);
		server.sendToAllClients("");
	}

	public static void saveUserToDB(ArrayList<String> arr) {
		updatingCreditCardNumberOfUserInDB(arr.get(1), arr.get(2));
		updatingSubscriberNumberOfUserInDB(arr.get(1), arr.get(3));
	}

	public static void updatingCreditCardNumberOfUserInDB(String ID, String newCreditCardNumber) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("UPDATE subscriber SET credit_card_number= ? WHERE id=?");
			stmt.setString(1, newCreditCardNumber);
			stmt.setString(2, ID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updatingSubscriberNumberOfUserInDB(String ID, String newSubscriberNumber) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("UPDATE subscriber SET subscriber_number= ? WHERE id=?");
			stmt.setString(1, newSubscriberNumber);
			stmt.setString(2, ID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showSubscriberInfo(AbstractServer server, String ID) {
		PreparedStatement pstmt;
		ResultSet rs = null;
		ArrayList<String> info = new ArrayList<>();
		try {

			pstmt = conn.prepareStatement("SELECT * FROM subscriber WHERE id = ?");
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			rs.next();

			if (rs.wasNull()) {
				System.out.println("The exntered ID was Not Found");
				server.sendToAllClients("Error");
			} else {
				System.out.println("The exntered ID was Found");
				info.add(rs.getString("first_name"));
				info.add(rs.getString("last_name"));
				info.add(rs.getString("id"));
				info.add(rs.getString("phone_number"));
				info.add(rs.getString("email_address"));
				info.add(rs.getString("credit_card_number"));
				info.add(rs.getString("subscriber_number"));
				server.sendToAllClients(info);
				rs.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
