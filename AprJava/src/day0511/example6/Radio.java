package day0511.example6;

public class Radio implements Volume {
	int volLevel;
	
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println("Radio 볼륨 올립니다."+volLevel);
	}
	
	public void volumeDown(int level) {
		volLevel -= level;
		System.out.println("Radio 볼륨 내립니다."+volLevel);
	}
}