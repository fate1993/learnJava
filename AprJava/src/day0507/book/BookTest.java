package day0507.book;

public class BookTest {
	public static void main(String[] args) {
		
		//3개의 Book 객체를 생성한다
		Book SQL = new Book("SQL Pluse",50000,5.0) {};
		Book Java = new Book("Java 2.0",40000,3.0) {};
		Book JSP = new Book("JSP Servlet",60000,6.0) {};
		
		System.out.println("책이름\t\t"+"가격\t"+"할인율\t"+"할인후금액\t");
		System.out.println("------------------------------------------");
		System.out.println(SQL.toString());
		System.out.println(Java.toString());
		System.out.println(JSP.toString());
		// 각각의 Book 객체의 정보를 실행 결과 예와 같이 출력한다
	}
}