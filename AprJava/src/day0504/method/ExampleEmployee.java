package day0504.method;

import java.util.Scanner;

class Employee {
	String no;
	String name;
	String dept;
	String job;
	int sal;
	
	//기본생성자
	Employee() {}
	//인스턴스 변수 초기화
	Employee(String no, String name, String dept, String job, int sal) {
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.sal = sal;
	}
	
}

public class ExampleEmployee {

	public static void main(String[] args) {
		Employee e1 = new Employee("A1892","박나래","총괄개발부","대리",3500);
		//매개변수가 있는 생성자를 이용해서 생성과 동시에 값을 초기화 할 수 있음. 코드가 짧아짐.
		
		/*
		 * Employee e1 = new Employee(); e1.no = "A1892"; e1.name = "박나래"; e1.dept =
		 * "총괄개발부"; e1.job = "대리"; e1.sal = 3500;
		 */

		Employee e2 = new Employee("B8077","유재석","Web개발부","부장",4500);
		
		/*
		 * Employee e2 = new Employee(); e2.no = "B8077"; e2.name = "유재석"; e2.dept =
		 * "Web개발부"; e2.job = "부장"; e2.sal = 4500;
		 */
		Employee e3 = new Employee("C5691","김동욱","Android개발부","과장",4000);
		
		/*
		 * Employee e3 = new Employee(); e3.no = "C5691"; e3.name = "김동욱"; e3.dept =
		 * "Android개발부"; e3.job = "과장"; e3.sal = 4000;
		 */

		Employee[] employees = { e1, e2, e3 };

		boolean run = true;
		Scanner scan = new Scanner(System.in);
		while (run) {

			System.out.print("사원번호 > ");

			String e_no = scan.next();

			// 입력한 사원번호에 해당되는 사원이 없다면 "해당 사원은 없습니다" 출력

			int i = 0; // 0이면 사원 없음. 0이 아니면 해당 사원 있음
			for (Employee e : employees) {
				if (e_no.equals(e.no)) {
					System.out.println(e.no + " : " + e.dept + " " + e.name + " " + e.job);
					i++;
					break;
				}
			}
			if (i == 0) {
				if (e_no.equals("exit")) {
					System.out.println("종료합니다.");
					run = false;
				} else {
					System.out.println("해당 사원은 없습니다");
				}
			}
		}
	}
}