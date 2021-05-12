package day0511.example6;

public class Speaker implements Volume{
	int volLevel;
	
	public void volumeUp(int level) {
		volLevel +=level;
		if(level > 100) {
			volLevel = 100;
		}
		System.out.println("speak 볼륨 올립니다."+volLevel);
	}
	public void volumeDown(int level) {
		volLevel -= level;
		if(volLevel < 0) {
			volLevel = 0;
		}
		System.out.println("speak 볼륨 내립니다."+volLevel);
	}
}