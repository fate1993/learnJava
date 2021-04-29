package day0428.variable;

public class CastingEx2 {
	public static void main(String[] args) {
		
		byte b = 10;
		int i = b; // byte가 더 작으니까 잘 들어감. int형으로 변환. 정보 손실 없음.
		
		System.out.println("b의 값 : "+b);
		System.out.println("i의 값 : "+i);
		
		int i2 = 300;
		byte b2 = (byte)i2; // 정보의 손실 발생.
		
		System.out.println("i2의 값 : "+i2);
		System.out.println("b2의 값 : "+b2);
		
		short s1, s2;
		s1 = s2 = 10;
		short s3 = (short)(s1 +s2);
	}

}
