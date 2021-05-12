package day0511.example6;

public class Speaker implements Volume{
	int VolLevel;
	int level;
	
	public void volumeUp(int level) {
		if(level > 100) {
			VolLevel += 100;
			System.out.println("speak 볼륨 올립니다."+100);
		} else {
			VolLevel += level;
			System.out.println("speak 볼륨 올립니다."+level);
		}
		
	}
	public void volumeDown(int level) {
		if(level > 0) {
			VolLevel -= 0;
			System.out.println("speak 볼륨 내립니다."+0);
		} else {
			VolLevel -= level;
			System.out.println("speak 볼륨 내립니다."+level);
		}
	}
}
