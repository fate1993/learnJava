package day0524.net;

import java.io.*;
import java.net.*;

public class MultiServerThread implements Runnable {
	private Socket socket;
	private MultiServer ms;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	// writeutp로 안쓰고 스트림 객체로
	// 저장하고 있는 문자열을 저장하고 받아옴

	public MultiServerThread(MultiServer ms) {
		this.ms = ms;
	}

	// 고객들 run() 실행
	public synchronized void run() {
		boolean isStop = false;
		try {
			socket = ms.getSocket();
			// n번?? 클라이언트와 연결된 소켓을 꺼내옴
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			String message = null;
			while (!isStop) {
				message = (String) ois.readObject();
				String[] str = message.split("#");
				if (str[1].equals("exit")) {
					// 종료
					broadCasting(message);
					isStop = true;
					// 반복 못하도록 true
				} else {
					broadCasting(message);
				}
			}
			
			ms.getList().remove(this);
			// 현재 스레드 제거
			System.out.println(socket.getInetAddress() + "정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
			// 남은 리스트(사람수) 출력
		} catch (Exception e) {
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + "비정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		}
	}

	public void broadCasting(String message) throws IOException {
		// arraylist에 있는 소캣 꺼내와서 
		for (MultiServerThread ct : ms.getList()) {
			// 고객 꺼내서
			ct.send(message);
		}
	}

	public void send(String message) throws IOException {
		oos.writeObject(message);
		// 모든 고객에게 메시지 보내기
	}
}
