package day0507.ncs.test1;

import java.util.Scanner;

public class GoodsTest {
	public static void main(String[] args) {
		Goods g = new Goods();
		
		System.out.println("다음 항목의 값을 입력하시오");
		Scanner scan = new Scanner(System.in);
		System.out.print("상품명 : ");
		g.setName(scan.nextLine());
		
		System.out.print("가격 : ");
		g.setPrice(scan.nextInt());
		
		System.out.print("수량 : ");
		g.setQuantity(scan.nextInt());
		
		System.out.println();
		
		System.out.println("입력된 결과는 다음과 같습니다");
		System.out.println(g.toString());
	}
}
