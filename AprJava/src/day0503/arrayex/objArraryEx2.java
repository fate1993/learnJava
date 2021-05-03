package day0503.arrayex;

public class objArraryEx2 {
	public static void main(String[] args) {
		//String[] args : 작업을 할 때 실행시 필요한 값이 있으면 입력받는 곳(매개변수: argument)
		//여러개를 받아와야 하는 경우도 있기 때문에 배열로 선언, 모든 데이터는 String타입의 데이터다.
		
		for(String s : args) {
			System.out.println(s);
		}
		
		//argument가 없으면 length가 0인 배열 생성
			String[] arr;

			if (args.length > 0) {
				arr = args;
				for (int i = 0; i < arr.length; i++)
					System.out.println("arr[" + i + "]:" + arr[i]);
			} else {
				System.out.println("args의 내용이 없습니다.");
			}
	}
}
