package day0604;
import java.sql.*;

public class PreparedStatementEx {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"c##scott", 
					"tiger");
			String sql = "create table test2(id varchar2(10), password varchar2(10))";
			pstmt = con.prepareStatement(sql); // 저장만하고 아직 sql문 실행은 안된 상태
			int updateCount = pstmt.executeUpdate(); // sql문에 바인딩변수(?) 없기 때문에 바로 실행
			System.out.println("createCount : " + updateCount);

			sql = "insert into test2 values(?,?)"; // 두개의 값 짚어 넣겠다. ?,?(바인딩 변수)
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "abc2022"); 
			pstmt.setString(2, "1111");
			// 바인딩 변수 들어왔으니까 값 셋팅해줌
			updateCount = pstmt.executeUpdate();
			System.out.println("insertCount : " + updateCount);
			// 레코드 개수 알려줌

			sql = "select * from test2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // ? 없으니까 바로 실행
			while (rs.next()) { // select 문은 늘 next()로
				System.out.print("id : " + rs.getString(1));
				System.out.println(", password : " + rs.getString(2));
			}

			sql = "drop table test2";
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
			System.out.println("dropCount : " + updateCount);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle) {
			}
		}
	}
}
