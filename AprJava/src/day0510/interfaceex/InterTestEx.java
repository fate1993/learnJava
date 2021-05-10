package day0510.interfaceex;

interface InterTest{
	int A = 100;
	int getA(); // 바디가 없는 추상 메서드가 있는 점이 특징. 구현부에서 추상메서드를 오버라이드
}

class InterTestEx implements InterTest {
	public static void main(String[] args) {
		InterTest it = new InterTestEx();
		System.out.println("getA() :: "+it.getA());
	}
	
	@Override
	public int getA() { // 인터페이스의 추상메서드 상속.
		return A;
	}
}