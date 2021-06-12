package day0524.io;

import java.io.*;
public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("C:\\test\\bufferWriter.txt",true);
			// 여러번 실행시켰을 때 기존의 내용 남아있도록 이어주는 true
			bw = new BufferedWriter(fw);
			// 버퍼를 통해 내용을 출력. 버퍼를 사용하면 성능을 키울 수 있음
			// 버퍼는 잠시 데이터를 저장해주는 역할
			bw.write("BufferedWriter 테스트입니다.");
			bw.newLine();
			bw.write("안녕하세요" + 
					System.getProperty("line.separator"));
					// line.separator 문장이 끝났다는 의미. 이어쓰기하는 내용은 다음줄에 출력 
			bw.flush();
			// 8000자가 넘기 때문에 버퍼는 남아있음. 때문에 버퍼 내 모든 내용을 보내줘야함
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fw != null) fw.close();
				if (bw != null) bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}		
	}
}
