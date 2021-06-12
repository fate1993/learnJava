package day0604;
// 트랜잭션
import java.sql.*; 
public class BatchInsertEx { 
	static{ 
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		}catch(ClassNotFoundException cnfe){ 
			cnfe.printStackTrace(); 
		} 
	} 

	public static void main(String args[]){ 
		ResultSet rs = null; 
		Connection con=null; 
		Statement stmt=null; 
		String sql = null; 
		boolean commit = false; // true로 auto commit 되지 않도록 객체 선언 및 false로 초기화


		try { 
			con = DriverManager.getConnection( 
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"c##scott", 
					"tiger"); 
			stmt = con.createStatement(); 
			sql = "create table test4(id varchar(10) primary key, " + 
					"password varchar(10))"; 
			stmt.executeUpdate(sql); 

			con.setAutoCommit(false); // 트랜잭션 시작
			stmt.addBatch("INSERT INTO test4 " + 
					"VALUES('abc1011', '1111')"); 
			stmt.addBatch("INSERT INTO test4 " + 
					"VALUES('abc2022', '2222')"); 
			stmt.addBatch("INSERT INTO test4 " + 
					"VALUES('abc3033', '3333')"); // 중복값 >> exception 발생 >> catch로 가서 예외 처리 >> finally 수행
			stmt.addBatch("INSERT INTO test4 " + 
					"VALUES('abc4044', '4444')"); 

			int [] updateCounts = stmt.executeBatch(); // 일괄로 한번에 실행 
			commit = true; 
			con.commit(); // db에 반영
			con.setAutoCommit(commit); // true로 변경 

			rs = stmt.executeQuery("SELECT * FROM test4"); 

			while (rs.next()) { 
				String id = rs.getString("id"); 
				String password = rs.getString("password"); 
				System.out.println("id : " + id + 
						" , password : "+password); 
			} 
		}catch(SQLException sqle) { 
			sqle.printStackTrace();


		}finally{ 
			try{ 
				if(!commit) con.rollback(); // true >> false. 롤백안함
				if(rs != null) rs.close(); 
				if(stmt != null) stmt.close(); 
				if(con != null) con.close(); 
			}catch(SQLException sqle){ 
				sqle.printStackTrace(); 
			} 
		} 
	} 
} 
