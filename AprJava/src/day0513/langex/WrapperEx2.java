package day0513.langex;

public class WrapperEx2 {
	public static void main(String[] args) {
		int i = new Integer("100").intValue(); // 어차피 자동으로 해주기 때문에 줄 그어져 있는 것.
		Integer i2 = Integer.parseInt("100", 10); // 10진수로 바꾸기
		int i3 = Integer.valueOf("100", 10); // 10진수로 바꾸기
		
		int i4 = Integer.parseInt("100", 2); // 2진수로 바꾸기
		int i5 = Integer.parseInt("100", 8);
		int i6 = Integer.parseInt("100", 16);
		int i7 = Integer.parseInt("FF", 16);
		// int i8 = Integer.parseInt("FF", 16); // NumberFormatException
		
		int i9 = Integer.valueOf("100", 2);
		int i10 = Integer.valueOf("100", 8);
		int i11 = Integer.valueOf("100", 16);
		int i12 = Integer.valueOf("FF", 16);
		// int i13 = Integer.valueOf("FF", 16); // NumberFormatException
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
	}
}
