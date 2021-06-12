package day0524.io;

import java.io.*;

public class PrintWriterSecondEx {
	public static void main(String arg[]) {

		try (FileOutputStream fos = new FileOutputStream("e:\\printWriterSecond.txt");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				PrintWriter pw = new PrintWriter(bos, true);) {
			// printwriter은 1byte 받아올 수 있음

			pw.println("안녕하세여!!");
			pw.println("또 만났네요.");
			pw.println(100.0);
			pw.println(true);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
	}
}