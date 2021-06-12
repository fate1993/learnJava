package day0524.io;

import java.util.*;
import java.io.*;
public class ScannerFileEx {
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:\\test\\scan.txt"));
			while (scan.hasNextDouble()) {
				// 더블타입으로 바꿀 수 있는 토큰이라면
				System.out.printf("double : %,.2f %n" ,
						scan.nextDouble());
				// 더블타입으로 꺼내오고 그 값을 %,.2로(소숫점 2번째 자리까지) 출력
			}
			//scan.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
	}
}
