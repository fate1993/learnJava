package day0520.thread;

class DaemonThreadEx implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new DaemonThreadEx());
		t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다.
		t.start();

		for (int i = 1; i <= 20; i++) {

			try {
				Thread.sleep(1000); // 1초 쉬고. 쉬는 사이에 대기하고 있던 스레드가 수행.
			} catch (InterruptedException e) {
			}

			System.out.println(i); // i값 출력

			if (i == 5)
				autoSave = true;
		}

		System.out.println("프로그램을 종료합니다.");
	}

	public void run() {
		while (true) { // 무한반복
			try {
				Thread.sleep(3 * 1000); // 3초마다
			} catch (InterruptedException e) {}

			// autoSave의 값이 true이면 autoSave()를 호출한다.
			if (autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}