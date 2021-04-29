package day0428.variable;

public class Casting {
	public static void main(String[] args) {
		
		short s = 10; // 2byte
		float f = 3.5f + s;// 4byte
		//타입이 다르다 >> 작은 데이터 타입이(s) 큰 데이터 타입(f)로 바뀐다(프로모션)
		
		System.out.println("f의 값은 "+f+"입니다.");
		System.out.println("===================");
		
		short s1, s2;
		s1 = s2 = 10;
		//short s3 = s1 + s2;
		int s3 = s1 + s2;
		//java에서는 4byte 미만의 연산은 무조건 int형 변환 후 계산함
		
		System.out.println(s3);
		
		int data = 10;
		int divide = 3;
		
		System.out.println("10/3 = "+((double)data/divide)); // divide는 자동으로 double로 바뀜
		
	}
}
