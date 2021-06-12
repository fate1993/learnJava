package day0524.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyTest {
	
	// 원본 파일 경로 가져오기
	public static String getPath() {
		System.out.println("경로 > ");
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
		// 원본 파일이 있는 폴더 경로 + 파일명을 입력받음
		// 폴더명은 공백 있을 수 있으므로 nextLine 사용
		return path;
		// 그리고 그 경로를 반환
	}
	
	// 복사본 파일의 경로 만들기
	public static String makeName(String path) {
		File orig = new File(path);
		// 원본 파일 경로를 받아와서 이를 가리키는 객체 orig 만들기
		String name = orig.getName();
		// 복사해서 저장될 파일의 이름 구하기
		return "C:\\test" + name;
		// c드라이브 test 폴더에 원본파일명으로 반환 
	}
		 
	// main에서 호출할 copy 메서드 생성
	public static void copy(String orig, String copy) {
		// 원본 파일 경로를 orig, 복사 받을 파일 경로를 copy로 받음
		try(FileInputStream fis = new FileInputStream(orig);
			BufferedInputStream bis = new BufferedInputStream(fis);
				// FileInputStream
			FileOutputStream fos = new 	FileOutputStream(copy);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
				// FileInputStream, FileOutputStream로 데이터가 지나가는 통로를 만듬
				) {
			
			byte[] readByte = new byte[fis.available()];
				// available을 통해서 크기를 크게 잡음
			
			while(bis.read(readByte) != -1) {
				// 읽어온 건 배열에 저장했다가 데이터가 있다면(-1이 아님)
				bos.write(readByte);
				// 배열에 저장한 내용을 카피 파일로 내보냄
			}
			
			File copyFile = new File(copy);
			// 복사를 받은 파일을 객체로 만들고
			if(copyFile.length() == 0) {
				System.out.println("복사 안됨");
				copyFile.delete();
				// 해당 파일을 삭제
			} else {
				System.out.println("복사 성공");
			}
			// 복사 완료
		} catch (IOException e) {
			// io 패키지에 있는 거 사용하니까 IOException 이용이 좋음
		}
	}
	
	public static void main(String[] args) {
		String orig = getPath();
		String copy = makeName(orig);
		// 오리지널 타입을 넘겨줌. 카피받을 복사본 경로를 만듬
		copy(orig, copy);
		// 첫번째 매개변수 orig, 두번째 매개변수 copy
	}
		 
		 
//	 public static void main(String[] args) {
//		 	//원본 파일경로
//	        String oriFilePath = "C:\\test\\copytest.txt";
//	        //복사될 파일경로
//	        String copyFilePath = "C:\\test\\copytest\\copytest2.txt";
//	        
//	        //파일객체생성
//	        File oriFile = new File(oriFilePath);
//	        //복사파일객체생성
//	        File copyFile = new File(copyFilePath);
//	        
//	        try {
//	            
//	            FileInputStream fis = new FileInputStream(oriFile); //읽을파일
//	            FileOutputStream fos = new FileOutputStream(copyFile); //복사할파일
//	            
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	}
}
