package day0511.example7;

public class Secretary extends Employee implements Bonus {
	
	Secretary(){}
	Secretary(String name, int number, String department, int salary){
		super.setName(name);
		super.setNumber(number);
		super.setDepartment(department);
		super.setSalary(salary);
		//System.out.println(name+"\t"+department+"\t"+salary);
	}
	
	@Override
	double tax() {
		return salary*0.1;
	}
	@Override
	 public void incentive(int pay) {
		salary += pay*0.8;
	}
	

}
