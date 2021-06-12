package day0524.io;
import java.io.*;

// DataInputStream, DataOutputStream은 데이터를 알아서 변환해줌
public class DataOutputStreamEx {
	public static void main(String args[]) throws IOException {
		FileInputStream fis = null;
		DataInputStream dis = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("C:\\test\\dataOut.txt");
			dos = new DataOutputStream(fos);
			dos.writeBoolean(true);
			dos.writeInt(20000);
			dos.writeChar('T');
			dos.writeDouble(290.45);
			// 타입별로 읽어올 수 있는 데이터 확인
			dos.writeUTF("한글");
			// 글자를 보낼 때 한글 char를 보냄 
			fis = new FileInputStream("C:\\test\\dataOut.txt");
			dis = new DataInputStream(fis);
			System.out.println(dis.readBoolean());
			System.out.println(dis.readInt());
			System.out.println(dis.readChar());
			System.out.println(dis.readDouble());
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
				if (dis != null) dis.close();
				if (fos != null) fos.close();
				if (dos != null) dos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}
}