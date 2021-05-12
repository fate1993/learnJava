package day0511.example;

public class Person {
	private String name;
	private int age;
	
	Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	void print() {
		System.out.print("이름:"+getName()+" 나이: "+getAge());
	}
}

class Student extends Person {
	private int id;
	
	Student(String name, int age, int id) {
		super(name, age);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	void print() {
		super.print();
		System.out.println(" 학번: "+getId());
	}
}

class Teacher extends Person {
	private String subject;
	
	Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	void print() {
		super.print();
		System.out.println(" 과목: "+getSubject());
		}
}

class Employee extends Person {
	private String dept;
	
	Employee(String name, int age, String dept){
		super(name, age);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	void print() {
		super.print();
		System.out.println(" 부서: "+getDept());	
	}
}
