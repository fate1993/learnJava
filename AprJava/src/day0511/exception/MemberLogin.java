package day0511.exception;

import java.util.Scanner;

public class MemberLogin {
	
	void login(Member m) throws MemberException{
		if(m.getId().equals(m.getPassword())) {
			System.out.println("로그인 성공");
		} else {
			throw new MemberException();
		}
	}
	
	public static void main(String[] args) {
		MemberLogin ml = new MemberLogin();
		Scanner scan = new Scanner(System.in);
		Member m = new Member();
		boolean run = true;
		while(run) {
			System.out.println("id를 입력하세요.");
			m.setId(scan.next());
			System.out.println("비밀번호를 입력하세요.");
			m.setPassword(scan.next());
			
			try {
				ml.login(m);
				run = false;
			} catch(MemberException e) {
				System.out.println(e.getMessage());
				System.out.println("다시 로그인 하세요");
			}
		}
	}

}
