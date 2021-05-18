package day0517.set;

import java.util.Set;
import java.util.TreeSet;

// 무작위로 추출한 숫자를 순서대로 나열. 
public class TreeSetLotto {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		for(int i = 0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) + 1; // 1~45까지 난수 생성
			set.add(num); // set에 하나씩 저장
		}
		System.out.println(set);
	}
}