package day0524.net;

public class MultiClientThread extends Thread {
	private MultiClient mc;
	// 멀티 클라이언트 타입 변수 선언
	// mc 멤버 쓸 수 있도록

	public MultiClientThread(MultiClient mc) {
		this.mc = mc;
	}
	
	// run() 메서드 처리
	public void run() {
		String message = null;
		String[] receivedMsg = null;
		boolean isStop = false;
		while (!isStop) {
			// 반복 처리
			try {
				message = (String) mc.getOis().readObject();
				// 소켓에 연결돼 있는 스트림 이용. 보낼 때까지 기다리고 있다가 받아서 메세지 변수에 저장
				receivedMsg = message.split("#");
				// #으로 나눔
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
				// 예외시 반복 끝내기
			}
			System.out.println(receivedMsg[0] + "," + receivedMsg[1]);
			// 확인상 쓴 코드
			if (receivedMsg[1].equals("exit")) {
				if (receivedMsg[0].equals(mc.getId())) {
					// 첫번째 메시지가 exit와 같으면 >> 내가 exit라고 입력 
					mc.exit();
				} else {
					mc.getJta().append(
							receivedMsg[0] + "님이 종료 하셨습니다."
									+ System.getProperty("line.separator"));
					mc.getJta().setCaretPosition(
							// 다음 글이 나올 커서의 포지션을 지정
							mc.getJta().getDocument().getLength());
				}
			} else {
				mc.getJta().append(
						receivedMsg[0] + " : " + receivedMsg[1]
								// 입력한 사람 아이디 + 입력 메시지
								+ System.getProperty("line.separator"));
				mc.getJta().setCaretPosition(
						mc.getJta().getDocument().getLength());
			}
		}
	}
}