package day0524.io;
// fileOutputStream과 다르지 않음

import java.io.*;
public class FileWriterEx {
	public static void main(String arg[]) {
		
		try(FileWriter fw = new FileWriter("C:\\test\\fileWriter.txt");)
		// 파일 경로 지정해서 스트림 연결 2byte씩 내용을 출력할 수 있음
					// fw = new FileWriter("f:\\fileWriter.txt",true);
		{
			String message = "안녕하세요 FileWriter테스트 입니다.";
			fw.write(message);
			// 한글이 깨지지 않고 출력됨
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}