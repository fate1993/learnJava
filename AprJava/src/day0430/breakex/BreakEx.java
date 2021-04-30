package day0430.breakex;

public class BreakEx {
	public static void main(String[] args) {
		exit:
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(j==2) {
					break exit;
						}
				System.out.println(i+" , "+j);
			}
		}
	}
}
