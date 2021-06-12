package day0524.io;
// Customer 클래스와 연결
import java.io.*;

public class ObjectInOutputStreamEx {
	public static void main(String[] args) {

		try (FileOutputStream fos = new FileOutputStream("C:\\test\\object.ser");
				// 객체를 기록해두는 파일
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				// 내보낼 것이기 때문에 ObjectOutputStream 연결
			FileInputStream fis = new FileInputStream("C:\\test\\object.ser");
				// 복원시키기 위해서 FileInputStream 객체 생성
			ObjectInputStream ois = new ObjectInputStream(fis);
				// 객체 읽어올 거니까 ObjectInputStream 연결
			) {

			oos.writeObject(new Customer("su"));
			// 파일에 저장됐고

			Customer m = (Customer) ois.readObject();
			// 기록해놨던 걸 그대로 가져와서 원본 타입으로 만들어줌
			System.out.println(m);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} 
	}
}