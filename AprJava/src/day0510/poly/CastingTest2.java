package day0510.poly;

public class CastingTest2 {
	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();
		fe = (FireEngine)car; // error. FireEngine fe = new Car(); -> Car는 쓸 수 있지만 FireEngine은 쓸 수 없는 상태.
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}
