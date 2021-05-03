package day0503.arrayex;

public class ArraryEx3 {
	public static void main(String[] args) {
		//A반 학생의 성적은 95,71,84,93,87이다.
		//배열에 저장 후
		//점수 총합/평균을 출력하세요
		//향상된for문 사용
		
		int[] a_score = {95,71,84,93,87};
		int sum = 0;
		double avg = 0;
		for(int i : a_score) {
			sum+=i;
		}
		
		avg = sum / (double)a_score.length;
		System.out.println("a반 성적의 총합은 "+sum+"점이다.");
		System.out.println("a반 성적의 평균은 "+avg+"점이다.");
		
	}
}
