package day0520.thread;

import java.awt.Toolkit;
// 멀티 스레드를 구현하지 않으면 동시 작업이 어렵다.
public class BeepPrintExample1 {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	
		for(int i=0; i<5; i++) {		
			toolkit.beep();// 경고음
			try { Thread.sleep(500); } catch(Exception e) {}
		}

		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}







