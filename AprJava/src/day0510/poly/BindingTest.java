package day0510.poly;

class BindingTest{
	public static void main(String[] args) {
		Parent p = new Child(); // Parent의 참조변수로 Child의 객체 생성.
		Child c = new Child(); // Child의 참조변수로 Child의 객체 생성.

		System.out.println("p.x = " + p.x);//100
		p.method();//Child Method 동적 바인딩

		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;

	void method() {
		System.out.println("Child Method");
	}
}