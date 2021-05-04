package day0504.method;

public class ReturnTest {

		int add(int a, int b) {
			return a+b;
		}
		void add(int a, int b, int[] result) {
			result[0] = a+b;
		}
	
		public static void main(String[] args) {
			ReturnTest r = new ReturnTest();
			
			System.out.println(r.add(3, 5));
			
			int[] result2 = {0};
			r.add(3, 5, result2);
			System.out.println(result2[0]);
		}
}
