package day0524.net;

import java.net.*;
import java.io.*;

public class UdpClient {
	public void start() throws IOException, UnknownHostException {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("192.168.0.90");
		// InetAddress 객체 생성

		// 데이터가 저장될 공간으로 byte배열을 생성한다. 0이 100개 저장
		byte[] msg = new byte[100];

		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		// ip, port가 있음 >> 보내는 DatagramPacket 100칸짜리에서 데이터 한칸(0) 보냄
		// 서버가 클라이언트에 메시지를 보내려면 ip를 알아야하기 때문에 보내고 싶으면 포트와 ip를 알아야함
		// 그걸 알 수 있도록 먼저 패킷을 날리는 것(0)
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

		datagramSocket.send(outPacket);   // DatagramPacket을 전송한다.
		datagramSocket.receive(inPacket); // DatagramPacket을 수신한다.(기다리고 있음) 받아서 inPacket에 저장

		System.out.println("current server time :" + new String(inPacket.getData()));
		// 바이트 배열이니까 문자열로 만들어서 출력
		datagramSocket.close();
	} // start()

	public static void main(String args[]) {
		try {
			new UdpClient().start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main 
}