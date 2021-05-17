package day0513.langex;
// autoboxing
public class WrapperEx3 {
	public static void main(String[] args) {
		int i = 10;
		
		Integer intg = i;
		// Integer intg = new Integer(i); 
		Object obj = i;
		// Object obj = new Integer(i);
		Long lng = 100L;
		// Long lng = new Long(100L);
		
		// 참조형과 기본형 간의 연산이 가능해짐
		int i2 = intg + 10;
		long l = intg + lng;
		
		Integer intg2 = new Integer(20);
		int i3 = intg2;
		// int i3 = intg2.intValue();
		
		long lng3 = intg2;
		// long lng3 = intg2.intValue();
		// Long lng4 = intg2; // 에러
		
		System.out.println("i : " + i);
		System.out.println("intg : "+ intg);
		System.out.println("obj : "+ obj);
		System.out.println("lng : "+ lng);
	}
}