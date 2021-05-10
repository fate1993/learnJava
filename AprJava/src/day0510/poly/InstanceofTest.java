package day0510.poly;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine(); // 자손
		Car car = new Car(); // 조상
		
		if(car instanceof FireEngine) { // car라는 참조변수를 FireEngine 타입으로 캐스팅. 조상 <- 자손. 그러면 sub이 super 객체를 다루게되는 셈. 안됨. 
			System.out.println("This is a FireEngine instance.");
		}
		
		if(fe instanceof Car) { // fe가 FireEngine을 가리키고 있는 상태에서 Car를 캐스팅. Car가 가지고 있는 기능 모두 FireEngine에 있으니까.
			Car c = fe;
			System.out.println("This is a Car instance.");
		}
		
		if(fe instanceof Object) {
			System.out.println("This is an Object instance.");
		}
	}
}
