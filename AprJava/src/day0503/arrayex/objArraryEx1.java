package day0503.arrayex;

public class objArraryEx1 {
	public static void main(String[] args) {
		String[] s_arr = new String[3];
		s_arr[0] = "java";
		s_arr[1] = "web";
		s_arr[2] = "python";
		
		for(String s : s_arr) {
			System.out.println(s);
		}
		
		String[] s_arr1 = {"google","apple","MS"};
		String[] s_arr2 = new String[] {"google","apple","MS"};
	}
}
