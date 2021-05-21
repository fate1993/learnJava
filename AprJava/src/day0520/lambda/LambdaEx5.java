package day0520.lambda;
import java.util.function.*;
import java.util.*;

import java.util.function.*;
import java.util.*;

class LambdaEx5 {
	public static void main(String[] args) {
		Supplier<Integer>  s = ()-> (int)(Math.random()*100)+1; // 반환값만 있는. 1~100사이 메서드 랜덤 반환. get()
		Consumer<Integer>  c = i -> System.out.print(i+", "); // accept 
		Predicate<Integer> p = i -> i%2==0; // 항상 boolean 타입 반환
		Function<Integer, Integer> f = i -> i/10*10; // i의 일의 자리를 없앤다. apply() 

		List<Integer> list = new ArrayList<>();	
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}

	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());

		for(T i : list) {
			newList.add(f.apply(i)); // ex) 77입력이면 70으로 바꿈.
		}	

		return newList;
	}

	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) { // 짝홀, 출력, 리스트
		System.out.print("[");
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}	
		System.out.println("]");
	}

	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i=0;i<10;i++) {
			list.add(s.get());
		}
	}
}
