package day0429.ifelse;

import java.util.Scanner;

public class IfEx6 {
	public static void main(String[] args) {
		// 3과목의 시험 점수를 입력하면 총점, 평균, 학점을 출력하는 프로그램
		// 평균이 97점 이상이면 A+ 평균이 96~94는 A 93~90 사이라면 A-,
		// 80점 이상이면 B, 70점 이상이면 C
		// 그 미만이면 F.

		Scanner scan = new Scanner(System.in);
		System.out.println("100점까지만 입력할 수 있습니다.");
		System.out.print("과목1 : ");
		int first = scan.nextInt();

		System.out.print("과목2 : ");
		int second = scan.nextInt();

		System.out.print("과목3 : ");
		int third = scan.nextInt();

		int sum = first + second + third;
		double avg = sum / 3.0;
		String grade;

		if (avg >= 90) {
			grade = "A";
			if (avg>=97) {grade+="+";}
			if (avg<=93) {grade+="-";}
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else {
			grade = "F";
		}
		System.out.println("총점 : " + sum + " \n평균 : " + String.format("%,.1f", avg) + " \n학점 : " + grade);
	}
}
