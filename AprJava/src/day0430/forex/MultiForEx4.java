package day0430.forex;

public class MultiForEx4 {
	public static void main(String[] args) {
		// 다중 for문을 이용해 방정식4x + 5y = 60의 모든 해를 구해
		// (x,y) 형태로 출력하는 프로그램을 만드세요. 단 x,y는 10이하의 자연수입니다.

		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if (4*x + 5*y == 60) {
					System.out.print("(" + x + "," + y + ") ");
				}
			}
		}
	}
}
