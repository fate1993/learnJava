package day0512.langex;

class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	//toString() 오버라이딩

	@Override
	public String toString() { //정말 자주 사용하는 Object 클래스의 toString() 메서드
		return "kind=" + kind + ", number=" + number;
	}
}

class CardToString {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();

		System.out.println(c1);
		System.out.println(c2.toString());
	}
}