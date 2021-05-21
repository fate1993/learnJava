package day0518.awt;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx extends Frame implements ActionListener {
	// Frame, ActionListener 활용

	Panel p;
	Button input, exit;
	TextArea ta;

	public ActionEventEx() {
		super("ActionEvent");
		
		p = new Panel();
		
		input = new Button("입력");
		exit = new Button("종료");
		ta = new TextArea();
		
		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					ta.append("입력\n");
			}
		});
		exit.addActionListener(this);

	p.add(input);p.add(exit);

	add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		setBounds(300, 300, 300, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String name;
		name = ae.getActionCommand();

		if (name.equals("입력"))
			ta.append("버튼이 입력되었습니다.\n");
		else {
			ta.append("프로그램을 종료합니다.\n");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ActionEventEx();
	}
}
