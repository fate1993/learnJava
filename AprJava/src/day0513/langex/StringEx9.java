package day0513.langex;
//많이 쓰이는 메서드
public class StringEx9 {
	public static void main(String[] args) {
		String fullName = "Hello.java";

		int index = fullName.indexOf(".");
		// indexOf() : 문자열의 시작 인덱스를 리턴
		// 문자열안에 해당 문자가 없으면 -1을 리턴 -> 해당 문자열을 가지고 있는지 확인하는 용도로 많이 사용됨

		System.out.println(index);
		String fileName = fullName.substring(0, index);
		// substring(b,e) : b부터 e-1번째까지 추출
		// substring(b) : 	b부터 끝까지 추출
		String ext = fullName.substring(index + 1);

		System.out.println(fullName + "의 확장자를 제외한 이름은 " + fileName);
		System.out.println(fullName + "의 확장자는 " + ext);
	}
}