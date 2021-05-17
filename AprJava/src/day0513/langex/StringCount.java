package day0513.langex;

public class StringCount {
	private int count;
	private String source = "";
	
	public StringCount(String source) {
		this.source = source; 
	} // 생성자
	
	public int stringCount(String s) {
		return stringCount(s,0);
	}
	
	public int stringCount(String s, int pos) {
		int index = 0;
		if(s == null || s.length() == 0)
			return 0;
		if((index = source.indexOf(s,pos)) != -1) { 
			// source. -> source에 들어있는 값 "aabbccAABBCCaa"
			count++;
			stringCount(s, index + s.length()); // 현재 메서드에서 자기 메서드를 또 호출. 재귀호출. 
		} // 2 + 2 
		return count;
	}
	
	public static void main(String[] args) {
		String str = "aabbccAABBCCaa";
		System.out.println(str); // str에 저장된 aabbccAABBCCaa toString()으로 출력
		StringCount sc = new StringCount(str); // 생성자 호출하는 객체 생성
		System.out.println("aa를"+sc.stringCount("aa") + "개 찾았습니다.");
	} // stringCount(String s) 메서드의 매개변수 s에 "aa" 넣어줌 -> s.length()는 2
}
