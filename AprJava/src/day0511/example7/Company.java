package day0511.example7;

public class Company {
	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		// 1번의 사용 데이터를 기반으로 객체를 생성하여 배열에 넣는다.
		employees[0] = new Secretary("Hilery", 1, "secretary", 800);
		employees[1] = new Sales("Clinten", 2, "sales", 1200);

		// 모든 객체의 기본 정보를 출력한다(for문 이용)
		System.out.println("name\tdepartment\tsalary");
		System.out.println("------------------------------------");
		for (Employee e : employees) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println("인센티브 100 지급");
		System.out.println("name\tdepartment\tsalary\ttax");
		System.out.println("-----------------------------------");

		for (Employee e : employees) {
			// e.insentive(100) -> insentive 메서드는 Employee 클래스에 없음
			//에러. Employee의 매개변수 e를 insentive 메서드가 있는 Secretary, Sales 타입으로 캐스팅 필요
			if (e instanceof Secretary) { // 클래스가 두 개니까, instanceof로 각각의 경우 필터링.
				Secretary s = (Secretary) e; // 자손 -> 조상 형변환. 표시 필요.
				s.incentive(100); 
			}
			if (e instanceof Sales) {
				Sales s = (Sales) e;
				s.incentive(100);
			}
		}
		for (Employee e : employees) {
			System.out.println(e + "\t" + e.tax());
		}
	}
}