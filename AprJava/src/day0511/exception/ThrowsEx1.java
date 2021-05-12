package day0511.exception;

public class ThrowsEx1 {
	
	// 받아온 값을 첫번째 글자만 잘라낸다.
	public void setData(String n) throws Exception {
		if(n.length() >= 1) {
			String str = n.substring(0, 1); // 0번 인덱스부터 1	번 인덱스 앞에까지 = 첫번째 글자.
			printData(str);
		}
	}
	
	// int형으로 바꾼다.
	// 구구단 출력
	public void printData(String n) throws NumberFormatException{
		int dan = Integer.parseInt(n);
		
		System.out.println(dan+"단");
		for(int i = 1; i < 10; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
	}
	
	public static void main(String[] args) {
		ThrowsEx1 t1 = new ThrowsEx1();
		//t1.setData(args[0]);
		
		try {
			t1.setData(args[0]);
		} catch (Exception e) {
			e.printStackTrace(); // 예외 추적 메서드. 예외타입, 메시지, 위치까지 출력해준다.
		}
		System.out.println("program end");
	}
}
