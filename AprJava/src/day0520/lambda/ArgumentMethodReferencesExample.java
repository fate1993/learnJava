package day0520.lambda;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		// static 메서드 부르는 것처럼 쓰지만 instance 메서드가 호출 됨??
		function = (a, b) -> a.compareToIgnoreCase(b); // 대소문자 무시하고 문자열 크기 비교
		print(function.applyAsInt("Java8", "JAVA8"));

		function = String::compareToIgnoreCase;
		print(function.applyAsInt("Java8", "JAVA8"));
	}

	public static void print(int order) {
		if (order < 0) {
			System.out.println("사전순으로 먼저 옵니다.");
		} else if (order == 0) {
			System.out.println("동일한 문자열입니다.");
		} else {
			System.out.println("사전순으로 나중에 옵니다.");
		}
	}
}