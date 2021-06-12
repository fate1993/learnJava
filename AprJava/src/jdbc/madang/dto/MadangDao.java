package jdbc.madang.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MadangDao {

	// 1. 전체 book 리스트를 출력하세요 select * from book;
	public List<Book> books(Connection con) { 
		// 리스트 출력이기 때문에 제네릭 타입으로 books 호출
		List<Book> bookList = new ArrayList<>();
		// ArrayList 객체 생성

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from book");
			ResultSet rs = pstmt.executeQuery();
			// select 문은 ResultSet 타입으로

			while (rs.next()) {
				Book b = new Book();
				// book 객체 생성. book 객체로 거기 저장된 setter 접근
				b.setBookid(rs.getInt(1)); 
				b.setBookname(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));

				bookList.add(b);
				// list에 하나씩 추가
			}

			GetConnection.closed(rs, pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookList; // list 리턴

	}
	

	// 2. 고객의 이름을 입력시 입력한 값을 포함하는 고객의 정보를 출력하세요.
	// select * from customer where name like '%이름%'
	public List<Customer> cust(String name, Connection con) {
		// list<customer> 타입으로 cust 메서드 생성 
		List<Customer> cusList = new ArrayList<Customer>();
		// ArrayList<customer> 객체 생성
		PreparedStatement pstmt;
		// preparedStatement 선언 
		try {
			pstmt = con.prepareStatement("select * from customer where name like '%" + name + "%'");
			// prepareStatement로 sql문 실행
			// like와 ? 동시에 못씀. where name like '%" + name + "%'"으로 물음표 없이 작성

			ResultSet rs = pstmt.executeQuery();
			// select 문이니까 ResultSet 타입으로 sql 결과 저장
			while (rs.next()) {
				Customer c = new Customer();
				// customer 객체 생성. 객체 이용해서 setter 값 접근. 쿼리 통해 얻은 값을 setter에 저장
				c.setCustid(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setPhone(rs.getString(4));

				cusList.add(c);
			}

			GetConnection.closed(rs, pstmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cusList;
	}

	// 3.전체 주문건수 출력하세요.
	// select * count(*) from orders
	public int orderCount(Connection con) {
		// con을 받는 orderCount 메서드 생성
		int count = 0;
		// count 변수 선언
		PreparedStatement pstmt;
		// PreparedStatement 객체 생성 
		try {
			pstmt = con.prepareStatement("select count(*) from orders");
			// PreparedStatement 변수에 connection의 메서드 prepareStatement로 sql문 저장

			ResultSet rs = pstmt.executeQuery();
			// 저장한 sql문 executeQuery로 실행하고 (select문이니까)ResultSet 타입 rs에 저장

			rs.next();
			count = rs.getInt(1);
			// count에 결과값 하나만 저장

			GetConnection.closed(rs, pstmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	// 4. 이름을 입력시 해당 고객의 주문내역을 출력하세요(주문 내역은 이름, 책이름, 주문날짜, 구매금액)
	
	public List<Orders> orderList(Connection con, String name){
		 List<Orders> oList = new ArrayList<Orders>();
		 
		 try {
			PreparedStatement pstmt 
			= con.prepareStatement("select name, bookname, orderdate, saleprice "
					+ "from customer c, orders o , book b "
					+ "where  c.custid =  o.custid and o.bookid = b.bookid and c.name = ? ");
			 	pstmt.setString(1, name);
			 ResultSet rs = pstmt.executeQuery();
		 
			 while(rs.next()) {
				 Orders o = new Orders();
				 o.setName(rs.getString(1));
				 o.setBookname(rs.getString(2));
				 o.setOrderdate(rs.getDate(3));
				 o.setSaleprice(rs.getInt(4));
				 // orders 테이블에 값 셋팅(이름, 책이름, 주문날짜, 구매금액)
				 oList.add(o);
				 // oList에 값 모두 저장
			 }
			 GetConnection.closed(rs, pstmt);
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return oList; 
	}
	
	// 해당 고객의 주문 건수와 전체 구매액수도 출력하세요.(이름이 일치하는 경우에만 출력한다.)
	
	public Map<String, Integer> order(Connection con, String name){
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		try {
			PreparedStatement pstmt 
			= con.prepareStatement(" select count(*), sum(saleprice) " +
			"from customer c, orders o , book b where  c.custid =  o.custid and o.bookid = b.bookid and c.name = ?");
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
		
			rs.next();
			map.put("count", rs.getInt(1));
			map.put("sum", rs.getInt(2));
			
			GetConnection.closed(rs, pstmt);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return map;
	}
			
	// 5. 고객 추가
	public int insertCust(Connection con, Customer cdto) {
		int x = 0;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into customer values(?,?,?,?)");
		
			pstmt.setInt(1, cdto.getCustid());
			pstmt.setString(2, cdto.getName());
			pstmt.setString(3, cdto.getAddress());
			pstmt.setString(4, cdto.getPhone());
			
			x = pstmt.executeUpdate();
			
			GetConnection.closed(pstmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return x;
	}
	
}
