package day0517.set;
import java.util.*;

class HashSetEx4 {
	public static void main(String args[]) {
		HashSet setA    = new HashSet();
		HashSet setB    = new HashSet();
		HashSet setHab = new HashSet();//합집합
		HashSet setKyo = new HashSet();//교집합
		HashSet setCha = new HashSet();//차집합 A - B

		setA.add("1");		setA.add("2");
		setA.add("3");		setA.add("4");
		setA.add("5");
		System.out.println("A = "+setA);

		setB.add("4");		setB.add("5");
		setB.add("6");		setB.add("7");
		setB.add("8");
		System.out.println("B = "+setB);

		Iterator it = setB.iterator();
		while(it.hasNext()) { // 다음 요소 있는지 반복적으로 확인?
			Object tmp = it.next();
			if(setA.contains(tmp)) // contains 포함하고 있으면 true
				setKyo.add(tmp);
		} // 교집합 구현

		it = setA.iterator(); // A에 있는 요소들에 커서가 주어짐
		while(it.hasNext()) { // 요소를 하나씩 꺼내옴
			Object tmp = it.next();
			if(!setB.contains(tmp)) 
				setCha.add(tmp);
		} // 차집합 구현

		it = setA.iterator();
		while(it.hasNext())
			setHab.add(it.next()); // add가 알아서 중복값 제거

		it = setB.iterator();
		while(it.hasNext())
			setHab.add(it.next()); // add가 알아서 중복값 제거

		System.out.println("A �� B = "+setKyo);  // �ѱ� ���� ������ ����Ű
		System.out.println("A - B = "+setCha);
		System.out.println("A �� B = "+setHab);  // �ѱ� ���� ������ ����Ű
	}
}
