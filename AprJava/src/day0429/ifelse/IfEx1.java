package day0429.ifelse;

public class IfEx1 {
	public static void main(String[] args) {
		/*
		  if(조건식){조건식의 결과가 true일때 실행할 문장; 
		  }else {조건식의 결과가 false일때 실행할 문장;
		  }
		 */
		// 실행할 문장이 하나면 {}를 생략할 수 있다.
		int su1 = 40;
		String str = "";

		if (su1 >= 50) {
			str = "50 이상";
		} else {
			str = "50 미만";
		}
		
		System.out.println("if문과 관련있는 문장인가...");

		System.out.println(su1 + "은/는 " + str);
	}

}
