package day0514.generic;

public class GenericMain {

	public static void main(String[] args) {
		GenericEx1<String> ge = new GenericEx1<>();
		String[] arr = {"java","may","test"};
		ge.set(arr);
		ge.print();
		
		GenericEx1<Integer> ge2 = new GenericEx1<>();
		Integer[] arr2 = {1,22,333,444};
		ge2.set(arr2);
		ge2.print();
		
		/*
		 * genericEx1 ge3 = new GenericEx1();
		 * ge3.set(arr2); 
		 * ge3.print();
		 */
	}
}