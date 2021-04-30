package day0430.forex;

public class MultiForEx3 {
	public static void main(String[] args) {
		
		//별찍기
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//대문자 A부터 Z까지 출력
		for(char i='A'; i<='Z'; i++) {
			System.out.print(i);
		}
	}
}
