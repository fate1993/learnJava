package day0520.thread;

class MyRunnableTwo implements Runnable {
	public void run() {
		System.out.println("run");
		first();
	}
	
	public void first() {
		System.out.println("first");
		second();
	}
	
	public void second() {
		System.out.println("second");
	}
}

public class JoinEx {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " start");
		Runnable r = new MyRunnableTwo();
		Thread myThread = new Thread(r); // Thread(Runnable target)
		myThread.start(); // 바로 run이 아니라 runnable로.
		
		try { // main end를 나중으로. blocked. 중지된 지점부터 다시 실행.
			myThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " end"); 
		// main이 우선권을 갖기 때문에 메인꺼 먼저 출력
	}
}









