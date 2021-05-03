package day0503.arrayex;

public class ArrayEx1 {
	public static void main(String[] args) {
		//한번 만들면 크기가 고정됨.
		//배열 만드는법 1.(잘 안쓰임)
		char ch[] = new char[4];// index : 0, 1, 2, 3
		ch[0] = 'j';
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';
		
		// (배열)변수명.length => 배열의 크기를 가져옴
		for(int i = 0; i<ch.length; i++) {
			System.out.println(ch[i]);
		}
		
		// ch[4]='x'; //범위에 넘어서는 인덱스 요청시 ArrayIndexOutOfBoundsException 발생
		// 실행시 발생하는 에러 >> runtime exception
		
		//배열 만드는법 2. 선언과 초기화를 동시에 해야함(선언 따로 초기화 따로 하면 에러)
		//메서드가 배열을 전달받는다면 3. 방식으로 선언해야함
		int i_arr[] = {1,2,3,4};
		//배열 만드는법 3.
		int i_arr2[] = new int[] {10,20,30,40};
		
		for(int i = 0; i<i_arr2.length; i++) {
			System.out.println(i_arr2[i]);
		}
	}
}