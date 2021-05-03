package day0503.arrayex;
//향상된 for문 - foreach문 : 집합데이터에 있는 모든 데이터를 처음부터 하나씩 꺼내오는 반복문
public class ArrayEx2 {
	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//for(변수 선언 : 집합데이터 ) {변수 사용...}
		for(int i : arr) {
			System.out.println(i);
		}
	}
}

