package day0518.awt;
import java.awt.*;
import java.awt.event.*;

public class KeyEventEx extends Frame implements KeyListener {
	TextArea ta = new TextArea();

	public KeyEventEx() {
		super("KeyEvent 테스트");

		add(ta); // TextArea() 호출?

		setBounds(300, 300, 300, 300);
		setVisible(true);

		ta.addKeyListener(this);
	}

	public void keyReleased(KeyEvent e) {} // 구현하는 게 없는 메서드?? 자동으로 구현되는듯? 아닌가..

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_DOWN) {
			ta.append("Down Key\n");
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ta.append("Up Key\n");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ta.append("Left Key\n");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ta.append("Right Key\n");
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			ta.append("Enter Key\n");
		}
	}

	public static void main(String[] args) {
		new KeyEventEx();
	}
}