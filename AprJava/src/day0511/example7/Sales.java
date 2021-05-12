package day0511.example7;

public class Sales extends Employee implements Bonus{

	Sales(){}
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	double tax() {
		return getSalary() *0.13; // 가능한 getter로 불러오기
	}
	@Override
	public void incentive(int pay) {
		setSalary((int)(pay*1.2)+getSalary()); // setter로 값 대입
	}
	
	@Override // toString 오버라이드해서 사용해야.
	public String toString() {
		return getName() + "\t" + getDepartment() + "\t\t"
				+ getSalary();
	}
}