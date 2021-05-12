package day0511.exception;

public class ExceptionEx1 {
	public static void main(String[] args) {
		
		int[] var = {10,200,30};
		
		for(int i = 0; i <= var.length; i++) {
			try {
				System.out.println(i+1+"회 반복"); // 4
				System.out.println("var["+i+"] :: "+var[i]);
				// try에서 예외가 발생하는 순간 아래 코드는 버리고 catch로 넘어간다.
				System.out.println("~~final : "+(i+1)); // 3
			} catch (Exception e) { // super 타입인 Exception은 모든 예외에 대해 실행 가능. 그렇지만 발생하는 예외 명을 알면 그걸 적어주는 게 더 좋음.
				System.out.println("예외가 발생했습니다.");
				System.out.println(e.getMessage());
			} finally {
				System.out.println("finally 실행 "+(i+1));
			}
		}
		
		System.out.println("program end!!");
	}
}