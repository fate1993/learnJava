package day0514.list;

import java.util.Vector;

// 백터는 우리가 원하는데로 용량을 지정할 수 있고 확인도 할 수 있다.
public class VectorEx1 {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>(2,3); // 2칸짜리
		
		v.add(3.14);
		v.add(123.45); // v.add(new Double(123.45)); 오토박싱
		v.add(100.); // 2칸 끝났으니까 3칸 더 늘어남. 
		
		System.out.println(v);
		System.out.println(v.capacity()); // 저장할 수 있는 공간의 개수 2 + 3 = 5
		System.out.println(v.size());
		
		System.out.println("빈 공간 삭제");
		
		v.trimToSize(); // 비어있는 공간 제외하고 사이즈 만큼만 남김.
		System.out.println(v.capacity()); // 3. 저장된 공간만 남음.
		
		v.clear(); // 안에 있는 데이터가 모두 삭제됨. 용량(저장할 수 있는 공간의 개수)는 그대로.
		System.out.println(v.capacity());
		System.out.println(v.size());
	}
}