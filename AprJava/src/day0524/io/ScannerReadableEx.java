package day0524.io;

import java.io.*;
import java.util.*;
public class ScannerReadableEx {
	public static void main(String[] args) {
		Scanner scan = null;
		FileReader fr = null;
		try {
			fr = new FileReader("e:\\scan.txt");
			scan = new Scanner(fr);
			while (scan.hasNextDouble()) {
				System.out.printf("double : %,.2f %n" ,
						scan.nextDouble());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fr != null)	fr.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			if (scan != null) scan.close();
		}
	}
}
