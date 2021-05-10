package day0507.ncs.test1;

public class Goods {
	String name;
	int price;
	int quantity;
	
	
	public Goods() {}
	public Goods(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return getName()+ ", " + getPrice() + "원, " + getQuantity() + "개"+"\n"+"총 구매 가격: "+(getPrice()*getQuantity())+" 원";
	} 
	
	/*@Override
	public String toString() {
		return name+", "+price+" 원, "+quantity+"개"+"\n"+"총 구매 가격: "+(price*quantity)+" 원";
	}*/
}