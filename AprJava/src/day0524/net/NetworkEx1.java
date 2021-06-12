package day0524.net;

import java.net.*;
import java.util.*;

class NetworkEx1{
	public static void main(String[] args) {
		InetAddress ip = null;
		// 하나의 ip 주소 저장
		InetAddress[] ipArr = null;
		// 여러개 ip 주소 모아서 저장할 수 있는 배열

		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() :"+ip.getHostName());
			// 도메인 주소
			System.out.println("getHostAddress() :"+ip.getHostAddress());
			// ip 주소
			System.out.println("toString() :"+ip);

			byte[] ipAddr = ip.getAddress();
			// 바이트 배열로 가져옴. 음수가 나옴 >> 안나오도록 처리
			System.out.println("getAddress() :"+Arrays.toString(ipAddr));

			String result = "";
			for(int i=0; i < ipAddr.length;i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				// ipAddr[i]가 음수라면 256을 더하기. 양수라면 있는 값을 더하기
				result += ".";
			}
			System.out.println("getAddress()+256 :"+result);
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			ip = InetAddress.getLocalHost();
			// 본인 컴퓨터의 ip
			System.out.println("getHostName() :"+ip.getHostName());
			System.out.println("getHostAddress() :"+ip.getHostAddress());
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

		try {
			ipArr = InetAddress.getAllByName("www.naver.com");

			for(int i=0; i < ipArr.length; i++) {
				System.out.println("ipArr["+i+"] :" + ipArr[i]);
			}			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	} // main
}






