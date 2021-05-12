package day0511.example6;

public class Radio implements Volume {
	int VolLevel;
	
	public void volumeUp(int level) {
		VolLevel += level;
		System.out.println("Radio 볼륨 올립니다."+VolLevel);
	}
	public void volumeDown(int level) {
		VolLevel -= level;
		System.out.println("Radio 볼륨 내립니다."+VolLevel);
	}
}