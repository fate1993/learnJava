package day0520.thread;
// Car, Customer, Producer, ProducerCustomerEx
import java.util.*;

public class Car {
	private List<String> carList = null;
	
	public Car() {
		carList = new ArrayList<String>();
	}
	
	public String getCar() {
		String carName = null;
		switch((int)(Math.random()*3)) {
		case 0 :
			carName = "아우디 Q2";
			break;
		case 1:
			carName = "애스터마틴 DBX";
			break;
		case 2:
			carName = "포스쉐 타이칸";
			break;
		}
		return carName;
	}
	
	// Customer가 사용
	public synchronized String pop() {
		String carName = null;
		if(carList.size() == 0) {
			try {
				System.out.println("  차가 없어요 생산할때 까지 기다리세요");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		carName = (String) carList.remove(carList.size() - 1);
		System.out.println(" 손님이 차를 사갔습니다.." + "손님이 구입한 차이름은 =>\" " + carName + "\"");
		return carName;
	}
	
	public synchronized void push(String car) {
		carList.add(car);
		System.out.println(" 차가 만들어 졌습니다. " + " 차이름은 \" " + car + "\"");
		if(carList.size() == 5) { // 5대가 되면 팔기 시작
			this.notify();
		}
	}
}













