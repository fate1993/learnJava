package day0512.inner;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventEx {
	
	public static void main(String[] args) {
		Frame f = new Frame();
		Button b = new Button("button");
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 눌림");
			}
		});
		
		f.add(b);
		f.setBounds(100,100,200,300);
		f.setVisible(true);
	}
}
/*
class EventHandler implements ActionListener{
	//버튼을 클릭할 때마다(event) 호출되는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼이 눌림");
	}
}
*/
