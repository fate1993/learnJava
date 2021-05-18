package day0517.map;

import java.util.*;

class HashMapEx3 {
	static HashMap phoneBook = new HashMap(); // 해시맵 객체 생성

	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박대리", "010-666-6666");
		addPhoneNo("회사", "이과장", "010-777-7777"); // 3개 들어오는 경우
		addPhoneNo("세탁", "010-888-8888"); // 2개 들어오는 경우

		printList();
	} // main

	// �׷��� �߰��ϴ� �޼���
	static void addGroup(String groupName) {
		if (!phoneBook.containsKey(groupName)) // 같은 키가 있는지 확인.
			phoneBook.put(groupName, new HashMap()); // 없으면 put으로 저장. key값 = gorupName, value는 또 HaspMap 객체 만들어서 짝지음
	}

	// 그룹을 추가하는 메서드
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName); // key값과 쌍을 이루는 HashMap 객체 꺼내옴
		group.put(tel, name); 
		// HashMap 객체에 키는 tel, value는 name을 저장.
	}	// 이름은 중복될 수 있으니 전화번호를 key로 저장.

	
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	// 전화번호부 전체를 출력하는 메서드
	static void printList() {
		Set set = phoneBook.entrySet(); // iterator 처리 하기 위해 phoneBook에 있는 걸 set으로 꺼내옴
		Iterator it = set.iterator();

		while (it.hasNext()) { // 다음 값 있을 때까지 반복
			Map.Entry e = (Map.Entry) it.next(); // Map.Entry 인터페이스??

			Set subSet = ((HashMap) e.getValue()).entrySet(); // HashMap 객체만 getValue로 꺼내옴. 그리고 또 set으로 꺼내옴?
			Iterator subIt = subSet.iterator();

			System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]");

			while (subIt.hasNext()) { // map안에 또 map을 만들어서 정보를 저장하고 있음
				Map.Entry subE = (Map.Entry) subIt.next();
				String telNo = (String) subE.getKey();
				String name = (String) subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	} // printList()
} // class
