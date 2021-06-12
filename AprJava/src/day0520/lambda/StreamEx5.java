package day0520.lambda;
import java.util.*;
import java.util.stream.*;

class StreamEx5 {
	public static void main(String[] args) {
		String[] strArr = {
			"Inheritance", "Java", "Lambda", "stream",
			"OptionalDouble", "IntStream", "count", "sum"
		};

		Stream.of(strArr).forEach(System.out::println);

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
		Optional<String> sWord = Stream.of(strArr)
							           .filter(s->s.charAt(0)=='s').findFirst();
										// 조건. 문자열 0번 인덱스가 소문자 s.
		System.out.println("noEmptyStr="+noEmptyStr);
		System.out.println("sWord="+ sWord.get());

		// Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
								// 안에 있는 요소를 인트형의 길이로 바꿈. 
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		//reduce a : 초기값 저장, b : 스트림 요소를 하나씩 저장
		int count = intStream1.reduce(0, (a,b) -> a + 1);
									//초기 값을 a에 저장,b가 꺼내고. 스트림 요소가 있을때마다 +1.
		int sum   = intStream2.reduce(0, (a,b) -> a + b);
		/*						// a가 가지고 있는 값에 b가 가지고 있는 값만큼 더해나감. 전체 문자의 개수 나옴.
		 * 위 코드 풀어서 쓰면
		 * int a = 0; 
		 * for(int b : intStream1) { a + b; }
		 */
		OptionalInt max = intStream3.reduce(Integer::max); 
								// max값을 쉽게 구현. 
		OptionalInt min = intStream4.reduce(Integer::min);

		System.out.println("count="+count);
		System.out.println("sum="+sum);
		System.out.println("max="+ max.getAsInt());
									// Optional은 getAsInt로 사용해야함 
		System.out.println("min="+ min.getAsInt());
	}
}
