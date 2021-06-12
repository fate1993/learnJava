package day0520.lambda;
import java.util.function.*;

class LambdaEx7 {
	public static void main(String[] args) {
		Function<String, Integer>	f  = (s) -> Integer.parseInt(s, 16); // String 타입 가져와서 16진수 Integer로 반환
		Function<Integer, String>	g  = (i) -> Integer.toBinaryString(i); // 2진수로 바꾸고 String으로 반환 

		Function<String, String>	h  = f.andThen(g); // f 수행 >> g 수행
		Function<Integer, Integer>  h2 = f.compose(g); // g 수행 >> f 수행

		System.out.println(h.apply("FF")); // "FF" → 255(10) → "11111111"
		System.out.println(h2.apply(2));   // 2 → "10" → 16

// andThen은 A.andThen(B) 가 A -> B : B 최종처리
// compose는 A.compose(B) 가 B -> A : A 최종처리

		Function<String, String> f2 = x -> x; // 항등 함수(identity function)
		System.out.println(f2.apply("AAA"));  // AAA가 그대로 출력됨

		// Predicate 리턴 타입 : boolean
		Predicate<Integer> p = i -> i < 100; // int값 i를 받아와서 100보다 작으면 true
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0; 
		Predicate<Integer> notP = p.negate(); // i >= 100 성립하면 true

		Predicate<Integer> all = notP.and(q).or(r); // i >= 100 && i < 200 || i%2 == 0
		System.out.println(all.test(150));       // true

		String str1 = "abc";
		String str2 = "abc";
		
		// str1과 str2가 같은지 비교한 결과를 반환
		Predicate<String> p2 = Predicate.isEqual(str1); 
		boolean result = p2.test(str2); // Predicate이 제공하는 test 메서드 사용
		System.out.println(result);
	}
}
