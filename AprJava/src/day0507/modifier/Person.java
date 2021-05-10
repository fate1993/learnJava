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
	private int registrationNumber;
	
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
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	
	
	
	
}
