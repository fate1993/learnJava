package jdbc.madang.dto;

import java.sql.*;

public class GetConnection {

	public static Connection getMadangConnection() {
		Connection con = null;
		try {
			con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"c##madang", 
					"madang"
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closed(PreparedStatement pstmt) {
		try {
			if(pstmt != null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void closed(ResultSet rs, PreparedStatement pstmt) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void closed(Connection con) {
		try {
			if(con != null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
