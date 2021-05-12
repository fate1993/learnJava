package day0511.example7;

public class Secretary extends Employee implements Bonus {
	
	Secretary(){}
	Secretary(String name, int number, String department, int salary){
		super(name, number, department, salary);
	}
	
	@Override
	double tax() {
		return getSalary()*0.1;
	}
	
	@Override
	 public void incentive(int pay) {
		setSalary((int)(pay*0.8)+getSalary());
	}
	@Override
	public String toString() {
		return getName() + "\t" + getDepartment() + "\t"
				+ getSalary();
	}
}