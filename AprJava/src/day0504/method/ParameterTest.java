package day0504.method;


class Data { 
	int x; 
	}

class ParameterTest {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);//10

		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);//10
	}

	static void change(int x) {  // 기본형 매개변수. 클래스의 주소값이 아닌 데이터 값을 가져옴
		x = 1000;
		System.out.println("change() : x = " + x);//1000
	}
}
