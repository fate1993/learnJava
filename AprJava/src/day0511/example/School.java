package day0511.example;

public class School {
	public static void main(String[] args) {
		
		Person s = new Student("홍길동학생", 24, 25000);
		Person t = new Teacher("홍길동강사", 30, "자바");
		Person e = new Employee("김길동관리자", 40, "교무과");
		// Person 타입의 참조변수로 호출. 
		s.print(); // 여기서의 print()는 객체 안에 있는 메서드 호출
		t.print();
		e.print();
	}
}