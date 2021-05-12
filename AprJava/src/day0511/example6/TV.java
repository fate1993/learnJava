package day0511.example6;

public class TV implements Volume{
	int volLevel;
	
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println("TV 볼륨 올립니다."+volLevel);
	}
	public void volumeDown(int level) {
		volLevel -= level;
		if(volLevel < 0) {
			volLevel = 0;
		} 
		System.out.println("TV 볼륨 내립니다."+volLevel);
	}
}