package day0513.langex;

class StringEx7 {
	public static void main(String[] args) {
		int value = 100;
		String strValue = String.valueOf(value); // toString과 비슷. String 타입으로 변환

		int value2 = 100;
		String strValue2 = value2 + ""; // 연산으로 int -> String 형변환

		System.out.println(strValue);
		System.out.println(strValue2);
	}
}