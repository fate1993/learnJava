package day0517.map;

import java.util.*;

public class HashMapEx2 {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("김자바", 90);
		map.put("김자바", 100); // key 중복. 마지막으로 선언한 데이터가 덮어 씌움.
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);
		
		Set set = map.entrySet(); // key, value 값 모두 출력 필요한 경우
		Iterator it = set.iterator(); // map은 iterator로 바로 바꿀 수 없음. set으로 바꿔서 처리해야함
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next(); // Map.Entry로 형변환?
			System.out.println("이름: "+ e.getKey() + ", 점수: " + e.getValue());
		}
		
		set = map.keySet();
		System.out.println("참가자 명단: " + set);
		
		Collection values = map.values(); // values. value 값만 가져오는 
		it = values.iterator(); // Collection이니까 iterator 사용 가능.
		
		int total = 0; // total 선언
		
		while(it.hasNext()) {
			Integer i = (Integer)it.next(); // 하나씩 꺼내서
			total += i; // total에 계속 더해줌
		}
		
		System.out.println("총점: " + total);
		System.out.println("평균: " + (float)total / set.size()); // 저장된 entry의 개수로 나눔.
		System.out.println("최고점수: " + Collections.max(values)); 
		System.out.println("최저점수: " + Collections.min(values)); // Collections가 제공하고 있는 함수 max, min
	}
}
