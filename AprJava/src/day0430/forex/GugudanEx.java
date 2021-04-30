package day0430.forex;

import java.util.Scanner;

public class GugudanEx {
	public static void main(String[] args) {
		//2~9사이의 값을 입력받아 해당 구구단을 출력한다.
		//9*1=9
		//9*2=18
		//...
		System.out.println("2~9사이의 값을 입력하세요");
		Scanner scan = new Scanner(System.in);
		System.out.print("출력할 구구단은 : ");
		int i = scan.nextInt();
		
		for(int j=1; j<=9; j++) {
		int gugudan = i*j;
		System.out.println(i+"*"+j+"="+gugudan);
	}
		System.out.println("-----------");
	// 9*9=81
	// 9*8=72
	// ...
		for(int j=9; j>=1; j--) {
			int gugudan = i*j;
			System.out.println(i+"*"+j+"="+gugudan);
		}
		
}
}
