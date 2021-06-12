package day0524.io;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;

public class AddressList {
	HashSet<Address> set = new HashSet<>();
	// Address 타입으로
	List<Address> list = null;;
	
	public void input() {
		try(FileReader fr = new FileReader("C:\\test\\addrInput.txt");
		BufferedReader br = new BufferedReader(fr);
				) {
			
			String msg = "";
			while((msg = br.readLine()) != null) {
				// 한줄씩 읽어온 값을 msg에 넣고 그 값이 null이 아니면
				makeAddress(msg);
				// 그 값으로 makeAddress() 호출
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	//John,john@gmail.com,010-2389-2899
	void makeAddress(String msg) {
		String[] addr = msg.split(",");
		// 컴마를 기준으로 배열로 만듬. split 사용
		// Address 생성자의 형식과 동일하게 만들기 위해
		Address a = new Address(addr[0], addr[1], addr[2]);
		// 배열값으로 객체 생성
		set.add(a);
		// 받은 값을 set에 추가
	}
	
	// list로 정렬
	public void sortList() {
		list = set.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		set.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
	}
	
	// list output
	public void output() {
		try (FileWriter fr = new FileWriter("e:\\addrOutput.txt");
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br, true)){
			for(Address addr : list) {
				pr.println(addr);
			} 
		} catch (IOException e) {
		}
	}
	
	public static void main(String[] args) {
		AddressList alist = new AddressList();
		alist.input();
		alist.sortList();
		alist.output();
	}
}
