package day0428.operator;

/** 중첩 삼항연산자 예제 입니다. */
public class OperEx10 {
	/** 메인*/
	public static void main(String[] args) {
		
		int a = 15;
		int b = 16;
		
		String s = "";
		
		s += ++a >= b ? 
				a == b ? "a와 b가 같다" : (a - b) + "만큼 a가 크다" 
						: (b - a) + "만큼 b가 크다";
		
		// 첫번재 ? 찾고 >> 제일 마지막 :를 기준으로 true / false 비교
		// 두번째 ? 찾고 ?? 그 다음 : 기준으로 true / false 비교
		// * 사실상 이 기능은 if로 대체됨
		
		System.out.println(s);
	}
}
