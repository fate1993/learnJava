package day0507.modifier;

class Card1 {
	final int NUMBER;		// 상수 선언 -
	final String KIND;		// 프로그램 처음부터 끝까지 동일한 값을 유지해야하는 경우
	static int width = 100;	 // static final을 붙여준다. 대입 연산자로 초기화까지.
	static int height = 250; // 객체마다 다른 값을 저장해야하는 경우 final만 붙여준다.

	Card1(String kind, int num) {	
		KIND = kind;
		NUMBER = num;
	}

	Card1() {
		this("HEART", 1);
	}

	public String toString() {
		return "" + KIND +" "+ NUMBER;
	}
}

class FinalCardTest {
	public static void main(String args[]) {
		Card1 c = new Card1("HEART", 10);
		//c.NUMBER = 5;	// ����!!! cannot assign a value to final variable NUMBER
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
	}
}
