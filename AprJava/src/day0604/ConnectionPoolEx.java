package day0604;

import java.sql.*;

public class ConnectionPoolEx {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPool cp = null;
		// 사용할 객체 변수 선언
		try {
			cp = ConnectionPool.getInstance("jdbc:oracle:thin:@localhost:1521:xe", 
					"c##scott","tiger", 5, 10);
			// 처음엔 5개의 커넥션, 그다음엔 10개까지 더 만듬
			con = cp.getConnection();
			pstmt = con.prepareStatement("select * from dept");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("deptno : " + rs.getInt(1) + ",");
				System.out.println("dname : " + rs.getString(2) + ",");

				System.out.println("loc : " + rs.getString(3));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					cp.releaseConnection(con);
			} catch (SQLException _sqle) {
				_sqle.printStackTrace();
			}
		}
		cp.closeAll();
	}
}
