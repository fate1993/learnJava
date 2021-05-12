package day0511.example7;

public class Company {
	public static void main(String[] args) {
		Employee[] employees = new Employee[2]; 
		// 1번의 사용 데이터를 기반으로 객체를 생성하여 배열에 넣는다.
		Secretary se = new Secretary("Hilery", 1, "secretary", 800);
		Sales sa = new Sales("Clinten", 2, "sales", 1200);
		
		employees[0] = se;
		employees[1] = sa;
		
		// 모든 객체의 기본 정보를 출력한다(for문 이용)
		System.out.println("name\t"+"department\t"+"salary");
		System.out.println("----------------------------");
		for(int i = 0; i<employees.length; i++) {
			System.out.println(employees[i].getName()+"\t"+employees[i].getDepartment()+"\t"+employees[i].getSalary());
		}
		// 모든 객체에 인센티브 100씩 지급한 급여를 계산하고 다시 객체의 salary에 넣는다.
		se.incentive(100);
		sa.incentive(100);
		// 모든 객체 정보와 세금을 출력한다(for문 이용)
		System.out.println("인센티브 100 지급");
		System.out.println("name\t"+"department\t"+"salary\t"+"tax");
		System.out.println("----------------------------");
		for(int i = 0; i<employees.length; i++) {
			System.out.println(employees[i].getName()+"\t"+employees[i].getDepartment()+"\t"+employees[i].getSalary()+"\t"+employees[i].tax());
		}
	}
}