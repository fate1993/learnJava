package day0514.generic;

public class GenericEx1<T> {

	T[] v;
	// String[]가 될수도 int[]가 될수도 있는 것.
	
	public void set(T[] n) {
		v = n;
	}
	public void print() {
		for (T s : v)
			System.out.println(s);
	}
}