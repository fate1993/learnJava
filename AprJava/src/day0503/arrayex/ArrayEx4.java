package day0503.arrayex;

public class ArrayEx4 {
	public static void main(String[] args) {
	//A반 학생의 성적은 79,88,91,33,100,55,95이다.
	//배열에 저장 후 최고점, 최점을 출력하세요.
		
		int[] a_score = {79,88,91,33,100,55,95};
		int max = 79;
		int min = 79;
		
		for(int i = 1; i < a_score.length; i++) {
			if(max < a_score[i]) {
				max = a_score[i];
			}
			if(min>a_score[i]) {
				min=a_score[i];
			}
		}
		
		System.out.println("최고점은 "+max+"점입니다.");
		System.out.println("최저점은 "+min+"점입니다.");
		
		/*
		 * for (int i = 0; i < a_score.length; i++) { max = a_score[i] > a_score[max] ?
		 * i : max; }
		 * 
		 * for (int i = 0; i < a_score.length; i++) { min = a_score[i] < a_score[min] ?
		 * i : min; }
		 * 
		 * System.out.println("최고점은 "+a_score[max]+"점입니다.");
		 * System.out.println("최저점은 "+a_score[min]+"점입니다.");
		 */
}
}
