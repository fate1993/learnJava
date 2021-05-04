package day0504.method;

public class Example {
	//메서드 만드는 법: 리턴타입 이름(매개변수) {//명령어} 
	//1. 문자열을 입력받아서 해당 문자열을 출력하는 리턴 값이 없는 메서드 print
	void print(String s) {
		System.out.println(s);
	}
	//2. int배열을 입력받아 그안에 있는 모든 숫자를 더하고 그 값을 리턴하는 메서드 add
	int add(int[] arr) {
		int result = 0; // 선언부 먼저 만들기
		for(int i : arr) {
			result+=i;
		}
		return result;
	}
	//3. 랜덤값(1~10)을 리턴하는 메서드 random_100
	int random_100() {
		return (int)(Math.random()*10)+1;
	}
	
	public static void main(String[] args) {
		Example ex = new Example();
		ex.print("test");
		int[] a = {1, 2, 3, 4};
		int i = ex.add(a);
		System.out.println(i);
		System.out.println(ex.random_100());
	}
}
