package jdbc.madang.dto;

import java.sql.Connection;
import java.util.Scanner;

// 일을 시키는 역할만
public class MadangMain {

	public static void main(String[] args) {
		Connection con = GetConnection.getMadangConnection();
		MadangService ds = new MadangService();
		System.out.print("메뉴를 선택하세요(1~5) > ");
		Scanner scan = new Scanner(System.in);
		int menu = scan.nextInt();
		
		if(menu == 1) {
			ds.books(con);
		}else if(menu == 2) {
			ds.cust(con);
		}else if( menu == 3) {
			ds.orderCount(con);
		}else if(menu == 4) {
			ds.orderName(con);
		}else if(menu == 5) {
			ds.insertCust(con);
		}else {
			System.out.println("잘못된 번호를 입력하셨습니다.");
		}
		
		GetConnection.closed(con);
	}


}


