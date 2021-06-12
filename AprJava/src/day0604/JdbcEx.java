package day0604;

import java.sql.*; // 1. import

public class JdbcEx {

	// 2. 드라이버 로딩
	static { // 프로그램 시작하자마자 시작되는 static
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// finally 블록에서도 사용하기 위해 모두 선언 시킴

		// 3. connection 연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##scott", "tiger"); // url, 계정명,
																											// 비밀번호

			// 4. sql문 전송해서 실행
			stmt = con.createStatement();

			// sql문 만듬(select) >> ResultSet 객체 생성
			String sql = "select * from dept";

			// sql문 실행. select 결과 레코드는 ResultsSet 타입으로 받아와서 커서 사용
			rs = stmt.executeQuery(sql); // 커서 사용

			while (rs.next()) { // 순서대로 레코드 있는지 확인
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc"); // 컬럼명 대신 인덱스를 사용할 수도 있음(참고: 데이터베이스 인덱스는 1부터 시작)

				System.out.println(deptno + " " + dname + " " + loc);
			}

			// 원래는 finally에서 쓴느 코드

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 연결했던 것 close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
