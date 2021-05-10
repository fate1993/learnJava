package day0507.importex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {
	public static void main(String[] args) {
		Date d = new Date(); // 실행한 날짜와 시간을 가지고 있는 객체 생성
		// System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a"); 
		String now = sdf.format(d);
		System.out.println("실행시간 > "+now);
	}
}
