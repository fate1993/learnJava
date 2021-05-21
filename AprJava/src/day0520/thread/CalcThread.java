package day0520.thread;

public class CalcThread extends Thread {
	public CalcThread(String name) {
		// super() >> new Thread();
		setName(name);
	}
	
	public void run() {
		for(int i=0; i<2000000000; i++) {
		}
		System.out.println(getName());
	}
}
