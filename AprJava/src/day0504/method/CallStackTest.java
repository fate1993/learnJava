package day0504.method;

public class CallStackTest {
	public static void main(String[] args) {
		firstMethod();
	}
	static void firstMethod() {
		secondMethod();
	}
	static void secondMethod() {
		System.out.println("출력!!");
	}
}
//Call Stack 덕분에 메서드가 끝나면 호출했던 지점으로 돌아간다.