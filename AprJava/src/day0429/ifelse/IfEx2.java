package day0429.ifelse;

import java.util.Scanner;

public class IfEx2 {

	public static void main(String[] args) {
		// 나이를 입력받아서 20 이상이면 성인입니다.라는 문장을 출력함
		// 아니면 미성년자입니다.라는 문장을 출력함
		System.out.print("나이를 입력하세요(숫자)");
		// 입력받는 스캐너 생성
		Scanner scan = new Scanner(System.in);
		// 입력한 값을 읽어오고 변수에 저장
		int age = scan.nextInt();
		// if
		if (age >= 20) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년자입니다.");
		}
		System.out.println("프로그램 끝!!");

	}

}
