package day0512.inner;
//익명 inner 클래스
public class InnerClassEx {

	Object iv = new Object() {
		void method() {}
	};
	
	static Object cv = new Object() {
							//멤버선언
						};
						
	void myMethod() {
		Object lv = new Object() {};
	}
}