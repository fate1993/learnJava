package day0524.io;
// 이 방법보다는 Serializable을 더 많이 사용함
import java.io.*;

public class ExternalizableEx implements Externalizable {
	private String name;
	private int age;
	private int weight;

	public ExternalizableEx() {
	}

	public ExternalizableEx(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public void writeExternal(ObjectOutput objOutput) throws IOException {
		objOutput.writeObject(name);	
		objOutput.writeObject(age);
	//	objOutput.writeObject(weight);
	}

	public void readExternal(ObjectInput objInput)
	// 파일에 기록된 객체를 읽어올 때
			throws ClassNotFoundException, IOException {
		name = (String) objInput.readObject();
		// 1번 데이터를 받아옴 String 형변환
		age = ((Integer) objInput.readObject()).intValue();
		// 2번 데이터를 받아옴 Integer 형변환 >> int값만 꺼냄
		//weight = ((Integer) objInput.readObject());
	}

	public String toString() {
		return "name : " + name + " , age : " + age + " , weight : " + weight;
	}

	public static void main(String[] args) {
		ExternalizableEx ex1 = new ExternalizableEx("KH", 33, 70);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fos = new FileOutputStream("d:\\external.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ex1);
			fis = new FileInputStream("d:\\external.ser");
			ois = new ObjectInputStream(fis);	
			// 직렬화해서 보낸 것  
			ExternalizableEx ex2 = (ExternalizableEx) ois.readObject();
			System.out.println("���� ��ü : " + ex1);
			System.out.println("������ ��ü : " + ex2);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (ois != null)
					ois.close();
				if (fos != null)
					fos.close();
				if (oos != null)
					oos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
