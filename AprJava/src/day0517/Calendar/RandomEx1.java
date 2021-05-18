package day0517.Calendar;

import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {

		Random r = new Random();
		int i = r.nextInt(100);
		
		System.out.println(i);
	}
}