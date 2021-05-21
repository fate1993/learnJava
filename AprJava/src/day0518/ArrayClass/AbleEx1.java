package day0518.ArrayClass;

import java.util.Arrays;
import static java.lang.System.out;
import java.util.Comparator;

class Able {
	String empno;
	int net, ejb, xml, total;
	
	public Able(int total) { // 생성자
		this.total = total;
	}
	public Able(String no, int n, int e, int x) { // 생성자
		empno = no;
		net = n;
		ejb = e;
		xml = x;
		total = n + e + x;
	}
	
	public int getTotal() {
		return total;
	}
}
