package day0524.io;

import java.net.*;
import java.io.*;
import java.util.*;

public class ScannerURLConnectionEx {
	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner scan = null;
		try {
			urlCon = new URL("https://docs.oracle.com/javase/8/docs/api/").openConnection();
			scan = new Scanner(urlCon.getInputStream());
			scan.useDelimiter("\\z");
			String text = scan.next();
			System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
	}
}