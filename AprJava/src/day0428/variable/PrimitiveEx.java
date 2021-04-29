package day0428.variable;

public class PrimitiveEx {
	public static void main(String[] args) {
		// 타입 변수;
		boolean b = true; // 선언과 동시에 저장
		boolean b1; // 선언 후
		b1 = false; // 저장
		
		System.out.println(b); // 변수 b가 가지고 있는 값을 출력
		System.out.println("b"); // 문자열 b를 출력
		
		char c = 65;
		char c1 = 'A';
		
		System.out.println("c :: "+c);// A << 아스키코드
		System.out.println("c1 :: "+c1);// A
		
		int i = 100;
		//접미사 L을 붙이면 long 타입 데이터임을 명시할 수 있음
		long l = 100L;
		
		float f = 100;
		double d = 100;
		
		System.out.println("f :: "+f);
		System.out.println("d :: "+d);
		
		//접미사 F을 붙이면 float 타입 데이터임을 명시할 수 있음
		float f1 = 3.14F;
		System.out.println(f1);
		
		float f2 = 0.100000001f;
		double d2 = 0.100000001;
		System.out.println(f2);
		System.out.println(d2);
		
		int data = 10;
		int divide = 3;
		System.out.println("10/3 = "+(data/divide));
	}
}
