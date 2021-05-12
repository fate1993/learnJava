package day0511.example5;

public class Rice extends Food {
	
	Rice(){
		super(2000);
	}
	
	@Override
	String getName() {
		return "밥";
	}
}