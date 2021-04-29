package day0428.operator;

public class OperEx1 {
	public static void main(String[] args) {
		int a, b, c;
		a = 44;
		b = 5;
		// b = 0; ArithmeticException 예외 발생
		// 어떠한 숫자라도 0으로 나눌 수 없다.
		
		c = a / b; // 8.8 >> 8
		double d1 = a / b; // 8.8 >> 8 >> 더블형 변수에 casting해서 저장 >> 8.0
		double d2 = (double) a / b; // a > 44.0 형변환. >> b도 자동으로 형변환. 44.0 / 5.0 >> 8.8
		
		System.out.println(c);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(a % b);
		
		// String s = "100" - 10; >> error. String은 + 연산만 가능
	}
	
}
