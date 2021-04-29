package day0429.switchex;

public class SwitchEx1 {
	public static void main(String[] args) {
		// 주사위 굴리기
		// 난수 : 무작위로 추출된 값 Math.random()
		int num = (int)(Math.random()*6) + 1; // 1~6 사이에서 랜덤값 발생
	
		switch (num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		case 6:
			System.out.println("6번이 나왔습니다.");
			break;
		default:
			break;
		}
	}
}
