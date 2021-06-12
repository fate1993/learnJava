package day0524.io;

import java.io.*;

public class BufferedInputStreamEx {
	public static void main(String[] args) {

		try (FileInputStream fis =new FileInputStream("C:\\test\\test.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);){
			// 성능을 향상시키는 BufferdInputStream
			int readbyte = 0;
			while ((readbyte = bis.read()) != -1) {
				System.out.print((char) readbyte);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
	}
}
