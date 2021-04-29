package day0429.switchex;

import java.util.Scanner;

public class SwitchExProgram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("인원수를 입력하세요 : ");
		int num = scan.nextInt();
		
		switch (num) {
		case 1:
			num = 0;
			System.out.println("400,000원 지원합니다.");
			break;
		case 2:
			num = 0;
			System.out.println("600,000원 지원합니다.");
			break;
		case 3:
			num = 0;
			System.out.println("800,000원 지원합니다.");
			break;
		case 4:
			num = 0;
			System.out.println("1,000,000원 지원합니다.");
			break;
		default:
			break;
		}
		if(num > 4) {
			System.out.println("1,000,000원 지원합니다.");
		}
		if(num != 0) {
			System.out.println("제대로 써세요");
		}
	}
}