package day0430.forex;

public class ForEx2 {
	public static void main(String[] args) {
		//0~99까지 순서대로 출력하는 for문을 작성하세요
		
		for(int i=0; i<100; i++) {
			System.out.println(i);
		}
		
		//1~100까지 순서대로 출력하는 for문을 작성하세요
		for(int i=1; i<=100; i++) {
			System.out.println(i);
		}
		//1~100까지 숫자중에 4의 배수만 출력하세요
		for(int i=1; i<=100; i++) {
			if(i%4==0) {
				System.out.println(i);
			}
		}
		// 1~100까지 숫자중에 짝수만 출력하세요(for/if)
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				System.out.println(i);
		}
		}
		// 1~100까지 숫자중에 짝수만 출력하세요(for문만)
		for(int i=2; i<=100; i+=2) {
			System.out.println(i);
		}
	}
}
