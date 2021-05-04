package day0504.method;

class Student {
	static String name;
	static int ban;
	static int no;
	static int kor;
	static int eng;
	static int math;
	
	static int getTotal() {
		return kor+eng+math;
	}
	static double getAverage() {
		return (kor+eng+math)/3.0;
	}
}

public class Example4 {
	public static void main(String[] args) {
		Student score = new Student();
		Student.ban=1;
		Student.no=1;
		Student.name="홍길동";
		Student.kor=100;
		Student.eng=70;
		Student.math=70;
		
		System.out.println("이름: "+Student.name);
		System.out.println("총점: "+Student.getTotal());
		System.out.println("평균: "+Student.getAverage());
	}
}