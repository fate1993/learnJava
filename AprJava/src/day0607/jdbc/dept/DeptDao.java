package day0607.jdbc.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DeptDao {
	
	// 부서번호와 변경할 위치를 입력받아 수정
	public int updateDept(DeptDto dto) {
		int x = 0;
		Connection con = GetConnection.getConnection();
		
		try {
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("update dept set loc = ? where deptno = ? ");
			pstmt.setInt(2, dto.getDeptno());
			pstmt.setString(1, dto.getLoc());
			
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	// 부서 추가
	// insert into dept values(60, '총무', '서울') 문 수행
	
	public int insertDept(DeptDto dto) {
		int x = 0; // return할 값 선언
		Connection con = GetConnection.getConnection();
		try {
			PreparedStatement pstmt 
			= con.prepareStatement("insert into dept values(?,?,?)");
			pstmt.setInt(1, dto.getDeptno()); // 1번 물음표
			pstmt.setString(2, dto.getDname()); // 2번 물음표
			pstmt.setString(3, dto.getLoc());
			
			x = pstmt.executeUpdate(); // 실행시키고 변경된 레코드 개수를 받아와서 x에 저장
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	// 모든 부서의 정보를 조회
	// select * from dept
	public List<DeptDto> selectAll() {
		// 모든 부서 정보 조회 >> 레코드 여러 줄>> dto를 여러개 담고 있는 리스트 제네릭 타입으로 리턴
		List<DeptDto> list = new ArrayList<>();
		// 리턴 타입이 List<DeptDto>인 list 변수에 ArrayList<> 객체를 선언
		Connection con = GetConnection.getConnection();
		
		try {
			PreparedStatement pstmt 
			= con.prepareStatement("select * from dept");
			ResultSet rs = pstmt.executeQuery(); // ? 없으니까 바로 실행
			
			while(rs.next()) {
				DeptDto dto = new DeptDto();
				dto.setDeptno(rs.getInt("deptno")); // number 타입 >> getInt
				dto.setDname(rs.getString("dname")); // varchar2 >> getString
				dto.setLoc(rs.getString("loc"));
				
				list.add(dto);
			}
			
			GetConnection.closed(rs, pstmt);
			GetConnection.closed(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	// 부서번호를 전달받아 해당 부서의 모든 정보를 조회
	// select * from dept where deptno = ?
	// deptno는 primary key >> 레코드 한줄만 불러옴

	public DeptDto selectOne(int deptno) {
		// return 타입 deptdtno 객체에 저장하고 반환
		Connection con = GetConnection.getConnection();
		DeptDto dto = null; // dto 변수 선언. return 해야하니 밖에 선언

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from dept where deptno = ?");
			pstmt.setInt(1, deptno);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // 한줄 꺼내오면 if로 처리
				dto = new DeptDto(); // 레코드가 있으면 객체 생성
				// 레코드에서 꺼내온 걸 dto 객체에 저장
				dto.setDeptno(rs.getInt("deptno")); // number 타입 >> getInt
				dto.setDname(rs.getString("dname")); // varchar2 >> getString
				dto.setLoc(rs.getString("loc"));
			} // dao에서 sql문을 통해 받아온 값을 dto 객체에 전달하는 코드

			GetConnection.closed(rs, pstmt);
			GetConnection.closed(con);
			// connection은 따로 사용하는 경우 많기 때문에

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
