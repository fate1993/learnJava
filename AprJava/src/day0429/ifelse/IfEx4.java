package day0429.ifelse;

import java.text.DecimalFormat;
import java.util.Scanner;

public class IfEx4 {
	public static void main(String[] args) {
		/*3 과목의 시험 점수를 입력하면 총점, 평균, 통과 여부를 출력하는 프로그램
		시험 통과 여부는 평균이 60이상이고 한과목이라도 40 미만이 없다면 ‘PASS’ 출력
		그렇지 않다면 ‘FAIL’로 출력 */
		
		/*출력 예시
				1과목 점수 입력 : 65
				2과목 점수 입력 : 30
				3과목 점수 입력 : 90
				
				총점 : 185
				평균 : 61
				통과 : Fail
		*/	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1과목 점수 입력 : ");
		int first = scan.nextInt();
		System.out.println("2과목 점수 입력 : ");
		int second = scan.nextInt();
		System.out.println("3과목 점수 입력 : ");
		int third = scan.nextInt();
		
		int sum = first + second + third;
		double avg = sum / 3.0;
		String pass = ""; // pass String으로 선언
		if(avg >= 60 && first >= 40 && second >= 40 && third >= 40) {
			pass = "Pass";
		} else {
			pass = "Fail";
		}
		
		System.out.println("총점 : " + sum + "\n평균 : " + avg + "\n통과 : " + pass);
		
		/* 내가 푼 답 
		 System.out.print("1과목 점수 입력 : ");
		Scanner scan1 = new Scanner(System.in);
		int sub1 = scan1.nextInt();
		
		System.out.print("2과목 점수 입력 : ");
		Scanner scan2 = new Scanner(System.in);
		int sub2 = scan2.nextInt();
		
		System.out.print("3과목 점수 입력 : ");
		Scanner scan3 = new Scanner(System.in);
		int sub3 = scan3.nextInt();
	
		int sum = sub1 + sub2 + sub3;
		System.out.println("총점 : "+sum);
		
		double avg = sum/(double)3;
		DecimalFormat format = new DecimalFormat("0.#");
		System.out.println("평균 : "+format.format(avg));
	
		if(sub1 >= 40 && sub2 >= 40 && sub3 >= 40 && avg >= 60) {
			System.out.println("통과 : Pass");
		} else {
			System.out.println("통과 : Fail");
		}
	*/
}
}
