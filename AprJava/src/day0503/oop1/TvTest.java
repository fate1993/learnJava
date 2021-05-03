package day0503.oop1;

public class TvTest {

	public static void main(String[] args) {
		
		Tv t; //Tv클래스로 만든 객체의 주소만 저장할 수 있음
		t = new Tv(); // 객체 생성. 객체 안에 있는 속성과 기능을 사용할 수 있음
		
		t.ch = 10;
		t.chDown();
		
		System.out.println("현재 채널은 "+t.ch+"번 입니다");
	}
}
