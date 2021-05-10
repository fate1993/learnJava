package day0510.poly;

public class VarTest {
//... 메서드 하나당 한 번 밖에 쓸 수 없음. 
	void argTest(int a, String...n){ // 가변인수. String 타입 데이터 n개를 받아옴. 그리고 받은걸 배열로 저장. 
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	
		VarTest vt = new VarTest();
		vt.argTest(1,"a","b");
		vt.argTest(10,"a","b","c","d");
	}
}