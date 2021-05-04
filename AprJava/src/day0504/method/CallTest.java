package day0504.method;

public class CallTest {

	static int cv = 0; // static 변수
	int iv = 0; // instance 변수
	
	static int cv2 = cv;
//	static int cv3 = iv; // instance 변수 접근하려고하니 에러
	
	int iv2 = cv; 
	int iv3 = iv; // instance 변수는 static, instance 변수 모두 사용
	
	static void staticMethod() {
		cv = 10;
//		iv = 10; // 에러
		
	}
	void instanceMethod() {
		cv = 20;
		iv = 20;
	}
}
