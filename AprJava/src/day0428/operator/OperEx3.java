package day0428.operator;

public class OperEx3 {
	public static void main(String[] args){
		int a = 10;
		int b = 7;

		System.out.println(a+b); //
		System.out.println(a);// 
		
		System.out.println(a+=b);// a = a + b ;
		System.out.println(a);//
		
		int num = 0;
		num = num +3; // 같은 값이어도
		num += 3; // 대입연산자 사용하는 편이 연산 속도 더 빠름
		
	}
}
