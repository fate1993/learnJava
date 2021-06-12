package day0524.net;

import java.io.*;
import java.net.*;
import java.util.*;
public class MultiServer { 
	private ArrayList<MultiServerThread> list; //Thread만 담을 수 있는 리스트 선언 
	private Socket socket; 
	public MultiServer() throws IOException {  
		list = new ArrayList<MultiServerThread>();  
		// 배열 안쓰고 ArrayList 쓴 이유? 클라이언트가 몇 명 접속할지 모르니까
		// 배열은 지정된 크기 만큼만 인원을 받을 수 있음
		ServerSocket serverSocket = new ServerSocket(3333); 
		// 서버소켓 객체 생성. 3333 포트 사용
		MultiServerThread mst = null;  
		boolean isStop = false;
		// 무한반복하기 위해 false
		
		while(!isStop) {
			// >> true
			System.out.println("Server ready...");   
			socket = serverSocket.accept();
			mst = new MultiServerThread(this);   
			list.add(mst); //리스트에 Thread를 추가시킨다 
			Thread t = new Thread(mst);   
			t.start();  
		}  
	} 
	
	public ArrayList<MultiServerThread> getList() {  
		return list; 
	} 
	
	public Socket getSocket() {  
		return socket; 
	} 

	public static void main(String[] args) throws IOException{  
		new MultiServer(); 
	}
}

