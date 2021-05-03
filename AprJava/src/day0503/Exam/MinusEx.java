package day0503.Exam;

import java.util.Scanner;

public class MinusEx {
/*
 * 두개의 숫자를 입력받아서 두 수의 차를 출력하시오
 * 단 항상 큰 숫자에서 작은 숫자를 빼세요
 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요. ");
		int num1 = scan.nextInt();
		System.out.print("두번째 숫자를 입력하세요. ");
		int num2 = scan.nextInt();
		int num3 = 0; //두 수의 차이
		
		if(num1 > num2) {
			num3 = num1-num2;
		} else {
			num3 = num2-num1;
		}
		
		System.out.println("두 수의 차는 "+num3+"입니다.");
	}
}
