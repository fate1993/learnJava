package day0512.langex;

class Person {
	long id; 

	@Override
	public boolean equals(Object obj) { //정말 자주 사용하는 Object 클래스의 equals() 메서드
		if (obj != null && obj instanceof Person) { // 비교할 객체가 있고, 그 객체가 Person 타입.
			return id == ((Person) obj).id; //id에 저장된 값이 같으면 같은 사람.
			// obj가 Object 타입이므로 id 값을 참조하기 위해서는
			// Person 타입으로 형변환이 필요하다.
		} else {
			return false; // 타입이 Person이 아니면 값을 비교할 필요도 없다.
		}
	}

	Person(long id) { //id 값을 저장하는 생성자.
		this.id = id;
	}
}

class EqualsEx2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);

		if (p1 == p2) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}

		if (p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}
}