package day0510.poly;

class CastingTest1 {
	public static void main(String args[]) {
		Car car = null; // super 클래스 car 변수선언.
		FireEngine fe = new FireEngine(); // sub 클래스 FireEngine 클래스 객체 생성
		FireEngine fe2 = null; 

		fe.water(); // sub 클래스 FireEngine의 메서드 호출
		car = fe; // super 클래스에 sub 클래스 대입
		// car.water(); // water()은 FireEngine 클래스에 있기 때문에 못씀. 
		fe2 = (FireEngine) car;
		fe.water(); // 
	}
}

class Car {
	String color;
	int door;

	void drive() {
		System.out.println("drive, Brrrr~");
	}
	void stop() {
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water!!!");
	}
}