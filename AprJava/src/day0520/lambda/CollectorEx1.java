package day0520.lambda;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class CollectorEx1 {
	public static void main(String[] args) {
		String[] strArr = { "aaa","bbb","ccc" };
		Stream<String> strStream = Stream.of(strArr);

		String result = strStream.collect(new ConcatCollector());//Collector구현 객체

		System.out.println(Arrays.toString(strArr));
		System.out.println("result="+result);
	}
}
//여기에 지정된 방법으로 스트림의 요소를 수집한다.
class ConcatCollector implements Collector<String, StringBuilder, String> {
	@Override
	public Supplier<StringBuilder> supplier() {
		return () -> new StringBuilder();
//		return StringBuilder::new;
	}

	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
		return (sb, s) -> sb.append(s);
//		return StringBuilder::append;
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		return sb -> sb.toString();
//		return StringBuilder::toString;
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		return (sb, sb2)-> {
			sb.append(sb2);
			return sb;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}
}
