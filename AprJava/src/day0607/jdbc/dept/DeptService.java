package day0607.jdbc.dept;

import java.util.List;
import java.util.Scanner;

// sacnner로 입력값 전달받아서 deptDao에 보내주는 클래스
public class DeptService {

	DeptDao dao = new DeptDao();
	// Dao를 호출하는 것이 목적 >> DeptDao 객체 생성, 호출
	
	public void updateDept() {
		DeptDto dto = new DeptDto();
		Scanner scan = new Scanner(System.in);
		System.out.print("부서번호를 입력하세요 ");
		dto.setDeptno(scan.nextInt());
		System.out.print("근무 위치를 입력하세요 ");
		dto.setLoc(scan.next());
		
		int x = dao.updateDept(dto);
		if(x == 0) {
			System.out.println("해당 번호의 부서는 없습니다");
		} else {
			System.out.println("수정됐습니다");
		}
	}
	
	public void insertDept() {
		DeptDto dto = new DeptDto();
		Scanner scan = new Scanner(System.in);
		System.out.print("부서번호를 입력하세요 ");
		dto.setDeptno(scan.nextInt());
		System.out.print("부서이름을 입력하세요 ");
		dto.setDname(scan.next());
		System.out.print("근무 위치를 입력하세요 ");
		dto.setLoc(scan.next());
		// dto 객체에 scanner 통해 입력한 값 모두 저장
		
		int x = dao.insertDept(dto);
		if(x == 0) {
			System.out.println("부서번호가 중복돼 저장되지 않습니다");
		} else {
			System.out.println("부서번호가 저장됐습니다");
		}
	}
	
	public void selectAll() {
		List<DeptDto> list = dao.selectAll(); // 호출
		if(list.size() != 0) {
			// 사이즈가 0이 아니다 >> 레코드가 있다
			for(DeptDto dto : list) {
				System.out.println(dto);
			}
		} else {
			System.out.println("부서가 1도 없습니다");
		}
	}
	
	public void selectOne() {
		Scanner scan = new Scanner(System.in);
		System.out.println("부서번호를 입력하세요");
		int deptno = scan.nextInt(); // 입력한 번호 읽어옴
		DeptDto dto = dao.selectOne(deptno); // DeptDao에 번호 넣어서 호출해줌
		
		if(dto != null) {
			// 레코드에 없는 값을 호출할 경우
			System.out.println(dto);
		} else {
			System.out.println("선택하신 부서는 없습니다.");
		}
	}
}