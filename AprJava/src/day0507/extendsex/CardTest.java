package day0507.extendsex;

class Card {
	int number; // 숫자
	String kind; // 무늬 저장
	
	Card(int number, String kind) {
		this.number = number;
		this.kind = kind;
	}
	@Override // Object 메서드를 오버라이딩. 어노테이션. 해당 메서드가 오버라이딩 된 메서드임을 알려줌.
	// toString 메서드는 해당 객체가 가지고 있는 값을 문자열로 만들어 반환.
	// 참조 변수를 출력하면 자동으로 toString()가 호출됨(toString()는 모든 객체 안에 다 있음)
	public String toString() {
		return "숫자: "+number+" 무늬 : "+kind;
	}
}

public class CardTest {
	public static void main(String[] args) {
		Card c = new Card(3, "heart");
		System.out.println(c); 
		// 참조변수 출력시 주소가 출력되는 것이 아니고 객체 안에 있는 toString()가 실행됨
	}
}
