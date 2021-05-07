package day0507.extendsex;

class Tv extends Object{
	boolean power; // 전원상태(on/off)
	int channel; // 채널
	
	Tv() {
		super();
	}
	
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class CaptionTv extends Tv {
	boolean caption; // 캡션상태(on/off). 기본적으로 boolean은 false.
	
	CaptionTv(){
		super();
	}
	
	void displayCaption(String text) {
		if(caption) { // 캡션 상태가 on(true)일 때만 text를 보여 준다.
			System.out.println(text);
		}
	}
}

public class CaptionTvTest {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello World");
		ctv.caption = true;
		ctv.displayCaption("Hello World");
	}
}
