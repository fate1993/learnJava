package day0518.awt;

import java.awt.Frame;
import java.awt.*;
import java.awt.event.*;

public class PopupMenuTest {
	public static void main(String[] args) {
		final Frame f = new Frame("PopupMenu Test");
		f.setSize(300, 200);
		
		final PopupMenu pMenu = new PopupMenu("Edit");
		MenuItem miCut = new MenuItem("Cut");
		MenuItem miCopy = new MenuItem("Copy");
		MenuItem miPaste = new MenuItem("Paste");
		
		pMenu.add(pMenu);
		f.addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(me.getButton() == MouseEvent.BUTTON3)	
					pMenu.show(f, me.getX(), me.getY());	
			}		
		});
		f.setVisible(true);
	}
}
