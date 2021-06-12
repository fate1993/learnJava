package ncs.exam2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProfessorMain {
	public static void main(String[] args) {
		ConnectionPool cp = ConnectionPool.getInstance("jdbc:oracle:thin:@localhost:1521:xe", 
				"c##myschool", 
				"myschool", 5, 10);
		ProfessorService ps = new ProfessorService();
		
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1~5까지 정수를 입력하세요");
				System.out.println("1. 새로운 교수 추가");
				System.out.println("2. 교수 연봉 인상");
				System.out.println("3. 퇴직 교수 정보 삭제");
				System.out.println("4. 교수 정보 조회");
				System.out.println("5. 모든 교수 정보 조회");
				
				Scanner scan = new Scanner(System.in);
				int i = scan.nextInt();
				
				switch(i) {
				case 1:
					ps.insertProfessor(cp);
					break;
				case 2:
					ps.raiseSal(cp);
					break;
				case 3:
					ps.deleteProfessor(cp);
					break;
				case 4:
				case 5:
					
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
