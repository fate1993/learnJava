package day0428.variable;

public class CastingEx4 {
	public static void main(String[] args) {
		
		// 오버플로우
		byte b = 127; // byte >> -128~127
		System.out.println(b);
		// 변수가 가지고 있는 값에서 1 증가
		System.out.println(++b);
		
		int i = 2100000000;
		int i2 = 2100000000;
		System.out.println(i + i2);
		
	}
}
