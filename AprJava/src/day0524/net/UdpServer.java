package day0524.net;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UdpServer {
	public void start() throws IOException {
		// 포트 7777번을 사용하는 소켓을 생성한다.
		DatagramSocket socket = new DatagramSocket(7777);
		DatagramPacket inPacket, outPacket;
		// 받아오는 패킷과 보낼 패킷 선언 
		
		byte[] inMsg = new byte[10]; 
		// 바이트 배열 선언
		byte[] outMsg;

		while (true) {
			// 계속 요청을 받을 수 있음
			// 데이터를 수신하기 위한 패킷을 생성한다.
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			// 10개의 데이터를 받아올 수 있도록 DatagramPacket 패킷 

			// 패킷을 통해 데이터를 수신(receive)한다.
			// 서버에 패킷을 던질 때까지 기다리는 상태
			socket.receive(inPacket);

			// 수신한 패킷으로 부터 client의 IP주소와 Port를 얻는다.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();

			// 서버의 현재 시간을 시분초 형태([hh:mm:ss])로 반환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes(); // time을 byte배열로 변환한다.

			// 패킷을 생성해서 client에게 전송(send)한다.
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			// 배열안에 있는 모든 내용을 클라이언트의 ip, 포트 번호를 통해 보냄
			socket.send(outPacket);
			// 보내놓고 다시 while문 반복으로 대기
		}
	} // start()

	public static void main(String args[]) {
		try {
			new UdpServer().start(); // UDP서버를 실행시킨다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main
}
