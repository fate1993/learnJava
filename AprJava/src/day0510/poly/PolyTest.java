package day0510.poly;

class Super{
	int x = 10;
	void method() {
		System.out.println("Super.method() 실행");
	}
}

class Sub extends Super{
	int x = 20;
	@Override
	void method() {
		System.out.println("Sub.method() 실행");
	}
}

public class PolyTest {
	public static void main(String[] args) {
		
		Super s = new Sub();
		System.out.println(s.x); // 변수는 참조변수 타입을 따라감. Super s니까.(컴파일 시점에 결정) 
		s.method(); // 다형성으로 객체 다룰 때 메서드는 실제 인스턴스(new Sub())에 있는 곳을 찾아감.
		// 일반적으로 오버라이딩된 메서드가 호출된다.(실행 중 결정)
		// 왜인지 궁금하면 동적바인딩 검색.
		
		Sub sub = new Sub();
		System.out.println(sub.x); // 20
		sub.method(); // Sub.method() 실행
	}
}
