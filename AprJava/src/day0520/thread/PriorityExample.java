package day0520.thread;

public class PriorityExample {
	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			Thread thread = new CalcThread("thread" + i);
			if(i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY); // 우선순위를 1로.
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
  
