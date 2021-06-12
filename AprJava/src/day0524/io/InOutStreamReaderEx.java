package day0524.io;

import java.io.*;

public class InOutStreamReaderEx {
	public static String consoleInput(String input) throws IOException {
		System.out.print(input + " : ");
		InputStreamReader isr = new InputStreamReader(System.in);
		// system.in >> 입력을 받음
		// 화면에 입력된 String(1byte)를 InputStreamReader으로 2byte로 늘림
		BufferedReader br = new BufferedReader(isr);
		// 한줄 통째로 연결할 거니까 버퍼드 리더 연결
		String message = br.readLine();
		// 버퍼드 리더가 제공하는 readLine으로 한줄 통째로 읽어와서 메세지에 저장
		return message;
		// 그 값을 리턴
	}

	public static void main(String[] args) throws IOException {
		String id = consoleInput("id");
		// 변수 id 선언, 문자열 넣은 consoleInput 메서드 호출
		String password = consoleInput("password");
		// 변수 password에 문자열 넣은 consoleInput 메서드 호출
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		// 1byte 짜리를 2byte로 늘림
		out.write("id : " + id + " , password : " + password);
		// write 했을 때 한글 안깨짐
		out.close();
		// clouse 원래 하면 안됨. 이 아래부터는 System.out을 사용 못함
	}
} 







