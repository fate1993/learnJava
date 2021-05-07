package day0507.modifier;

public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time(12, 35, 30);
		System.out.println(t);
		//t.hour = 13; << 에러. 접근제어자 private이기 때문.
		// 때문에 메서드를 통해 값을 가져옴.
		t.setHour(t.getHour() + 1);
		System.out.println(t);
	}
}

class Time {
	private int hour;
	private int minute;
	private int second;
	// 통상 캡슐화 패턴은 접근제어자를 private으로 선언 후 진행. 같은 클래스 안에서만 접근 가능하도록.

	Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 23) {
			return; }
		this.hour = hour; // 검사 후 문제 없으면 저장.
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 59)
			return;
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second < 0 || second > 59)
			return;
		this.second = second;
	}

	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	} // 시, 분, 초를 표현할 수 있도록 toString() 오버라이딩
}







