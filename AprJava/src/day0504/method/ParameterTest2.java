package day0504.method;

class ParameterTest2 {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);//10

		change(d);
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x);//1000
	}
	static void change(Data d) { // 클래스의 주소값을 받아오는 것.
		d.x = 1000;
		System.out.println("change() : x = " + d.x);//1000
	}
}
