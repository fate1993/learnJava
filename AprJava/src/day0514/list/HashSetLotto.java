package day0514.list;

import java.util.*;

public class HashSetLotto {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; set.size() < 6; i++) { // 6개 숫자를 저장
			int num = (int)(Math.random()*45) + 1; // 1~45 숫자중 랜덤으로 뽑고 num에 저장
			set.add(num); // set에 Integer num 저장. 6개 숫자 저장될 때까지 반복.
		} // HashSet은 중복값을 허용하지 않기 때문에 별도 조취 취하지 않아도 됨.


		List<Integer> list = new LinkedList<>(set); 
		// LinkedList(Collection c)
		Collections.sort(list); // 리스트 타입이 됐기 때문에 Collections.sort를 할 수 있음. 순서대로 정렬 가능해진다는 말.
		// Collections.sort(List list)
		// set 그냥 쓰면 되지 왜 LinkedList? 순서대로 정렬하기 위해
		System.out.println(list);
	}
}