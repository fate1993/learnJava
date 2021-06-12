package ncs.exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ProfessorService {
	ProfessorDao dao = new ProfessorDao();

	public void insertProfessor(ncs.exam2.ConnectionPool cp) {
		ProfessorDto dto = new ProfessorDto();
		dto.setName(StringInput("name"));
		dto.setUserid(StringInput("userid"));
		dto.setPosition(StringInput("position"));
		dto.setSal(intInput("sal"));
		dto.setHiredate(dateInput("hiredate"));
		dto.setComm(intInput("comm"));
		dto.setDeptno(intInput("deptno"));

		int i = dao.insertProfessor(cp, dto);

		if (i == 0) {
			System.out.println("입력 실패");
		} else {
			System.out.println("입력 성공");
		}
	}

	private String StringInput(String input) {
		BufferedReader br = null;
		String message = null;
		try {
			System.out.print(input + " : ");
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			message = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message; // 받아온 message 반환. 사용자가 입력한 id값 얻음
	}

	private int intInput(String input) {
		int number = 0;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println(input + " : ");
			number = scan.nextInt();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}

	private Date dateInput(String input) {
		Date date = null;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println(input + " : ");
			input = scan.nextLine();
			date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void raiseSal(ncs.exam2.ConnectionPool cp) {
		double rate = (intInput("연봉 인상률") / 100);
		dao.raiseSal(cp, rate);
	}
	
	public void deleteProfessor(ncs.exam2.ConnectionPool cp) {
		int profno = intInput("pnrofo :");
		String name = StringInput("name : ");
		
		int i = dao.deleteProfessor(cp, profno, name);
		
		if (i != 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
}
