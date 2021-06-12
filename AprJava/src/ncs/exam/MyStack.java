package ncs.exam;

public class MyStack<T> {

	// 인스턴스 변수
	private T[] stk;
	private int max;
	private int ptr;
	
	// 예외 클래스
	// 스택이 비어 있음
	public static class EmptyGStackException extends RuntimeException {
		public EmptyGStackException() {
		}
	}

	// 스택이 가득 차 있음
	public static class OverflowGStackException extends RuntimeException {
		public OverflowGStackException() {
		}
	}

	// 생성자
	public MyStack(int capacity) {
		max = capacity;
		ptr = 0;
		
		try {
			stk = (T[]) new Object[max];	// 스택 본체용 배열을  생성
		} catch (OutOfMemoryError e) {		// 생성할 수 없음
			max = 0;
		}
	}
	
	// 메서드
	// 1.푸시 메서드: push
	public T push(T x) throws OverflowGStackException {
		if (ptr >= max)									// 스택이 가득 참
			throw new OverflowGStackException();
		return stk[ptr++] = x;
	}
	
	// 2. 팝 메서드 : pop
	public T pop() throws EmptyGStackException {
		if (ptr <= 0)									// 스택이 비어 있음
			throw new EmptyGStackException();
		return stk[--ptr];
	}
	
	// 3. 피크 메서드 : peek 
	public T peek() throws EmptyGStackException {
		if (ptr <= 0)									// 스택이 비어 있음
			throw new EmptyGStackException();
		return stk[ptr - 1];
	}
	
	// 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 
		public int indexOf(T x) {
			for (int i = ptr - 1; i >= 0; i--)				// 정상 쪽에서 선형 검색
				if (stk[i].equals(x))
					return i;								// 검색 성공
			return -1;										// 검색 실패
		}
		
	// 5. 모든 스택의 요소를 삭제 : clear
		public void clear() {
			ptr = 0;
		}
		
	// 6. 용량을 확인 :  capacity
		public int capacity() {
			return max;
		}
		
	// 7. 데이터 수 확인 : size
		public int size() {
			return ptr;
		}
		
	// 8. 스택이 비어있는지 검사 : isEmpty
		public boolean isEmpty() {
			return ptr <= 0;
		}
		
	// 9. 스택이 가득 찼는지 검사 : isFull
		public boolean isFull() {
			return ptr >= max;
		}
		
	// 10. 스택 안에 있는 모든 데이터를 표시 : dump
		public void dump() {
			if (ptr <= 0)
				System.out.println("스택이 비어 있습니다.");
			else {
				for (int i = 0; i < ptr; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
		}
}
