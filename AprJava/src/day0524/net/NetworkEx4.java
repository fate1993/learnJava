package day0524.net;

import java.net.*;
import java.io.*;
// 주소에 있는 html 웹문서를 읽어들이는 예제
public class NetworkEx4 {
	public static void  main(String args[]) {
		URL url = null;
		BufferedReader input = null;
		String address = "https://www.naver.com/";
		String line = "";

		try {
			url = new URL(address);

			input = 
				new BufferedReader(new InputStreamReader(url.openStream()));
			// 웹문서에 inputstream 연결 >> InputStreamReader로 2byte로 변경 >> BufferedReader 연결

			while((line=input.readLine()) !=null) {
				// 한줄씩 저장해서 line에 저장. line이 null이 아니면
				System.out.println(line);
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
