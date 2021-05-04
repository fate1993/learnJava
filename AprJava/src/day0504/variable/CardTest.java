package day0504.variable;

class Card {
	//number, kind, width, height
	int number;
	String kind;
	//각각 달라야 하니까 인스턴스 변수로 선언
	
	static int width; //Ex) Card.width = 100;로 사용 
	static int height;
	//모두 동일하니까 static 변수로 선언
}

public class CardTest {
	public static void main(String[] args) {
	Card.width = 100;
	Card.height = 150;
	
	Card c1 = new Card();
	c1.kind = "clover";
	c1.number = 7;
	
	Card c2 = new Card();
	c2.kind = "spade";
	c2.number = 10;
	
	System.out.println("첫번째 카드는 "+c1.kind+" "+c1.number+"이고 \n"
			+"크기는 "+c1.width+","+c1.height+" 이다.");
	System.out.println("두번째 카드는 "+c2.kind+" "+c2.number+"이고 \n"
			+"크기는 "+c2.width+","+c2.height+" 이다.");
	//c1.width = c2.width -> 이를 통해 static 변수는 같이 쓴다는 걸 확인할 수 있다.
	
	c1.width = 50;
	c1.height = 80;
	c1.number = 13;
	
	System.out.println("첫번째 카드는 "+c1.kind+" "+c1.number+"이고 \n"
			+"크기는 "+c1.width+","+c1.height+" 이다.");
	System.out.println("두번째 카드는 "+c2.kind+" "+c2.number+"이고 \n"
			+"크기는 "+c2.width+","+c2.height+" 이다.");
	//c1의 width, height 값만 바꿨음에도 c2의 값까지 동일하게 바뀌게 된다.
	}
}
