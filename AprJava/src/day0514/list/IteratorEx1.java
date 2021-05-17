package day0514.list;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx1 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2,5);
		
		v.add("a");
		v.add("b");
		v.add("c");
		System.out.println("벡터크기: "+v.size());
		
		Iterator<String> it = v.iterator(); // Iterator 얻기
		
		while(it.hasNext()) { // hasNext() 다음 레코드 있는지 확인
			System.out.println(it.next()); 
			it.remove(); // 원본 컬렉션에서 요소 삭제
		} 
		// it.remove(); // error. 커서가 가리키는 데이터를 지우려고했는데 없으니까 에러.
		System.out.println("벡터크기: "+v.size());
		System.out.println(v);
	}
}