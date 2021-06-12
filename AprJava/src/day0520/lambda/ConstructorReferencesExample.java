package day0520.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {
	public static void main(String[] args) {
		// Member apply String s
		Function<String, Member> function1 = Member :: new; // Member(String s) 호출
		Member member1 = function1.apply("angel");
		
		BiFunction<String, String, Member> function2 = Member :: new; // :: 뒤에 new는 생성자를 호출한다는 의미. Member(String s, String s) 호출
		Member member2 = function2.apply("김천사", "angel");
	}
}
