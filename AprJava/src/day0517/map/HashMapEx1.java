package day0517.map;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>(); // HashMap<key, value> 객체 생성
		map.put("myld", "1234"); // 값 저장
		map.put("asdf", "1111");
		map.put("asdf", "1234"); // 똑같은 키가 저장되면 덮어쓰기가 됨. 앞의 데이터는 사라짐.

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.print("id: ");
			String id = s.nextLine().trim();

			System.out.print("password: ");
			String password = s.nextLine().trim(); // .trim() -> 왼쪽 오른쪽 공백 제거

			System.out.println();

			if (!map.containsKey(id)) {
				System.out.println("id가 존재하지 않습니다.");
				continue;
			} else {
				if (!map.get(id).equals(password)) {
					System.out.println("비밀번호가 틀렸습니다");
				} else {
					System.out.println("로그인 됐습니다.");
					break;
				}
			}
		}
	}
}
