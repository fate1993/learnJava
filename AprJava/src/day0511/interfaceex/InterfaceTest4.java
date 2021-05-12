package day0511.interfaceex;

class InterfaceTest4 {
	public static void main(String[] args) {
		Child3 c = new Child3();
		c.method1(); // 클래스에서 오버라이딩 된 메서드 호출
		c.method2(); // 클래스에 있는 메서드가 상속됨
		MyInterface.staticMethod(); // 호출하는 법 : 인터페이스명.메서드명()
		MyInterface2.staticMethod();
	}
}

class Child3 extends Parent3 implements MyInterface, MyInterface2 {
	// 같은 이름의 디폴트 메서드를 여러개 상속받으면 클래스에 오버라이딩 해야 함.
	public void method1() {	
		System.out.println("method1() in Child3"); 
	} // 오버라이딩		
	// Parent 3 : method2, MyInterface : method1, MyInterface2 : method2,
}

class Parent3 {
	public void method2() {	
		System.out.println("method2() in Parent3");
	}
}

interface MyInterface {
	default void method1() { 
		System.out.println("method1() in MyInterface");
	} // 인터페이스 안에 일반 메서드. default 붙여서 처리.

	default void method2() { 
		System.out.println("method2() in MyInterface");
	}

	static void staticMethod() { 
		System.out.println("staticMethod() in MyInterface");
	} // static 메서드는 반드시 바디{} 있어야 함.
	// 호출하는 법 : 인터페이스명.메서드명()
}

interface MyInterface2 {
	default void method1() { 
		System.out.println("method1() in MyInterface2");
	}

	static void staticMethod() { 
		System.out.println("staticMethod() in MyInterface2");
	}
}