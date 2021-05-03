package day0503.oop1;

public class CarTest {
	public static void main(String[] args) {
		Car c = new Car();
		
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		
		System.out.println(c.speed);
	}
}
