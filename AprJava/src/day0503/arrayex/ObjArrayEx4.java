package day0503.arrayex;

public class ObjArrayEx4 {
	public static void main(String[] args){
		String[] arr = {"java","mybatis","String"};  //arr.length=3
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
		for(String s : arr)
			System.out.println(s);
		//집합데이터(배열)에서 데이터를 한번씩 다 꺼내올때 사용
		
		/*for(변수 선언 : 집합데이터){
		수행문
		}*/
		
	}
}
