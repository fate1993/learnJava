package day0524.io;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Address implements Comparable<Address> {
	
	String name;
	String email;
	String tel;
	// 인스턴스 변수 선언
	
	public Address(String name, String email, String tel) {
		super();
		this.name = name;
		this.email = email;
		this.tel = tel;
	} // 초기화
	
	@Override
	public int hashCode() {
		return name.hashCode();
		// 이름의 해쉬코드값 리턴
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Address) {
			return name.equals(((Address) obj).name);
		}
		return false;
	} // name이 같으면 같은 객체로 인식
	
	@Override
	public int compareTo(Address o) {
		return name.compareTo(o.name);
	} // name 값을 기준으로 오름차순 하기 위해 크기 비교 
	
	@Override
	public String toString() {
		return "Address [name=" + name + ", email=" + email + ", tel=" + tel + "]";
	}
}





