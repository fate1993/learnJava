package day0428.operator;

public class OperEx9 {
	public static void main(String[] args) {
		
		int a = 15;
		int b = 16;
		
		String s = "";
				
		s += a > b ? (a - b) + "만큼 a가 크다" : (b - a) + "만큼 b가 크다";
		
		System.out.println(s);
	}
}
