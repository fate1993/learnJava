package day0520.lambda;

import java.util.function.IntBinaryOperator;

public class Exam1 {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
public static void main(String[] args) {
		// 최대값 얻기
		int max = maxOrMin(
				(a, b) -> { 
					if (a >= b) 
						return a; 
					else 
						return b; 
					} 
				// Integer :: max
		);
		System.out.println("최대값: " + max);

		// 최소값 얻기
		int min = maxOrMin(
				(a, b) -> { 
					if (a <= b) 
						return a; 
					else 
						return b; 
					} 
				// Integer :: mix
		);
		System.out.println("최소값: " + min);
	}
}









