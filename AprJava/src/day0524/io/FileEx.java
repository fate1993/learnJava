package day0524.io;

import java.io.*;

public class FileEx {
	public static void main(String[] args) throws IOException {
		// 예외처리를 해줘야 출력 메서드를 사용할 수 있음. 아니면 컴파일 에러
		String filePath = "c:\\";
		// c드라이브 경로. 모든 이름을 확인
		File f1 = new File(filePath);
		// 파일 객체를 생성
		String list[] = f1.list();
		// 하위 폴더 이름, 가지고 있는 파일명 String 배열로 받아옴
		for (int i = 0; i < list.length; i++) {
			// 배열 안에 있는 길이만큼 반복
			File f2 = new File(filePath, list[i]);
			// c드라이브 안에 있는 파일, 폴더를 기준으로 새로운 파일 객체를 생성
			if (f2.isDirectory()) {
	System.out.printf("%s : 디렉토리%n", list[i]);
	// 폴더면 디렉토리
			} else {
	System.out.printf("%s : 파일(%,dbyte)%n", list[i], f2.length());
	// 폴더가 아니라면 파일. 그리고 파일의 크기를 구하기
			}
		}
		File f3 = new File("C:\\test\\test.txt");
		// 경로 가진 파일 객체 생성. 경로를 저장
		System.out.println(f3.createNewFile());
		// 해당 경로에 파일 없으면 true 리턴하면서 파일 생성
		System.out.println(f3.getAbsolutePath());
		// 파일 객체를 저장한 경로 가져오기. 소문자로
		System.out.println(f3.getCanonicalPath());
		System.out.println(f3.getPath());
		// 주로 getPath를 많이 씀. 저장한 모양 그대로 가져옴
		System.out.println(f3.getName());
		System.out.println(f3.getParent());
		File f4 = new File("C:\\test\\test.txt");
		// 해당경로에 있는 파일 가리킴
		File f5 = new File("C:\\test\\test1.txt");
		// 해당 경로에 파일 만듬
		System.out.println(f4.renameTo(f5));
		// f4가 가리키고 있는 파일을 f5가 가리키는데로 바꿈. 바꿀 수 있으면 true, 없으면 false 리턴
	}
}

















