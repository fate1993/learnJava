package day0524.io;

import java.io.*;
public class BufferedReaderEx {
	public static void main(String[] args){
		
		try(FileReader fr = new FileReader("C:\\test\\test.txt");
			BufferedReader br = new BufferedReader(fr);	) {
			
			String msg;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
				// BufferedReader는 한줄씩 읽어올 수 있음
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}