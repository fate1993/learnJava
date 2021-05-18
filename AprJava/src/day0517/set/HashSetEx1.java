package day0517.set;
// HashSet은 주머니에 막 집어 넣는다고 보면 됨
import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
	public static void main(String[] args) {
		Object[] objArr = { "1", 1, "2", "2", "3", "3", "4", "4", "4" };
		Set set = new HashSet(); // HashSet() 중복값을 제거

		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]); // HashSet에 objArr의 요소들을 저장한다.
		}
		System.out.println(set);
		// HashSet에 저장된 요소들을 출력한다. 
		// 실제로 중복값이 없어졌다. 그렇지만 int형 타입 1과 Strnig 타입 1은 다르므로 그대로 출력했다.
	}
}
