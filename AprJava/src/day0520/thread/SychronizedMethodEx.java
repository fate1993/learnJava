package day0520.thread;

public class SychronizedMethodEx implements Runnable {
	@Override
	public void run() {
		kitchen();
		bedroom();
	}
	
	public synchronized void kitchen() { // 동기화 >> lock pool로. 대기상태인 스레드가 없으면 lock pool에서 임의로 꺼낸다.
		System.out.println(Thread.currentThread().getName() + " is in kitchen");
		try {Thread.sleep(1000);} catch(Exception e) {}
		System.out.println(Thread.currentThread().getName() + " is leaving kitchen");
	}
	
	public synchronized void bedroom() {
		System.out.println(Thread.currentThread().getName() + " is in bedroom");
		try {Thread.sleep(1000);} catch(Exception e) {}
		System.out.println(Thread.currentThread().getName() + " is leaving bedroom");
	}
	
	public static void main(String[] args) {
		SychronizedMethodEx sm = new SychronizedMethodEx();
		
		Thread t = new Thread(sm, "Tom"); // Thread(Runnable target, String name)
		Thread t1 = new Thread(sm, "Jerry");
		t.start();
		t1.start();
	}
}





