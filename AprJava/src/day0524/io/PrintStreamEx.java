package day0524.io;

import java.io.*;

public class PrintStreamEx {
	public static void main(String[] args) {
		
		PrintStream ps = null;
		try(FileOutputStream fos = new FileOutputStream("C:\\test\\printStream.txt");
				// app에서 file로 내보낼 수 있는 stream을 만듬 
			BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			// 그 stream을 받아서 buffer가 꽉차면 내용을 보낼 수 있도록 해줌
			// 대용량 데이터를 편하게 사용
			
			ps = new PrintStream(bos, true);
			// 버퍼의 남은 부분도 모두 보내고 어떤 타입의 데이터건 출력할 수 있는 printstream 사용
			ps.println("sol");
			ps.println(1234);
			ps.println(true);
			ps.println('a');
			// 모두 문자열로 저장됨
		} 
		// try 블럭이 끝나면 close 됨. 때문에 별도 finally 안해도 되는 것
		// 버퍼에 남아있는 내용은 파일에 찍힘
		catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
