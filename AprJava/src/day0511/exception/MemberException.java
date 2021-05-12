package day0511.exception;
//로그인 실패시에만 발생하는 예외
public class MemberException extends Exception {
	MemberException(){
		super("로그인 실패!!");
	}
}
