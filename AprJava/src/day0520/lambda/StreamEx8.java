package day0520.lambda;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student8 {
	String name;
	boolean isMale; // 성별
	int hak;		// 학년
	int ban;		// 반 기준
	int score;

	Student8(String name, boolean isMale, int hak, int ban, int score) { 
		this.name	= name;
		this.isMale	= isMale;
		this.hak	= hak;
		this.ban	= ban;
		this.score  = score;
	}

	String	getName()  { return name;}
	boolean isMale()   { return isMale;}
	int		getHak()   { return hak;}
	int		getBan()   { return ban;}
	int		getScore() { return score;}

	public String toString() { 
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남":"여", hak, ban, score); 
	}

	enum Level {
		HIGH, MID, LOW
	} // 0, 1, 2 순서. HIGH >> MID >> LOW 순서로 정렬됨(트리셋)
}
//groupingBy 같은 값을 가지고 있는 데이터끼리 그룹으로 묶어줌
class StreamEx8 {
	public static void main(String[] args) {
		Student8[] stuArr = {
			new Student8("나자바", true,  1, 1, 300),	
			new Student8("김지미", false, 1, 1, 250),	
			new Student8("김자바", true,  1, 1, 200),	
			new Student8("이지미", false, 1, 2, 150),	
			new Student8("남자바", true,  1, 2, 100),	
			new Student8("안지미", false, 1, 2,  50),	
			new Student8("황지미", false, 1, 3, 100),	
			new Student8("강지미", false, 1, 3, 150),	
			new Student8("이자바", true,  1, 3, 200),	

			new Student8("나자바", true,  2, 1, 300),	
			new Student8("김지미", false, 2, 1, 250),	
			new Student8("김자바", true,  2, 1, 200),	
			new Student8("이지미", false, 2, 2, 150),	
			new Student8("남자바", true,  2, 2, 100),	
			new Student8("안지미", false, 2, 2,  50),	
			new Student8("황지미", false, 2, 3, 100),	
			new Student8("강지미", false, 2, 3, 150),	
			new Student8("이자바", true,  2, 3, 200)	
		};
		// 반 별 그룹화
		System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
		Map<Integer, List<Student8>> stuByBan = Stream.of(stuArr)
				                                     .collect(groupingBy(Student8::getBan));
		// 같은 반에 있는 애들을 키로. 해당 반을 리스트로 묶어서 가져옴
		for(List<Student8> ban : stuByBan.values()) {
			for(Student8 s : ban) {
				System.out.println(s);
			}
		}
		// 성적별 그룹화
		System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
		Map<Student8.Level, List<Student8>> stuByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
						 if(s.getScore() >= 200) return Student8.Level.HIGH;
						 // 성적이 HIGH(키 값). HIGH라는 키에 리스트를 만들어서 학생을 저장. 
					else if(s.getScore() >= 100) return Student8.Level.MID;
					else                         return Student8.Level.LOW;
				}));

		TreeSet<Student8.Level> keySet = new TreeSet<>(stuByLevel.keySet());
		// 트리셋으로 만들어서 정렬

		for(Student8.Level key : keySet) {
			System.out.println("["+key+"]");
			

			for(Student8 s : stuByLevel.get(key))
				System.out.println(s);
			System.out.println();
		} // HIGH 키, MID 키, LOW 키 순으로 반복해서 출력해줌

		System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
		Map<Student8.Level, Long> stuCntByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
						 if(s.getScore() >= 200) return Student8.Level.HIGH;
					else if(s.getScore() >= 100) return Student8.Level.MID;
					else                         return Student8.Level.LOW;
				}, counting())); // counting. 해당 레벨에 대해 갯수만 뽑아서 가져옴

		for(Student8.Level key : stuCntByLevel.keySet())
			System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
		System.out.println();
/*
		for(List<Student8> level : stuByLevel.values()) {
			System.out.println();
			for(Student8 s : level) {
				System.out.println(s);
			}
		}
*/
		System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");
		Map<Integer, Map<Integer, List<Student8>>> stuByHakAndBan =
          Stream.of(stuArr)
				.collect(groupingBy(Student8::getHak,
						 groupingBy(Student8::getBan)
				)); 

		for(Map<Integer, List<Student8>> hak : stuByHakAndBan.values()) {
			for(List<Student8> ban : hak.values()) {
				System.out.println();
				for(Student8 s : ban)
					System.out.println(s);
			}
		}

		System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
		Map<Integer, Map<Integer, Student8>> topStuByHakAndBan = Stream.of(stuArr)
				.collect(groupingBy(Student8::getHak,
						 groupingBy(Student8::getBan,
							collectingAndThen(
								maxBy(comparingInt(Student8::getScore)),
								// 최대값 가지고 있는 객체 꺼내고
								Optional::get
								// 옵셔널 타입. 원래인 스튜던트 타입으로 가져올 수 있도록함 
							)
						)
				));

		for(Map<Integer, Student8> ban : topStuByHakAndBan.values())
			for(Student8 s : ban.values())
				System.out.println(s);

		System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
		Map<String, Set<Student8.Level>> stuByScoreGroup = Stream.of(stuArr)
			.collect(groupingBy(s-> s.getHak() + "-" + s.getBan(),
					mapping(s-> {
						 if(s.getScore() >= 200) return Student8.Level.HIGH;
					else if(s.getScore() >= 100) return Student8.Level.MID;
						 else                    return Student8.Level.LOW;
					} , toSet())
			));

		 Set<String> keySet2 = stuByScoreGroup.keySet();

		for(String key : keySet2) {
			System.out.println("["+key+"]" + stuByScoreGroup.get(key));
		}
	}  // main의 끝
}
