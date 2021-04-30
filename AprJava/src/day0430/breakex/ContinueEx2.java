package day0430.breakex;

public class ContinueEx2 {

	public static void main(String[] args) {

		lable: for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(j==2) {
					continue lable;
				}
				System.out.println(i+""+j);
	}
	}
}
}
