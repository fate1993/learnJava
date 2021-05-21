package day0520.thread;

public class SingleRunnableEx implements Runnable {
	private int temp[];

	public SingleRunnableEx() {
		temp = new int[10];
		for (int start = 0; start < 10; start++) {
			temp[start] = start;
		}
	}

	@Override
	public void run() {
		for(int start : temp) {
			try {
				Thread.sleep(1000); // Thread 상속 아니기 때문에 Thread.
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.printf("스레드 이름  : %s ,", Thread.currentThread().getName());
			System.out.printf("temp value : %d %n", start);
		}
	}
	
	public static void main(String[] args) {
		SingleRunnableEx srt = new SingleRunnableEx();
		Thread t = new Thread(srt, "첫번째"); // Thread(Runnable target, String name)
		t.start();
		// t.run();
		// t.run(); 스레드 이름이 main으로 나옴. 주도권이 넘어가기 때문??
	}
}













