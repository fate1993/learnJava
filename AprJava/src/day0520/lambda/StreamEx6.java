package day0520.lambda;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class StreamEx6 {
	public static void main(String[] args) {
		Student6[] stuArr = {
			new Student6("이자바", 3, 300),
			new Student6("김자바", 1, 200),
			new Student6("안자바", 2, 100),
			new Student6("박자바", 2, 150),
			new Student6("소자바", 1, 200),
			new Student6("나자바", 3, 290),
			new Student6("감자바", 3, 180)	
		};
		// 여러명의 정보를 배열에 받아옴

		// 학생 이름만 뽑아서 List<String>에 저장
		List<String> names = Stream.of(stuArr).map(Student6::getName)
									          .collect(Collectors.toList());
							// 저장된 정보중 name만 꺼내옴.
							// 다시 리스트로 만들기 위해 Collectors.toList()를 통해 문자열로 만듬
		System.out.println(names);

		// 스트림을 배열로 변환
		Student6[] stuArr2 = Stream.of(stuArr).toArray(Student6[]::new);
											// 원본 타입의 배열로 생성하고 toArray하면 순서대로 저장.

		for(Student6 s : stuArr2)
			System.out.println(s);
		// 출력된 것 확인

		// 스트림을 Map<String, Student>로 변환. 학생 이름이 key 
		Map<String,Student6> stuMap = Stream.of(stuArr)
						                   .collect(Collectors.toMap(s->s.getName(), p->p));
											// 이름과 스튜던트 객체 짝지어서 맵으로 담고 컬렉트
		for(String name : stuMap.keySet())
			System.out.println(name +"-"+stuMap.get(name));
		
		long count = Stream.of(stuArr).collect(counting());
		long totalScore = Stream.of(stuArr)
                                .collect(summingInt(Student6::getTotalScore));
									// 이태릭체. 컬렉터즈에서 제공하는 메서드. 토탈스코어 뽑아내서 롱타입?으로 
		System.out.println("count="+count);
		System.out.println("totalScore="+totalScore);

		totalScore = Stream.of(stuArr)
			               .collect(reducing(0, Student6::getTotalScore, Integer::sum));
									// 초기값은 0 꺼내올 값으 겟 토탈 스코어, 다더한다. 
		System.out.println("totalScore2="+totalScore);

		Optional<Student6> topStudent = Stream.of(stuArr)
		                                     .collect(maxBy(Comparator.comparingInt(Student6::getTotalScore)));
													// 인트값 비교하고 최대값 뽑아옴
		System.out.println("topStudent="+topStudent.get());

		IntSummaryStatistics stat = Stream.of(stuArr)
					                      .collect(summarizingInt(Student6::getTotalScore));
													// 모든 통계 내역이 나오도록함. 		
		System.out.println(stat);

		String stuNames = Stream.of(stuArr)
							    .map(Student6::getName)
							    .collect(joining(",", "{", "}"));
										// 문자열로 합쳐줌
		System.out.println(stuNames);
	}
}

class Student6 implements Comparable<Student6> {
	String name;
	int ban;
	int totalScore;

	Student6(String name, int ban, int totalScore) { 
		this.name =name;
		this.ban =ban;
		this.totalScore =totalScore;
	}

	public String toString() { 
	   return String.format("[%s, %d, %d]", name, ban, totalScore).toString(); 
	}

	String getName() { return name;}
	int getBan() { return ban;}
	int getTotalScore() { return totalScore;}

	public int compareTo(Student6 s) {
		return s.totalScore - this.totalScore;
	}
}
