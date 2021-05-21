package day0518.awt;
import java.awt.*;

public class ButtonEx {
	public static void main(String[] args) {
		Frame f = new Frame("버튼 테스트");
		
		Panel p = new Panel();
		
		Button b1 = new Button();
		Button b2 = new Button("print");
		Button b3 = new Button("array");
		Button b4 = new Button("rank");
		
		b1.setLabel("입력");
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 100);
		f.setVisible(true);
	}
}