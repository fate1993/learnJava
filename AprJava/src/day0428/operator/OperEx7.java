package day0428.operator;

public class OperEx7 {
	public static void main(String[] args){
		int a = 12;// 00001100
		int b = 2;
		
		int c = a>>b;// 00000011
		System.out.println(c);
		
		int d= a<<2;//  00110000
		System.out.println(d);	
	}
}
//x<<n의 결과는 x*2의 n승과 같다.
//x>>n 은 x/2의 n승