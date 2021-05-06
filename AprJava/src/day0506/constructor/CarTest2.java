package day0506.constructor;

class Car2 {
	String color; // 색상
	String gearType; // 변속기 종류
	int door; 
	
	Car2() {
		this("white", "auto", 4);
	}
	
	Car2(String color) {
		this(color, "auto", 4);
	}
	
	Car2(String color, String gearType, int door) {
		this.color = color; // this를 붙이면 해당 객체 안에 있는 color(인스턴스 변수)
		this.gearType = gearType; // this를 붙이면 인스턴스 변수가 된다.
		this.door = door;
	}
}
public class CarTest2 {
	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("blue");
		Car2 c3 = new Car2("red","auto",5);
		
		System.out.println("c1 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);
		System.out.println("c3 color=" + c3.color + ", gearType=" + c3.gearType + ", door=" + c3.door);
	}
}
