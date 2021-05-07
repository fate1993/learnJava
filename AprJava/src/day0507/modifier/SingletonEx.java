package day0507.modifier;
/*
싱글톤 패턴
private 생성자() {} -> 외부에서 객체 생성 못하도록 함.
private static 변수 = 현재 클래스 객체 생성;
public static 클래스타입 메서드이름() {
	return 변수;
}
*/

class C {
	private C() {}
	private static C a = new C();
	public static C getInstance() {
		return a;
	}
	// 멤버 선언
	int x;
}

public class SingletonEx {
	public static void main(String[] args) {
		C c1 = C.getInstance();
		C c2 = C.getInstance();
		c1.x = 10;
		System.out.println(c1.x);
		System.out.println(c2.x);
	}
}
