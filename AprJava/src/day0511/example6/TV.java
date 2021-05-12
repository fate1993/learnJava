package day0511.example6;

public class TV implements Volume{
	int VolLevel;
	
	public void volumeUp(int level) {
		VolLevel += level;
		System.out.println("TV 볼륨 올립니다."+VolLevel);
	}
	public void volumeDown(int level) {
		VolLevel -= level;
		if(VolLevel < 0) {
			System.out.println("TV 볼륨 내립니다."+0);
		} else {
			System.out.println("TV 볼륨 내립니다."+VolLevel);
		}
	}
}