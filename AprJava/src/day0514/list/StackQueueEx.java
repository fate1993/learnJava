package day0514.list;
import java.util.*;

class StackQueueEx {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		Queue<String> q = new LinkedList<>(); // Queue인터페이스의 구현체인 LinkedList를 사용

		st.push("0");
		st.push("1");
		st.push("2");
		// 스택에 저장한 순서대로 쌓여감

		q.offer("0");
		q.offer("1");
		q.offer("2");
		// add, offer 둘다 사용 가능. 아래부터 위로 저장됨. 

		System.out.println("= Stack =");
		while (!st.empty()) {
			System.out.println(st.pop()); // 위에서부터 첫번째 데이터를 삭제하면서 꺼내옴
		}

		System.out.println("= Queue =");
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}