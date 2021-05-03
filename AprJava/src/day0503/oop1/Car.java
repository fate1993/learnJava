package day0503.oop1;

class Car {
// 자동차를 만들자
	// 자동차 모델명, 연식, 색깔, 속도 (변수)
	// 가속(속도+10), 감속(속도-10), 멈춤(속도=0) (메서드) void 이름(){기능}
	
	String model;
	int year;
	String color;
	int speed;
	
	void speedUp() {speed+=10;}
	void speedDown() {speed-=10;}
	void Stop() {speed=0;}
}
