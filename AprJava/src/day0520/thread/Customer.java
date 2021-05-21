package day0520.thread;

public class Customer implements Runnable {
	private Car car;
	
	public Customer(Car car) {
		this.car = car;
	}
	
	@Override
	public void run() {
		String carName = null;
		for(int i = 0; i < 20; i++) { // 손님이 20명있다고 가정하고 만듬
			carName = car.pop(); // class Car pop()를 꺼내서 구입
			try {
				Thread.sleep((int)(Math.random() * 200)); // 0~199
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}























