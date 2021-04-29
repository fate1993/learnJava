package day0428.variable;

public class StringEx {
	public static void main(String[] args) {
	// java.lang.String 문자열을 표현하기 위해 만들어진 클래스
	String str = "문자열 표현";
	String str1 = ""; // 빈 문자열
	String str2 = " "; // 공백도 문자열
	
	// String타입은 +연산자 사용할 수 있음. 이어쓰기.
	// 다른 타입과 더할 경우 String타입이 우선권을 가진다(String데이터가 된다).
	System.out.println("A"+1); // = "A" + "1" >> A1 >> 1이 String이됨
	System.out.println('A'+1); // char(2byte) + int(4byte) >> A가 int로 바뀜 >> 65+1 
	
	// int -> String
	String s1 = 7 + ""; // int를 String으로 변환시키는 가장 쉬운 방법. + ""
	String s2 = ""+7;
	String s3 = " "+7;
	
	String s4 = 7 + 7 + ""; // 14 + ""
	String s5 = "" + 7+7; // "7" + "7"
	
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	System.out.println("s4 ="+s4);
	System.out.println("s5 ="+s5);
	
	}
}
