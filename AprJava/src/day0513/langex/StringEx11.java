package day0513.langex;

public class StringEx11 {

	public static void main(String[] args) {

		String str = "cat,dog,pig,tiger,hourse";
		String[] animal = str.split(","); 
		
		for(String an : animal) {
			System.out.println(an);
		}
	}
}
