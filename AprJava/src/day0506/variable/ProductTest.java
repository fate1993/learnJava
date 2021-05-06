package day0506.variable;

class Product {
	static int count = 0; // 생성된 인스턴스의 수를 저장하기 위한 변수
	int serialNo; // 인스턴스 고유의 번호 
	
	{ // 인스턴스 초기화 블럭: 모든 생성자에서 공통적으로 수행될 코드. 기본 생성사를 쓰지만 인스턴스 변수를 초기화. 
		// 거의 쓰이지 않음. 생성자를 사용하면 되기 때문
		++count;
		serialNo = count;
	}
	public Product() {}
}

public class ProductTest {
	public static void main(String[] args) {

		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1의 제품번호(serial no)는 "+p1.serialNo);
		System.out.println("p2의 제품번호(serial no)는 "+p2.serialNo);
		System.out.println("p3의 제품번호(serial no)는 "+p3.serialNo);
		System.out.println("생상된 제품의 수는 모두 "+Product.count+"개 입니다.");
	}
}
