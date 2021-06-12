package day0604;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CallableStatementDemo {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"c##scott", 
					"tiger"
					);
			
			cstmt = con.prepareCall("{call adjust(?,?)}"); // preparecall 메서드 호출
			
			// inout 파라미터값 매핑
			cstmt.setString(1, "sys2022"); // 1번째 ? 
			cstmt.setFloat(2, 0.3f); // 2번째 ?
			cstmt.executeUpdate();
			
			pstmt = con.prepareStatement("select * from salary");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)); 
			}
			
			 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
