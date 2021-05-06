package day0504.method;

class Student {
	
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	//참고로 static 변수를 사용하는 경우가 많지는 않음. 대부분 instance 변수로.
	
	int getTotal() {
		return kor+eng+math;
	}
	
	double getAverage() {
		return (getTotal())/3.0;
	} //같은 클래스에 선언된 멤버는 클래스명, 참조변수 없이 이름만으로 호출할 수 있다.
}

public class Example4 {
	public static void main(String[] args) {
		Student score = new Student();
		score.ban=1;
		score.no=1;
		score.name="홍길동";
		score.kor=100;
		score.eng=70;
		score.math=70;
		
		System.out.println("이름: "+score.name);
		System.out.println("총점: "+score.getTotal());
		System.out.println("평균: "+score.getAverage());
	}
}