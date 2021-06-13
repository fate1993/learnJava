package ncsexam22;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProfessorService {
	ProfessorDao dao = new ProfessorDao();
	
	// 교수 추가(insert)
	public void insertProfessor() {
		ProfessorDto dto = new ProfessorDto();
		Scanner scan = new Scanner(System.in);
		System.out.print("name : ");
		dto.setName(scan.next());
		System.out.print("userid : ");
		dto.setUserid(scan.next());
		System.out.print("position : ");
		dto.setPosition(scan.next());
		System.out.print("sal : ");
		dto.setSal(scan.nextInt());
//		System.out.print("hiredate : ");
		dto.setHiredate(inputDate());
		System.out.print("comm : ");
		dto.setComm(scan.nextInt());
		System.out.print("deptno : ");
		dto.setDeptno(scan.nextInt());
		
		int x = dao.insertProfessor(dto);
		if (x == 0) {
			System.out.println("저장 실패");
		} else {
			System.out.println("저장 성공");
		}
	}
	// date 타입 입력기
		private Date inputDate() {
			Date date = null;
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print("hiredate(예: 31/01/2021) : ");
			date = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());

			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
	
	// 교수 연봉 인상(update)
	public void raiseSal() {
		ProfessorDto dto = new ProfessorDto();
		Scanner scan = new Scanner(System.in);
		System.out.println("연봉 인상률(%) : ");
		double rate = (scan.nextInt()*0.01);
		
		dao.raiseSal(rate);
	}
	
	// 교수 삭제(delete)
	public void deleteProfessor() {
		ProfessorDto dto = new ProfessorDto();
		Scanner scan = new Scanner(System.in);
		System.out.print("profno : ");
		dto.setProfno(scan.nextInt());
		
		dao.deleteProfessor(dto);
	}
	
	// 단일 교수 정보 조회(select)
	public void selectOneProfessor() {
		Scanner scan = new Scanner(System.in);
		System.out.println("profno : ");
		int profno = scan.nextInt();
		ProfessorDto dto = dao.selectOneProfessor(profno);
		
		System.out.println(dto);
	}
	
	// 모든 교수 정보 조회(select)
	public void selectAllProfessor() {
		List<ProfessorDto> list = dao.selectAllProfessor();
		if(list.size() != 0) {
			for(ProfessorDto dto : list) {
				System.out.println(dto);
			} 
		} else {
			System.out.println("저장된 교수가 없습니다");
		}
	}
	
	
}
