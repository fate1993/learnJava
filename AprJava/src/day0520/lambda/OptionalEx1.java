package day0520.lambda;
import java.util.*;
import java.util.stream.*;

class OptionalEx1 {
	public static void main(String[] args) {
		Optional<String>  optStr = Optional.of("abcde");
		Optional<Integer> optInt = optStr.map(String::length); // 배열의 길이 5 저장
		System.out.println("optStr="+optStr.get());
		System.out.println("optInt="+optInt.get());

		int result1 = Optional.of("123")
							  .filter(x->x.length() >0) // 문자가 있으면
							  .map(Integer::parseInt).get(); // int형으로 형변환

		int result2 = Optional.of("")
							  .filter(x->x.length() >0) // 필터 통과 못함
							  .map(Integer::parseInt).orElse(-1); // orElse >> null이면 -1. 만약 get()으로 꺼내오면 예외 발생

		System.out.println("result1="+result1);
		System.out.println("result2="+result2);

		Optional.of("456").map(Integer::parseInt)
					      .ifPresent(x->System.out.printf("result3=%d%n",x));

		OptionalInt optInt1  = OptionalInt.of(0);   // 0을 저장
		OptionalInt optInt2  = OptionalInt.empty(); // 빈 객체를 생성

		System.out.println(optInt1.isPresent());   // true
		System.out.println(optInt2.isPresent());   // false
		
		System.out.println(optInt1.getAsInt());   // 0
//		System.out.println(optInt2.getAsInt());   // NoSuchElementException
		System.out.println("optInt1 ="+optInt1);
		System.out.println("optInt2="+optInt2);
	     	System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2));
	
		Optional<String> opt  = Optional.ofNullable(null); // null을 저장
		Optional<String> opt2 = Optional.empty();          // 빈 객체를 생성
		System.out.println("opt ="+opt);
		System.out.println("opt2="+opt2);
		System.out.println("opt.equals(opt2)?"+opt.equals(opt2)); // true

		int result3 = optStrToInt(Optional.of("123"), 0);
		int result4 = optStrToInt(Optional.of(""), 0);

		System.out.println("result3="+result3);
		System.out.println("result4="+result4);
	}

	static int optStrToInt(Optional<String> optStr, int defaultValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		} catch (Exception e){
			return defaultValue;
		}			
	}
}