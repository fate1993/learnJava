package day0430.breakex;

public class ContinueEx {

	public static void main(String[] args) {
		//4의 배수를 제외한 나머지 수 출력
		for(int i=0; i<20; i++) {
			if(i%4==0) {
				continue;
			}
			System.out.println(i);
		}
	}

}
