package day0514.list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx2 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(10); // 숫자값을 모아서 저장. 10칸짜리 ArrayList 생성
		list1.add(5); // 5를 가지고 있는 Integer 객체를 만들고 주소값 저장.
		list1.add(4); 
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // 1~3번 값을 가진 ArraryList 객체 만들어짐
		print(list1, list2);
		
		Collections.sort(list1); // 정렬 작은거부터 큰 순서대로
		Collections.sort(list2);
		print(list1,list2);
		
		System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));

		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);
		
		list2.set(3, "AA"); // 3번 인덱스에 있는 값을 AA로 바꾸겠다.
		print(list1,list2);
		
		System.out.println("list1.retainAll (list2) : "+ list1.retainAll(list2)); // // list1에는 list2와 공통으로 있는 값만 남김
		print(list1,list2);
		System.out.println("list1.retainAll (list2) : 2"+ list1.retainAll(list2)); // 이미 완료 됐으니까 false
		
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i))) // list2에 i번 인덱스 값에서 list1에 있는지 체크
				list2.remove(i); // 뒤에 있는 값은 아래로 당겨지면서 인덱스값 바뀜. 즉 위쪽 인덱스부터 검사해야한다는 의미
		} // 포함이 안돼있으면 for문 반복.
		print(list1, list2);
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1); // toString 메서드를 호출함.
		System.out.println("list2:"+list2);
		System.out.println();
	}
}