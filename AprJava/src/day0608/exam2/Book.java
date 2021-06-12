package day0608.exam2;

public class Book {
	
/*
 create table book(
 	no number primary key,
	bookName varchar2(50),
	publisher varchar2(50),
	price number
 );
 * */

	private int no;
	private String bookName;
	private String publisher;
	private int price;

	Book(int no, String bookName, String publisher, int price) {
		super();
		this.no = no;
		this.bookName = bookName;
		this.publisher = publisher;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", bookName=" + bookName + ", publisher=" + publisher + ", price=" + price + "]";
	}

}
