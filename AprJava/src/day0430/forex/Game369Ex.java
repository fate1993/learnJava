package day0430.forex;

public class Game369Ex {
	public static void main(String[] args) {
		//1~100까지 369 게임. 3, 6, 9가 들어간 숫자 옆에 "짝"을 붙여 출력. 
		for(int i = 1; i <= 100; i++) {
			if(i <=9) // 369는 1부터 100까지 일정한 패턴으로 발생하지 않기 때문에 1~9(한자리), 10~99(두자리)를 구분해서 조건을 줌.
				{
				if(i % 3 == 0) //1~9까지는 3의 배수가 해당. 
				{
					System.out.println(i+"짝");
				} else {
					System.out.println(i);
				}
			} else {
				int first = i / 10; // 00자리 중 첫번째 숫자 확인.
				int second = i % 10; // 00자리 중 두번째 숫자 확인.
				
				if(first % 3 == 0) // 첫번째 숫자가 3의 배수인가?
				{
					System.out.println(i+"짝");
				} else if(second % 3 ==0 && second != 0) // 두번째 숫자가 3의 배수이며, 0이 아닌가? 
				{
					System.out.println(i+"짝");
				}else {
					System.out.println(i);
				}
			}
		}	
	}
}
