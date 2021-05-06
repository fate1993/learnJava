package day0506.variable;

public class InitTest {

	static int cv = 1; // static 변수(클래스 변수)
	int iv = 1; // 인스턴스 변수

	static {
		cv = 2;
		System.out.println("static{} 실행");
	}
	// static 초기화 블록

	{
		iv = 2;
		System.out.println("{} 실행");
	}

	InitTest() {
		iv = 3;
		System.out.println("생성자 실행");
	}
	// 생성자가 가장 마지막에 호출됨

	void method() {
		int lv = 0; // 지역 변수는 자동 초기화가 안됨. 값을 명시해야 함.
		int lv2 = lv; //
	}

	public static void main(String[] args) {
		InitTest init = new InitTest();
		System.out.println(InitTest.cv+" "+init.iv);
		
		InitTest init2 = new InitTest();
		System.out.println(InitTest.cv+" "+init.iv);
	}
}
