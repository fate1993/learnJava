package day0507.book;

public class BookTest {
	public static void main(String[] args) {
		
		//3개의 Book 객체를 생성한다
		Book SQL = new Book("SQL Pluse",50000,5.0) {};
		Book Java = new Book("Java 2.0",40000,3.0) {};
		Book JSP = new Book("JSP Servlet",60000,6.0) {};
		
		Book[] book = {SQL,Java,JSP};
		
		System.out.println("책이름\t\t가격\t할인율\t할인후금액");
		System.out.println("------------------------------------------");
		
		for(Book b : book) {
			System.out.println(b);
			//System.out.println(SQL);
			//System.out.println(Java);
			//System.out.println(JSP);
		}
		
		/*
		System.out.println(SQL.toString());
		System.out.println(Java.toString());
		System.out.println(JSP.toString());
		*/
	}
}