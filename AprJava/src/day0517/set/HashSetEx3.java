package day0517.set;

import java.util.HashSet;

public class HashSetEx3 {

	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David", 10));
		set.add(new Person2("David", 10));
		
		System.out.println(set);
	}
}

class Person2 {
	String name;
	int age;
	
	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) { // 중복제거
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name) && age == tmp.age;
		} 
		return false;
	}
	
	@Override
	public int hashCode() { // 중복제거
		return (name + age).hashCode(); // name + age -> String. HashCode()는 String의 저장값 확인.
	}
	
	@Override
	public String toString() {
		return name + ":" + age;
	}
}