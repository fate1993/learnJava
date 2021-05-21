package day0520.thread;

public class SingleThreadEx extends Thread { // Thread 상속 받을 때

	private int[] temp;
	
	public SingleThreadEx(String threadname) { // 생성자
		super(threadname);
		temp = new int[10];
		for(int start = 0; start < temp.length; start++) {
			temp[start] = start; // 0번 인덱스에 0 1번 인덱스에 1...
		}
	}
	
	@Override
	public void run() { // 항상 run() 오버라이딩 필요. 내가 원하는 작업 구현
		for(int start : temp) {
			try {
				sleep(1000); // 1초 쉼
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			System.out.println("스레드 이름 : " + currentThread().getName());
			System.out.printf("temp value : %d %n,", start);
		} // f >> 문자열 format
		// %d: 정수
		// %s: 문자열
		// %n: 줄바꿈
	}
	
	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx("첫번째"); // SingleThreadEx(String threadname)
		st.start(); // runnable로
	}
}







