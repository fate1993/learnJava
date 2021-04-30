package day0430.whileex;

public class DoWhileEx {
	public static void main(String[] args) {
		int num=5;
		do {
			System.out.println(num);
			num++;
		} while(false);
		
		System.out.println("program end!!");
	}// do while문은 실제 프로젝트에서 거의 사용하지 않는다. 심지어 파이썬엔 do while문이 없음.
}
