package jdbc.madang.dto;

import java.sql.Date;

public class Orders {

	private String name;
	private String bookname;
	private Date orderdate;
	private int saleprice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	@Override
	public String toString() {
		return "Orders [name=" + name + ", bookname=" + bookname + ", orderdate=" + orderdate + ", saleprice="
				+ saleprice + "]";
	}
	
	
}
