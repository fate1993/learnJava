package day0514.list;

import java.util.*;

class QueueEx1 {
	static Queue q = new LinkedList(); // 먼저 들어간게 먼저 나와야하기 때문에 큐 사용
	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 한다.

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

		while (true) {
			System.out.print(">>");
			try {
				// 화면으로부터 라인단위로 입력받는다.
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim(); // 앞뒤 공백을 잘라내기 위해 trim() 사용

				if ("".equals(input))
					continue; // while문으로 다시 돌아감.

				if (input.equalsIgnoreCase("q")) {
					System.exit(0); // 프로그램을 종료 0은 특별한 의미는 없음. 상태?를 나타내는.
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					// 입력받은 명령어를 저장하고,
					save(input);

					// LinkedList의 내용을 보여준다.
					LinkedList tmp = (LinkedList) q;
					ListIterator it = tmp.listIterator(); // iterator 반복자.큐에 저장돼 있던 내용들을 하나씩 꺼내서 쓸 수 있도록 방법을 만들어주는.

					while (it.hasNext()) { // 다음줄에 데이터가 있는지 확인하고 있으면 한줄 내려가고... 반복
						System.out.println(++i + "." + it.next());
					}
				} else {
					save(input); // 저장 후
					System.out.println(input); // 출력
				} // if(input.equalsIgnoreCase("q")) {
			} catch (Exception e) {
				System.out.println("입력오류입니다.");
			}
		} // while(true)
	} // main()

	public static void save(String input) {
		// queue에 저장한다.
		if (!"".equals(input)) // 입력한 것과 빈문자열과 같지 않다면
			q.offer(input); // linkedlist에 추가 해라.

		// queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
		if (q.size() > MAX_SIZE) // size()는 Collection인터페이스에 정의
			q.remove(); // 큐는 제일 먼저 나오는 값부터 지움.
	}
}// end of class