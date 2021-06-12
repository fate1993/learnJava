package day0524.io;

import java.util.*;

public class ScannerConsoleEx {
	public static void main(String[] args) {
		System.out.print("입력 : ");
		Scanner scan = new Scanner(System.in);
		/*int number = scan.nextInt();
		System.out.printf("입력 : %d", number);*/
		String str = scan.nextLine();
		System.out.println(str);
		
		scan.close();
	}
}
