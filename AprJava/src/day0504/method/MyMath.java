package day0504.method;

public class MyMath {

	//add - int,int 받아서 더한 값을 반환
	//subtract - int,int 받아서 뺀 결과를 반환
	//multiply - int, int 받아서 곱한 결과를 반환
	//divide - double, double 받아서 나눈 결과를 반환
	
	int add(int a, int b) {
		return a+b;
	}
	
	int subtract(int a, int b) {
		return a-b;
	}
	
	int multiply(int a, int b) {
		return a*b;
	}
	
	double divide(double a, double b) {
		return a/b;
	}
	
	public static void main(String[] args) {
		MyMath mm = new MyMath();
		int add = mm.add(1, 2);
		System.out.println(add);
		System.out.println(mm.multiply(10, 20));
		
		System.out.println(mm.divide(10, 5));
		
	}
}
