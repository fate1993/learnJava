package day0608.examsolve;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 2-1. 숫자 1이 입력되면 회원정보가 저장될 hoewon테이블 생성한다.
	public void createMember(ConnectionPool cp) {
		String sql = "create table hoewon(id varchar(20) primary key," + "	password varchar(20) not null,"
				+ " name varchar(20) not null," + "email varchar(100))";
		try {
			con = cp.getConnection(); // connection pool에서 connection을 꺼내옴
			pstmt = con.prepareStatement(sql); // PreparedStatement에 cp 이용해서 해당 sql문 저장
			pstmt.executeUpdate(); // pstmt에 저장한 sql 실행(create 문이니까 executeUpdate)
			
			// ConnectionPool >> Connection >> prepareStatement / executeUpdate
			
		} catch (SQLException e) {
			System.out.println("테이블이 이미 있습니다.");
			e.printStackTrace();
		} finally {
			MemberEx.close(cp, con, pstmt);
		}
	}

	// 2-2. 숫자 2가 입력되면 화면에 id, password, name, email값들을 입력하고 입력된 값을 DB에 insert한다.
	
	public int insertMember(ConnectionPool cp, MemberDto dto) {
		int i = 0;
		try {

			con = cp.getConnection();

			pstmt = con.prepareStatement("insert into hoewon values(?,?,?,?)");
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());

			i = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			MemberEx.close(cp, con, pstmt);
		}
		return i;
	}

	// insert 하기 전에 해당 아이디 있는지부터 확인
	public int confirmId(ConnectionPool cp, String id) {
		int x = -1;
		try {
			con = cp.getConnection();
			pstmt = con.prepareStatement("select * from hoewon where id = ?");
			pstmt.setString(1, id); // 전달받아온 id 값으로 ?에 대입
			rs = pstmt.executeQuery();

			if (rs.next()) { // 레코드가 있으면
				x = 1;// 아이디 있음
			}
			MemberEx.close(cp, con, pstmt, rs);
		} catch (SQLException e) {
		}
		return x;
	}

	//
	public void loginMember(ConnectionPool cp, String id, String password) throws IOException, SQLException {

		try {
			con = cp.getConnection(); // connection pool에서 getConnection 꺼내옴
			pstmt = con.prepareStatement("select id,password from hoewon where id=? AND password=?");
			// connection으로 prepareStatement 기능 사용해서 sql문 작성하고 pstmt에 저장
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			// pstmt로 받아온 두 값(id, password) 세팅

			rs = pstmt.executeQuery();
			// select 문이니까 실행하고 rs 타입으로 저장

			if (rs.next()) { // 레코드 있는 경우
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}

		} 
		
		finally {
			MemberEx.close(cp, con, pstmt, rs);
		}
	}

	public int updateName(ConnectionPool cp, String id, String name) throws IOException, SQLException {
		try {

			con = cp.getConnection();
			pstmt = con.prepareStatement("update hoewon set name=? where id=?");
			pstmt.setString(1, name);
			pstmt.setString(2, id);

			int i = pstmt.executeUpdate();
			return i;
		} 
		finally {
			MemberEx.close(cp, con, pstmt);
		}
	}

	public void selectPwd(ConnectionPool cp, String id, String name) throws IOException, SQLException {
		try {

			con = cp.getConnection();
			pstmt = con.prepareStatement("select password from hoewon where id=? AND name=?");
			pstmt.setString(1, id);
			pstmt.setString(2, name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("password ::: " + rs.getString("password"));
			} else {
				System.out.println("id나 이름이 틀림");
			}

		} finally {
			MemberEx.close(cp, con, pstmt, rs);
		}
	}

	public int deleteMember(ConnectionPool cp, String id, String password) throws IOException, SQLException {
		try {
			con = cp.getConnection();
			pstmt = con.prepareStatement("delete from hoewon where id=? AND password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			int i = pstmt.executeUpdate();

			return i;
		} finally {
			MemberEx.close(cp, con, pstmt, rs);
		}
	}

}
