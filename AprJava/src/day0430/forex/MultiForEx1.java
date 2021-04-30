package day0430.forex;

public class MultiForEx1 {
//1~3 * 3
	public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			for(int j=1; j<=3; j++) {
				System.out.println("i : "+i+" j : "+j);
			}//inner for
			System.out.println("--------------");
		}//outer for
		System.out.println("program end!!");
	} // main end
}//class end
