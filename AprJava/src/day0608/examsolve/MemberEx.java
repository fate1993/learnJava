package day0608.examsolve;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberEx {

	// close 하는 부분 3가지 선언. static으로 생성해서 호출하는 지점에서 클래스이름.메서드 이름으로 호출 가능
	public static void close( PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ConnectionPool cp, Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				cp.releaseConnection(con); // cp은 close하지 않고 cp에 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ConnectionPool cp, Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				cp.releaseConnection(con); // cp은 close하지 않고 cp에 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		ConnectionPool cp = ConnectionPool.getInstance("jdbc:oracle:thin:@localhost:1521:xe", 
				"c##scott", 
				"tiger", 5, 10); // cp 통해서 c##scott 계정 연결
		MemberService be = new MemberService(); // MemberService 객체 생성
		boolean flag = true;
		try {
			while (flag) {
			System.out.println("1~7까지 정수만 입력하세요.");
			System.out.print("1.회원 테이블 생성 ");
			System.out.print("2.회원가입 ");
			System.out.println("3.로그인 ");
			System.out.print("4.이름 수정 ");
			System.out.print("5.비밀번호 확인 ");
			System.out.print("6.회원탈퇴 ");
			System.out.println("7.종료");

			
				Scanner scan = new Scanner(System.in);

				int i = scan.nextInt();
				
				switch (i) {
				case 1:
					be.createMember(cp); // MemberService 객체로 createMember 메서드 호출
					break;
				case 2:
					String id = be.confirmId(cp); // MemberService 객체로 confirmId 메서드 호출하고 해당 값 id에 저장
					if(id != null){ be.insertMember(cp,id);} // id가 null 아닌거 확인되면 insertMember 메서드 호출
					break;
				case 3:
					be.loginMember(cp);
					break;
				case 4:
					be.updateName(cp);
					break;
				case 5:
					be.selectPwd(cp);
					break;
				case 6:
					be.deleteMember(cp);
					break;
				default:
					if (i == 7) {
						System.out.println("종료");
					} else {
						System.out.println("알맞은 번호가 아닙니다.");
					}
					flag = false; // 반복문(while) 종료 >> catch
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("종료");
			e.printStackTrace();
		} finally {
			cp.closeAll(); // 프로그램 종료하니 cp도 종료
		}

	}

}
