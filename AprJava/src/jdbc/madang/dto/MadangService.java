package jdbc.madang.dto;
// 작업에 필요한 하나의 메서드를 만들고 dao를 호출
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MadangService {

	MadangDao dao = new MadangDao();
	
	// 1.
	public void books(Connection con) {
		List<Book> list = dao.books(con);
		for( Book b : list) {
			System.out.println(b);
			// Book 타입 변수 b를 이용해서 list 배열에 있는 값을 모두 출력  
		}
	}
	// 2.
	public void cust(Connection con) {
		System.out.println("검색할 이름을 입력하세요.");
		Scanner scan  = new Scanner(System.in);
		// 입력값 name에 저장
		String name = scan.next();
		List<Customer> cList = dao.cust(name,con);
		// 받은 name 값과 con값으로 dao의 cust 메서드 호출
		if(cList.size() == 0) {
			// 결과가 없으면
			System.out.println("해당 고객은 없습니다.");
		}
		
		for(Customer c : cList) {
			System.out.println(c);
		} // cList 배열에 저장된 값을 모두 출력
		
	}
	// 3.
	public void orderCount(Connection con) {
		System.out.println("전체 주문건수는 "+ dao.orderCount(con)+"회 입니다");
	} // dao의 orderCount 메서드를 통해 sql문 출력
	
	
	// 4.
	public void orderName(Connection con) {
		System.out.print("검색할 이름을 입력하세요 > ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		// 값 입력받아서 name에 저장
		
		List<Orders> orders = dao.orderList(con, name);
		// List<Orders>의 변수 orders에 dao의 orderList 함수를 호출해서 con, 입력받은 name 저장
		Map<String, Integer> orderMap= dao.order(con, name);
		// 인터페이스 Map 타입 orderMap에 order 메서드 호출해서 con, 입력받은 name 저장
		
		if(orders.size() == 0) {
			// orerList에 저장된 값이 없으면 
			System.out.println("해당 고객의 구매내역은 없습니다.");
		} else {
			System.out.println(name+"고객님의 구매내역입니다.");
			for (Orders o : orders) {
				System.out.println(o);
				// orerList에 저장된 값 모두출력
			}
			System.out.println("총 구매 횟수는 "+orderMap.get("count")+"회입니다.");
			System.out.println("총 구매 금액은 "+orderMap.get("sum")+"원입니다.");
			// orderMap에 저장한 count, sum 값 출력
		}
	}
	public void insertCust(Connection con) {
		Customer c = new Customer();
		System.out.print("ID를 입력하세요 > ");
		Scanner scan = new Scanner(System.in);
		c.setCustid(scan.nextInt());
		System.out.print("NAME를 입력하세요 > ");
		c.setName(scan.next());
		scan.nextLine();
		System.out.print("ADDRESS를 입력하세요 > ");
		c.setAddress(scan.nextLine());
		System.out.print("PHONE를 입력하세요 > ");
		c.setPhone(scan.next());
		
		int x = dao.insertCust(con, c);
		
		if(x == 0) {
			System.out.println("저장에 실패했습니다.");
		}else {
			System.out.println("저장 성공했습니다.");
		}
		
	}
	
}






