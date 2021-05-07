package day0507.modifier;
// 추상 클래스는 직접 객체를 만드는 것이 아니라
// 일반 클래스에서 상속 받아서 오버라이딩 후 사용

abstract class AbstractEx {
	abstract void move(); // 추상 메서드는 구현부가 없음.
}

class A extends AbstractEx {
	void move() {
		System.out.println("A.move() 구현");
	}
}

class B extends AbstractEx {
	@Override
	void move() {
		System.out.println("B.move() 구현");
	}
}

// 추상 클래스를 오버라이드해서 사용하는 이유?
// 추상 메서드를 사용하면 무조건 오버라이딩을 해야함. 좀더 다양한 코드를 만들어낼 수 있게됨.

