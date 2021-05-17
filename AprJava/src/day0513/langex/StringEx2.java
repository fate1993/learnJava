package day0513.langex;

class StringEx2 {
	public static void main(String args[]) {
		String s1 = "AAA";
		String s2 = "AAA";
		String s3 = "AAA";
		String s4 = "BBB";
		
		System.out.println(s1.hashCode()); //문자열의 주소값 반환
		System.out.println(s2.hashCode());
		System.out.println(s4.hashCode());
	}
}