package day0604;
import java.sql.*; 
// 속도 차이 확인 PreparedStatement vs createStatement
public class PerformanceEx{ 
	static{ 
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		}catch(ClassNotFoundException cnfe){ 
			cnfe.printStackTrace(); 
		} 
	} 
	public static void main(String[] args){

		long start; 
		long end; 
		// 시작한 시간, 끝나는 시간 저장할 수 있게 객체 선언
		Connection con = null; 
		PreparedStatement pstmt = null; 
		Statement stmt=null; 

		try{ 
			con = DriverManager.getConnection( 
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"c##scott", 
					"tiger"); 
			
			// ==== createStatement
			
			stmt = con.createStatement(); 
			String sql ="create table performance(id varchar(10)," + 
					"password varchar(10))"; 
			stmt.executeUpdate(sql); 

			start=System.currentTimeMillis(); // 현재 시간을 ms 단위로 가져옴
			for(int i=0;i<10000;i++){ 
				stmt.executeUpdate("insert into performance values" 
				+"('"+i+"','"+i+"')"); 
				}

			end = System.currentTimeMillis(); // 끝난 시간 저장 
			System.out.println("Statement process time = " 
					+(end - start));
			
			// ==== PreparedStatement로 같은 기능 수행

			sql ="insert into performance values(?,?)"; // 구조 미리 만들고 값만 바꿔가면서 사용
			pstmt = con.prepareStatement(sql); 

			start = System.currentTimeMillis(); 
			for(int j=0;j<10000;j++){ 
				pstmt.setString(1,""+j); 
				pstmt.setString(2,""+j); 
				pstmt.executeUpdate(); 
			} 
			end = System.currentTimeMillis();

			System.out.println("PreparedStatement process time = " 
					+(end - start)); 
			stmt.executeUpdate("drop table performance"); 
		}catch(SQLException ee){ 
			ee.printStackTrace(); 
		}finally{ 
			try { 
				if(pstmt != null) pstmt.close(); 
				if(stmt != null) stmt.close(); 
				if(con != null) con.close(); 
			}catch(SQLException se){} 
		} 
	} 
}
