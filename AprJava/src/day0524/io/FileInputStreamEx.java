package day0524.io;
// 시스템의 파일을 읽을 수 있음
import java.io.*;
public class FileInputStreamEx {
	public static void main(String arg[]){
		//FileInputStream fis = null;
		byte console[] = new byte[100];
		// 콘솔창에 입력한 경로를 저장할 공간. 100 byte
		byte _read[] = new byte[100];
		// 파일에서 내용을 읽어와서 저장할 공간
		System.out.print("경로 : ");
		// 화면에 경로라는 문자열 출력
		try {
			System.in.read(console);
			// read 메서드 활용. 화면과 연결된 스트림으로부터 데이터 읽어옴
			// 읽어온 건 console이라는 배열에 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
		String file = new String(console).trim();//
		// byte 배열을 하나의 문자열로 바꿈. 불필요한 공백은 trim()으로 제거
		// 이를 file에 저장
		
		try(FileInputStream fis = new FileInputStream(file);){
			// try 블록에서 객체 생성. 
			// 입력한 경로에 있는 file을 FileInputStream으로 읽고 연결
			fis.read(_read,0,_read.length);
			// 읽어올 거니까 read 메서드. 0번자리부터 배열의 크기(100byte)만큼만 읽어옴
			System.out.println(new String(_read).trim());
			// 읽어온 데이터를 문자열로 바꿈. 배열에서 비어있는 공간은 모두 잘라냄(trim)
			// 그리고 출력함
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
}




