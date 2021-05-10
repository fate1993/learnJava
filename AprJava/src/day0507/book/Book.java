package day0507.book;

public class Book {
	String bookName;
	int bookPrice;
	double bookDiscountRate;
	
	Book(){}
	Book(String bookName, int bookPrice, double bookDiscountRate) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}
	
	double getDiscountBookPrice() {
		return bookPrice * (1-bookDiscountRate*0.01);
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getBookDiscountRate() {
		return bookDiscountRate;
	}
	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}
	
	@Override
	public String toString() {
		return bookName+"\t"
				+bookPrice+"원\t"+bookDiscountRate+"%\t"
				+getDiscountBookPrice()+"원";
	}
}