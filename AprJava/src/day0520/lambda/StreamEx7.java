package day0520.lambda;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
//partitioningBy : boolean값 기준으로 나눔
class Student7 {
	String name;
	boolean isMale; // 성별 남 : true/ 여 : false
	int hak; // 학년
	int ban; // 반
	int score;

	Student7(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() {
		return name;
	}

	boolean isMale() {
		return isMale;
	}

	int getHak() {
		return hak;
	}

	int getBan() {
		return ban;
	}

	int getScore() {
		return score;
	}

	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
	}

	// groupingBy()에서 사용
	enum Level {
		HIGH, MID, LOW
	} // 성적을 상, 중, 하 세 단계로 분류. 상수로 표현 바뀔 수 없음.
}
//partitioningBy :true/false
class StreamEx7 {
	public static void main(String[] args) {
		Student7[] stuArr = { new Student7("나자바", true, 1, 1, 300), new Student7("김지미", false, 1, 1, 250),
				new Student7("김자바", true, 1, 1, 200), new Student7("이지미", false, 1, 2, 150),
				new Student7("남자바", true, 1, 2, 100), new Student7("안지미", false, 1, 2, 50),
				new Student7("황지미", false, 1, 3, 100), new Student7("강지미", false, 1, 3, 150),
				new Student7("이자바", true, 1, 3, 200),

				new Student7("나자바", true, 2, 1, 300), new Student7("김지미", false, 2, 1, 250),
				new Student7("김자바", true, 2, 1, 200), new Student7("이지미", false, 2, 2, 150),
				new Student7("남자바", true, 2, 2, 100), new Student7("안지미", false, 2, 2, 50),
				new Student7("황지미", false, 2, 3, 100), new Student7("강지미", false, 2, 3, 150),
				new Student7("이자바", true, 2, 3, 200) };
				// 남자 여자도 구분 가능
		System.out.printf("1. 단순분할(성별로 분할)%n");
		Map<Boolean, List<Student7>> stuBySex = Stream.of(stuArr).collect(partitioningBy(Student7::isMale));
															// 분할의 기준은 isMale 메서드(true, false). true이면 그 키에 맵핑된 리스트에 내용 추가

		List<Student7> maleStudent7 = stuBySex.get(true);
		List<Student7> femaleStudent7 = stuBySex.get(false);

		for (Student7 s : maleStudent7)
			System.out.println(s);
		for (Student7 s : femaleStudent7)
			System.out.println(s);

		System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(partitioningBy(Student7::isMale, counting()));
																				// 성별을 기준으로 나누고 카운팅. 

		System.out.println("남학생 수 :" + stuNumBySex.get(true));
		System.out.println("여학생 수 :" + stuNumBySex.get(false));

		System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
		Map<Boolean, Optional<Student7>> topScoreBySex = Stream.of(stuArr)
				.collect(partitioningBy(Student7::isMale, maxBy(comparingInt(Student7::getScore))));
															// maxBy는 항상 comparingInt 해서 기준?? 지정.
		System.out.println("남학생 1등 :" + topScoreBySex.get(true));
		System.out.println("여학생 1등 :" + topScoreBySex.get(false));

		Map<Boolean, Student7> topScoreBySex2 = Stream.of(stuArr).collect(partitioningBy(Student7::isMale,
				collectingAndThen(maxBy(comparingInt(Student7::getScore)), Optional::get)));
						// 수집 다 되면 옵셔널 객체에서? 스튜던트 객체만 뽑아서 꺼내올 수 있도록 
		System.out.println("남학생 1등 :" + topScoreBySex2.get(true));
		System.out.println("여학생 1등 :" + topScoreBySex2.get(false));

		System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

		Map<Boolean, Map<Boolean, List<Student7>>> failedStuBySex = Stream.of(stuArr)
				.collect(partitioningBy(Student7::isMale, partitioningBy(s -> s.getScore() <= 100)));
						// 성별로 나눈 다음 다시 파티셔닝. 총점이 100점이 안되면 true라는 키에 맵핑. 다시 false라는 키로 맵핑
		List<Student7> failedMaleStu = failedStuBySex.get(true).get(true);
		List<Student7> failedFemaleStu = failedStuBySex.get(false).get(true);

		for (Student7 s : failedMaleStu)
			System.out.println(s);
		for (Student7 s : failedFemaleStu)
			System.out.println(s);
	}
}
