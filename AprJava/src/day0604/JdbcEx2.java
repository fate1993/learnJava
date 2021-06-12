package day0604;

import java.sql.*; // 1. import java.sql.*

public class JdbcEx2 {
	
	static {
		//2. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		try { // 3. connect 객체 생성
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"c##scott", 
					"tiger");
			
			// 4. statement 객체 생성
			Statement stmt = con.createStatement();
			
			// sql문 만듬(create table) >> updateCount
			String sql = "create table test1(id varchar(10),age int)";
			// sql문 실행
			int updateCount = stmt.executeUpdate(sql);
			System.out.println("createCount : " + updateCount);
			
			// sql문 만듬(insert) >> updateCount
			sql = "insert into test1 values ('abc1011',10)";
			// sql문 실행
			updateCount = stmt.executeUpdate(sql);
			System.out.println("insertCount : " + updateCount);

			// select 문(select) >> ResultSet으로 받아옴
			ResultSet rs = stmt.executeQuery("select * from test1");
			while (rs.next()) { // 커서 사용해서 하나씩
				System.out.print("id : " + rs.getString(1) + " , ");
				System.out.println("age : " + rs.getInt("age"));
			}
			
			// sql문(set)
			sql = "update test1 set id='abc2022', age=20 where id='abc1011'";
			updateCount = stmt.executeUpdate(sql);
			System.out.println("updateCount : " + updateCount);

			rs = stmt.executeQuery("select * from test1");
			while (rs.next()) {
				System.out.print("id : " + rs.getString(1) + " , ");
				System.out.println("age : " + rs.getString("age"));
			}

			updateCount = stmt.executeUpdate("delete from test1");
			System.out.println("deleteCount : " + updateCount);

			updateCount = stmt.executeUpdate("drop table test1");
			System.out.println("dropCount : " + updateCount);

			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ee) {
			System.out.println("Connection Error");
			ee.printStackTrace();
		}
	}
}

