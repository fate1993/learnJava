package day0513.langex;

public class StringEx1 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		//리터럴
		
		System.out.println("String str1 = \"abc\";"); // \" > 문자열 "가 됨
		System.out.println("String str2 = \"abc\";");

		if (str1 == str2) { //true
			System.out.println("str1 == str2 ?  true");
		} else {
			System.out.println("str1 == str2 ?  false");
		}
		//저장된 문자열이 일치하는지 비교
		if (str1.equals(str2)) { //true
			System.out.println("str1.equals(str2) ?  true");
		} else {
			System.out.println("str1.equals(str2) ?  false");
		}
		System.out.println();
		
		String str3 = new String("abc"); 
		String str4 = new String("abc");
		//생성자 방식으로
		
		System.out.println("String str3 = new String(\"abc\");");
		System.out.println("String str4 = new String(\"abc\");");
		
		if(str3 == str4) { //false
			System.out.println("str3 == str4 ?  true");
		} else {
			System.out.println("str3 == str4 ?  false");
		}
		
		if(str3.equals(str4)) {//true
			System.out.println("str3.equals(str4) ?  true");
		} else {
			System.out.println("str3.equals(str4) ?  false");
		}
	}
}