package day0511.example5;

public class Customer {
	int money = 10000;
	int point; // int형 기본값은 0. 가능한 코드 줄이기.
	
	void order(Food f) { // 조상클래스 타입의 매개변수를 받는다. 다형성.
		if(money < f.price) {
			System.out.println("주문불가");
			return;
		}
			System.out.println(f.getName()+"을/를 주문하셨습니다");
			money -= f.price;
			point += f.point;
		
	}
}