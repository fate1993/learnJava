package day0428.operator;

public class OperEx6 {
	public static void main(String[] args) {
		int a = 10; // 1010
		int b = 7; // 0111
		
		int c = a & b; // 0010
		System.out.println("변수 c의 값 : " + c);
		
		c = a | b;
		System.out.println("변수 c의 값 : " + c);
		
		c = a ^ b;
		System.out.println("변수 c의 값 : " + c);
	}
}
