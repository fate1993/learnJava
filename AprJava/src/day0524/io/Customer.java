package day0524.io;

import java.io.*;

public class Customer implements Serializable {

	private transient String name;
	// 직렬화 대상으로 하고 싶지 않다면 transient >> 파일로 보내지지 않음

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "당신의 이름:" + name;
	}

}
