package day0510.interfaceex;

interface Inter1 {
	public int getA();
}

interface Inter2 {
	public int getA();
}

interface Inter3 extends Inter1, Inter2 {
	public int getData();
}
// 상속받은 인터페이스 두 개에서 같은 이름의 메서드가 있다면?
// 하나인 셈 치고 진행.

public class InterTestEx2 implements Inter3 {
	int a = 100;

	public int getA() {
		return a;
	}

	public int getData() {
		return a + 10;
	}

	public static void main(String[] args) {
		InterTestEx2 it = new InterTestEx2();
		Inter1 i1 = new InterTestEx2();
		Inter2 i2 = it;
		Inter3 i3 = it;
		System.out.println(i1.getA());
		System.out.println(i2.getA());
		System.out.println(i3.getData());
	}
}
