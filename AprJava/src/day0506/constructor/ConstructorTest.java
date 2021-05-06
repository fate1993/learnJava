package day0506.constructor;

class Data1 {
	int value;
	Data1(){} // 알아서 하는일 없는 생성자 추가
}

class Data2 {
	int value;
	Data2(int x) { // 매개변수가 있는 생성자
		value = x; //인스턴스(value) 변수의 값을 초기화
	}
	Data2(){}
}

public class ConstructorTest {
	public static void main(String[] args) {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2(); // compile error 발생
		Data2 d3 = new Data2(10);
	}
	ConstructorTest() {} // 기본 생성자 알아서 추가됨
}