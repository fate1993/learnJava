package day0518.awt;

import java.awt.*;
import java.awt.event.*;

public class WindowEventEx extends Frame {
	public WindowEventEx() {
		super("WindowEvent 테스트");

		Label exit = new Label("push the exit button"); // 종료 라벨

		add(exit); // 수행

		setBounds(300, 300, 200, 200); // 너비, 높이 등??
		setVisible(true); // 보여줘라

		addWindowListener(new WindowEventHandler1()); // WindowAdapter 상속받은 클래스 호출
	}

	public static void main(String[] args) {
		new WindowEventEx(); // 생성자 호출
	}	
}

class WindowEventHandler1 extends WindowAdapter{ // 다중상속 안되기 때문에 WindowAdapter 상속 위해 다른 클래스 만듬
	
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}
