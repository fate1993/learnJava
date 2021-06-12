package day0524.io;

import java.io.*;

public class FileOutputStreamEx {
	public static void main(String arg[]){
		
		try(FileOutputStream fos 
				= new FileOutputStream("C:\\test\\fileout.txt",true);) {
			// 해당 경로에 파일 찾고 없으면 만듬. 있으면 있는 곳에 스트림 연결
			// true라고 적은 건 이어쓰기를 한다는 의미
			String message = "Hello FileOutputStream!!";
			// String은 char 배열. char 배열의 한칸은 2byte
			fos.write(message.getBytes());
			// outputstream은 1byte씩 보낸다
			// 문자열을 byte 배열로 바꿈. 1byte씩 자르고 전송
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
