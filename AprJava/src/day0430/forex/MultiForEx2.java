package day0430.forex;

public class MultiForEx2 {
	public static void main(String[] args) {
		int count=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.println(i+" "+j+" "+j2); 
					count++;
				}
			}
		}		
		System.out.println("반복 횟수 : "+count);
	}
}
