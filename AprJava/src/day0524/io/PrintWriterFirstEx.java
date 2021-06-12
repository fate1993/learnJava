package day0524.io;
// 실제로 잘 안씀
import java.io.*;
public class PrintWriterFirstEx {
	public static void main(String arg[]) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		// 선언
		try {
			fw = new FileWriter("d:\\printWriterFirst.txt");
			// 경로 지정
			bw = new BufferedWriter(fw);
			// 버퍼 연결
			pw = new PrintWriter(bw,true);
			// 프린트라이터 연결, auto 플러시(true) 설정
			pw.println("안녕하세요");
			pw.println("반갑습니다.");
			pw.println(100);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fw != null)	fw.close();
				if (bw != null)	bw.close();
				if (pw != null)	pw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}