package day0524.io;

import java.util.*;
public class ScannerRegEx {
	public static void main(String[] args){
		String str = "1 and 2  and  animal  and lion and tiger";
		Scanner scan = new Scanner(str);
		scan = scan.useDelimiter("\\s*and\\s*");
		int firstToken = scan.nextInt();
		int secondToken = scan.nextInt();
		String thirdToken = scan.next();
		String fourthToken = scan.next();
		String fifthToken = scan.next();
		// 문자열들은 모두 next로 꺼냄
		System.out.printf("%d,%d,%s,%s,%s",firstToken,
				secondToken,thirdToken,fourthToken,fifthToken);
		scan.close();
	}
}
