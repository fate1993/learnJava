package day0430.whileex;

public class ChargeEx {
	public static void main(String[] args) {
		
		int changes = 468;
		int h = 0;
		int t = 0;
		int o = 0;
		
		while (changes >= 100) {
			changes -= 100;
			h++;
			}
		System.out.println("100원은 " + h + "개");
		while(changes>=10) {
			changes-=10;
			t++;
		}
		System.out.println("10원은 "+t+"개");
		
		while(changes>=1) {
			changes-=1;
			o++;
		}
		System.out.println("1원은 "+o+"개 주시면 됩니다.");
	}
}
