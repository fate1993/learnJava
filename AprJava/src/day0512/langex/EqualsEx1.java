package day0512.langex;



class EqualsEx1 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);

		if (v1.equals(v2)) {// 주소값을 비교
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}

		v2 = v1; // v2에 v1의 주소값을 대입

		if (v1.equals(v2)) {//
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}
	} // main
}
// == , Object.equals() -> 객체의 주소값비교

class Value extends Object{
	int value;
	
	//equals() 오버라이딩
	@Override
	public boolean equals(Object obj) { //Object 타입의 obj
		if(obj != null && obj instanceof Value) { // && and 연산자. Object 타입인 obj 매개변수를 Value 타입으로 형변환 가능한지. Value에 선언된 int를 통해 두 값을 비교하기 위해
			return value == ((Value)obj).value; 
		} else {
			return false;
		}
	}

	Value(int value) {
		this.value = value;
	}
}