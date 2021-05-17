package day0514.list;
import java.util.*;

public class Bingo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
	// Set set = new LinkedHashSet(); 
		int[][] board = new int[5][5];
		
		for(; set.size() < 25;) {
			set.add((int)(Math.random()*60) + 1 + "");
		}
		
		Iterator<String> it = set.iterator();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
					System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			} // 10보다 작다는 건 한자리 숫자라는 뜻. 그럼 board[i][j] 앞에 공백 2칸 아니면 공백 1칸만
			System.out.println();
		}
	} // main
}
