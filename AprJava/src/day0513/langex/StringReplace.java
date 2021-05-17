package day0513.langex;
// StringBuffer. 코딩테스트에 가끔 나옴. 그렇지만 개발하면서 쓸 일은 없을듯. 
public class StringReplace {
	private String source = "";
	private int length;
	private StringBuffer buffer;

	public StringReplace(String source) {
		this.source = source;
		length = source.length(); // 21
		buffer = new StringBuffer(length + 100); // 크기를 일부러 키워서 넉넉하게 함. 비어이는 121 크기의 char[] 생성 
	}

	public int length() {
		return length;
	}

	public String replace(String old, String nw) {
		return replace(old, nw, 0);
	}

	public String replace(String old, String nw, int pos) {
		int index = 0;
		
		if ((index = source.indexOf(old, pos)) != -1) {
			buffer.append(source.substring(pos, index));
			buffer.append(nw);

			// 발견한 위치 이후부터 다시 치환을 시작한다.
			replace(old, nw, index + old.length());
		} else {
			// 더 이상 치환할 문자열을 못 찾으면 나머지 문자열을 buffer에 저장한다.
			buffer.append(source.substring(pos));
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		String str = "000111222333111222333";
		System.out.println(str);
		StringReplace sc = new StringReplace(str);
		String s = sc.replace("111", "AAA");
		System.out.println(s);
	}
}