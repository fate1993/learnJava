package day0524.io;

import java.io.*;

public class BufferedOutputStreamEx {
	public static void main(String[] args) {
//		FileOutputStream fos = null;
//		BufferedOutputStream bos = null;
		
		try(FileOutputStream fos = new FileOutputStream("C:\\test\\bufferOut.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			// try 안에 객체 생성해도 괜찮음. 코드 짧아짐
			String str = "BufferedOutputStream Test 입니다.";
			// 문자열 만들고
			bos.write(str.getBytes());
			// 바이트 배열로 바꿈. 그리고 1byte씩 
			bos.flush();
			// 버퍼에 남아있는 내용까지 다 보낼 수 있도록함
			// BufferedOutputStream 사용할 땐 flush까지 써줘야함

		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
