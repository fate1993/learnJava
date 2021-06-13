package ncsexam22;

import java.util.Scanner;

public class ProfessorMain {

	public static void main(String[] args) {
		ProfessorService ps = new ProfessorService();
		
		boolean flag = true;
		try {
			while (flag) {
				System.out.println("1~5까지 정수 입력");
				System.out.println("1. 새로운 교수 추가");
				System.out.println("2. 교수 연봉 인상");
				System.out.println("3. 교수 정보 삭제");
				System.out.println("4. 단일 교수 정보 조회");
				System.out.println("5. 모든 교수 정보 조회");
				
				Scanner scan = new Scanner(System.in);
				int i = scan.nextInt();
				
				switch(i) {
				case 1:
					ps.insertProfessor();
					break;
				case 2:
					ps.raiseSal();
					break;
				case 3:
					ps.deleteProfessor();
					break;
				case 4:
					ps.selectOneProfessor();
					break;
				case 5:
					ps.selectAllProfessor();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("종료");
			e.printStackTrace();
		}
	}
}
