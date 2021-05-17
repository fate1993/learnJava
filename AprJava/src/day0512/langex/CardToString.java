package day0512.langex;

class Card {
	String kind;
	int number;

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	//toString() 오버라이딩

	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}
}

class CardToString {
	public static void main(String[] args) {
		 Card c1 = new Card("SPADE", 1); // 객체 생성
	        Card c2 = new Card("SPADE", 2);
	        Card c3 = new Card("SPADE", 3);
	        Card c4 = new Card("SPADE", 4);
	        Card c5 = new Card("SPADE", 5);
	        
	       System.out.println(c1.toString());
	       System.out.println(c2.toString());
	       System.out.println(c3.toString());
	       System.out.println(c4.toString());
	       System.out.println(c5.toString());
	}
}