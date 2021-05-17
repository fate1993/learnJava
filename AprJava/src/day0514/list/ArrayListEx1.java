package day0514.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(3);
		
		list.add("BTS");
		list.add("수지");
		list.add("아이유");
		list.add("브레이브걸즈");
		
		System.out.println("저장된 데이터의 수 : "+list.size());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("=====================");
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println("=====================");
		
		list.remove(1);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=====================");
		String name = "아이유";
		int index = list.indexOf(name);
		
		if(index == -1) {
			System.out.println(name+"은/는 존재하지 않습니다.");
		}else {
			System.out.println(name+"은/는 "+index+"번에 있습니다.");
		}
	}
}