package day0518.awt;
import java.awt.*;
import java.awt.event.*;

public class MouseMotionEventEx extends Frame implements ActionListener, MouseMotionListener {
	
	Label move = new Label("mouse following", Label.CENTER);
	Button exit = new Button("exit");
	
	public MouseMotionEventEx() {
		// super();
		setTitle("MouseMotionEvent 테스트");
		
		setLayout(null);
		
		move.setBounds(100, 50, 150, 20);
		exit.setBounds(250, 500, 50, 30);
		
		move.setBackground(Color.red);
		
		add(move);
		add(exit);
		
		setBounds(300, 100, 500, 600);
		setVisible(true);
		
		exit.addActionListener(this);
		addMouseMotionListener(this);
	}
	
	public static void main(String[] args) {
		new MouseMotionEventEx();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		move.setLocation(p);
	}
	
	public void mouseDragged(MouseEvent e) {}
}
