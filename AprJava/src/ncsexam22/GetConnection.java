package ncsexam22;

import java.sql.*;

public class GetConnection {

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"c##myschool", "myschool");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void Closed(ResultSet rs, PreparedStatement pstmt) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closed(Connection con) {
		try {
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
