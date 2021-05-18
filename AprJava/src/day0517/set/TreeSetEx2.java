package day0517.set;

import java.util.*;

class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>(); // 중복제거, 정렬상태로 저장가능
		int[] score = { 80, 95, 50, 35, 45, 65, 10, 100 };

		for (int i = 0; i < score.length; i++) {
			set.add(score[i]); // score에 저장된 배열을 작은 숫자 순서로 저장
		}
		System.out.println("50보다 작은 값 :" + set.headSet((50))); // 50보다 머리에 있는(작은, 왼쪽)
		System.out.println("50보다 큰 값 :" + set.tailSet((50))); // 자신을 포함해 뒤에 있는.

	}
}
