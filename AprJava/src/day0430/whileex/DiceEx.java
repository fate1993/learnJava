package day0430.whileex;
/*주사위 두개를 던져서 나오는 숫자를 (x,y)형태로 출력하고 두 숫자의 합이 5가 될때까지 
계속 주사위를 던지고 5가 되는 순간 멈추는 프로그램을 작성하세요.
(while과 Math.random(), break 사용)*/
public class DiceEx {
	public static void main(String[] args) {
		
		while(true) {
			int x = (int)(Math.random()*6) + 1;
			int y = (int)(Math.random()*6) + 1;
			
			System.out.println("("+x+","+y+")");
			
			if(x+y==5) {
				break;
			}
		}
		
		/*
		 * int x=0; int y=0;
		 * 
		 * while(x+y!=5) { x = (int)(Math.random()*6) + 1; y = (int)(Math.random()*6) +
		 * 1; System.out.println("("+x+","+y+")"); }
		 */
	}
}