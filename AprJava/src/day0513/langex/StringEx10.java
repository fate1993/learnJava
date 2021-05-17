package day0513.langex;

public class StringEx10 {
	public static void main(String[] args) {
		// 문자끼리의 비교 -> 공백, 숫자, 사전순서 등으로 크다 작다 구분
		// 문자열을 비교하는 compareTo(). 첫번째 글자끼리 비교 -> 같으면 그 다음 칸 비교
		String s1 = "abc";
		String s2 = "bbc";
		
		System.out.println(s1.compareTo(s2));
		
		if(s1.compareTo(s2) > 0) {
			System.out.println("양수가 나오면 첫번째 값이 더 크다.");
		} else if(s1.compareTo(s2) == 0) {
			System.out.println("0이 나오면 둘은 같은 값이다.");
		} else if(s1.compareTo(s2) < 0) {
			System.out.println("음수가 나오면 두번째가 더 크다.");
		}
	}
}