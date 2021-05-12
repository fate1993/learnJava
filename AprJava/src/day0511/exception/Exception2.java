package day0511.exception;

public class Exception2 {
// 멀티 catch 문
	public static void main(String[] args) {
		try {
		
		int data = 100;
		int num = Integer.parseInt(args [0]);
		int result = data / num;
		
		System.out.println("결과 : "+result);
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("실행시 값을 넣어주세요");
		} catch (NumberFormatException ne) {
			System.out.println("숫자만 입력하세요");
		} catch (ArithmeticException are) {
			System.out.println("0은 입력할 수 없습니다.");
		}
	}
}