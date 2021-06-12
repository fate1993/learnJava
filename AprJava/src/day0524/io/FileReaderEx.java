package day0524.io;

import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {		
		try (FileReader fr= new FileReader("C:\\test\\test.txt");){
			// 2byte씩 읽어오는
			int readChar;
			while ((readChar = fr.read()) != -1) {
				System.out.print((char) readChar);
				// char로 바꿔서 출력
				// 2byte 읽어온 것 출력하지만 한글 안 깨짐
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
	}
}

/*
 * //read(char[] cbuf) �޼��� ��� char[] cbuf = new char[100]; int totalReadCount =
 * fr.read(cbuf); System.out.println(new String(cbuf));
 * System.out.println("totalReaderCount : "+ totalReadCount);
 */
/*
 * //read(char[] cbuf, int start, int length) char[] b = new char[100]; int
 * totalReadCount = fr.read(b,10,23); System.out.println(new String(b));
 * System.out.println("totalReaderCount : "+ totalReadCount);
 */

