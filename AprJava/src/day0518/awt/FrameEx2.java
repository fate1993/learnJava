package day0518.awt;
import java.awt.*;

public class FrameEx2 extends Frame {
	public FrameEx2() {
		super("프레임 테스트");

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		FrameEx2 fe = new FrameEx2();
	}
}