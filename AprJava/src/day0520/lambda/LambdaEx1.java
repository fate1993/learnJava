package day0520.lambda;
// 람다식이 주어지면 조상타입. 어떤 인터페이스를 구현하고 있는지부터 체크한다.
// 매개변수 자리에 람다식이 있으면 어떤 타입인지 확인. 오버라이딩 확인.

@FunctionalInterface
interface MyFunction {
	void run();  // public abstract void run();
}

class LambdaEx1 {
	static void execute(MyFunction f) { // 매개변수의 타입이 MyFunction인 메서드
		f.run();
	}

	static MyFunction getMyFunction() { // 반환 타입이 MyFunction인 메서드 
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}

	public static void main(String[] args) {
		// 람다식으로 MyFunction의 run()을 구현
		MyFunction f1 = ()-> System.out.println("f1.run()");

		MyFunction f2 = new MyFunction() {  // 익명클래스로 run()을 구현
			public void run() {   // public을 반드시 붙여야 함
				System.out.println("f2.run()");
			}
		};

		MyFunction f3 = getMyFunction();

		f1.run();
		f2.run();
		f3.run();

		execute(f1);
		execute( ()-> System.out.println("run()") );
	}
}









