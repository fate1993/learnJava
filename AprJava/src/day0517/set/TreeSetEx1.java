package day0517.set;
import java.util.*;

class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();

		String from = "b";
		String to	= "d";
		// b부터 d 사이에 있는 단어 뽑아오기
		
		set.add("abc");
		set.add("alien");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZZ");
		set.add("dzzzz");
		set.add("elephant");
		set.add("elevator");
		set.add("fan");
		set.add("flower");
		// 공백 -> 숫자 -> 대문자 -> 소문자 순으로 인식
		
		System.out.println(set);
		System.out.println("range search : from " + from  +" to "+ to);
		System.out.println("result1 : " + set.subSet(from, to));
		System.out.println("result2 : " + set.subSet(from, to + "zzz")); // dzzz -> dZZZZ, dance, disc 추가.
	}
}
