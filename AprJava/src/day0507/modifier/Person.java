package day0507.modifier;

/*
private 변수 선언;
메서드를 통해서 값을 저장 -> setter
세터의 기본형식. 무조건 정해진 형식대로 사용해야한다.
public void set변수명(타입 변수) {
	this.변수 = 변수;
}
메서드를 통해서 값을 추출 -> getter
public 타입 get변수명() {
return 변수;
}
*/

class Person {
	private String name;
	private int age;
	private boolean run;
	
	
	public boolean isRun() {
		return run; // boolean은 값이 true/false 밖에 없기 때문에 get 대신 is를 붙임.
	}
	public void setRun(boolean run) {
		this.run = run;
	}
	public String getName() {
		return name; // name이라는 값을 꺼내옴.
	}
	public void setName(String name) {
		this.name = name; // name에 값을 저장함.
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
}
