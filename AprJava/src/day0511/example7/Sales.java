package day0511.example7;

public class Sales extends Employee implements Bonus{

	Sales(){}
	Sales(String name, int number, String department, int salary){
		super.setName(name);
		super.setNumber(number);
		super.setDepartment(department);
		super.setSalary(salary);
	}
	
	@Override
	double tax() {
		return salary *0.13;
	}
	@Override
	public void incentive(int pay) {
		salary += pay*1.2;
	}
}