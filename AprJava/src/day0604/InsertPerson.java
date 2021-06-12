package day0604;

import java.sql.*; // sql import
import java.text.SimpleDateFormat;

public class InsertPerson {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // OracleDriver 로드
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 사용할 객체 선언 
		
		try {
			// connection 객체 생성(url, 계정명, 비밀번호). 오라클에 있는 c##scott 계정과 연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"c##scott", 
					"tiger");
			stmt = con.createStatement(); // Statement 객체 생성
			
			//person테이블에 이름은 scott, 생일은 현재시간을 저장
			String sql = "insert into person values('scott',sysdate)"; // sql문 객체에 저장
			int i = stmt.executeUpdate(sql); // 저장한 객체 실행 insert >> executeUpdate. 받아올 타입은 int 
			if(i == 0) {System.out.println("삽입 실패"); // i = 0 >> 삽입 실패
			} else {System.out.println("삽입 성공");}
			
			// ===== insert into로 데이터 저장
			
			String sql2 = "select * from person"; // sql문 객체에 저장
			rs = stmt.executeQuery(sql2);  // 저장한 객체 실행 select >> executeQuery
			
			while(rs.next()) { // 커서로 한줄씩 
				String name = rs.getString("name"); // varchar2 타입은 getString으로 꺼내옴
				java.util.Date birth = rs.getTimestamp("birth");
				// date 타입은 getDate로 꺼내옴. java.sql.* 안에도 date 타입이 있음. 그래서 java.util.Date라고 정확히 명시
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				System.out.println(name+" : "+sdf.format(birth));
			}
			
			// ==== select * from 으로 저장된 데이터 확인
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(stmt != null) { try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			if(rs != null) {try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
	}
}















