package day0510.poly;
// 매개변수의 다형성
class Product {
	int price; // 제품의 가격
	int bonusPoint; // 제품구매 시 제공하는 보너스점수
	
	Product(int price){ // 생성자. void 없고. return 값 없고.
		this.price = price;
		bonusPoint = (int)(price/10.0); // 보너스점수는 제품가격의 10%
	}
}

class Tv extends Product {
	Tv() {
		//조상 클래스의 생성자 Product(int price)를 호출한다.
		super(100); // Tv의 가격을 100만원으로 한다.
	}
	@Override
	public String toString() {
		//Object 클래스의 toString()을 오버라이딩한다.
		return "TV";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}
	@Override
	public String toString() {
		return "Computer";
	}
}

class Buyer { // 고객, 물건을 사는 사람
	int money = 1000; // 소유금액
	int bonusPoint = 0; // 보너스점수
	
	void buy(Product p) { 
		// 매개 변수가 Product 타입의 참조변수. Product 클래스의 자손 클래스 Tv, Computer의 참조변수를 한번에 매개변수로 받아들일 수 있음.
		// 앞으로 다른 제품 클래스를 추가할 때 Product클래스를 상속받기만 하면, buy(Product  p)메서드의 매개변수로 받아들여질 수 있다.
		if(money<p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
			return;
		}
		money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
		System.out.println(p+"을/를 구입하셨습니다.");
	}
}

public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		
		b.buy(tv);
		b.buy(com);
		
		System.out.println("현재 남은 돈은 "+b.money+"만원입니다.");
		System.out.println("현재 보너스점수는 "+b.bonusPoint+"점입니다.");
	}
}