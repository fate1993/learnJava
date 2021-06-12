package ncs.exam;

import java.util.Scanner;


public class MyStackTest {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		MyStack<String> s = new MyStack<>(64); // 총 64개의 String타입 데이터를 저장할 수 있는 스택 생성
		
		while (true) {
			
			System.out.print("(1)저장하기\n(2)제일 꼭대기 데이터 삭제하기\n(3)제일 꼭대기 데이터 보기\n" +
								  "(4)저장된 데이터 보기\n(5)스택이 비어있는지 확인하기\n(6)스택에 데이터가 있는지 확인하고 있으면 데이터 개수 보여주기 : ");

			int menu = stdIn.nextInt();
			
			String x;
			switch (menu) {
			 case 1: 							
				System.out.print("데이터：");
				x = stdIn.next();
				try {
					s.push(x);
			 	} catch (MyStack.OverflowGStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			 case 2: 							
				try {
			 		x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
			 	} catch (MyStack.EmptyGStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			 case 3: 							
				try {
			 		x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
			 	} catch (MyStack.EmptyGStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			 case 4: 							
				s.dump();
				break;
			
			 case 5:
				 s.isEmpty();
				 if(s.isEmpty() == true) {
					 System.out.println("스택이 없습니다");
				 } else {
					 System.out.println("스택이 있습니다");
				 }
				 break;
				 
			 case 6:
				 s.isFull();
				 if(s.isFull() == true) {
					 System.out.println("남은 데이터 개수는 "+s.size()+"개 입니다");
				 }
				 break;
			}
		}
	}
}
