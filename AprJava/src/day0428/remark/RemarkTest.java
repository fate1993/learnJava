package day0428.remark;

// 주석
// : 한줄 주석
/* 여러줄 주석 */
// 주석 블록지정 >> ctrl + shift + /
// 주석 해제 블록지정 >> ctrl + shift + \
// 들여쓰기 알아서 >> ctrl + shift + F
public class RemarkTest {
	// 프로그램의 시작 : main 메서드
	public static void main(String[] args) {

		/*
		 * ln -> \n 줄바꿈 println() : 출력 후 줄바꿈 print() : 출력만 하고 끝남
		 */

		System.out.println("오늘은 두번째 날입니다."); // ln >> \n: 줄바꿈
		System.out.println("줄이 바뀌었나요??");
		System.out.println("------------");

		System.out.print("test1");
		System.out.print("test2");
		System.out.println("------------");
		System.out.print("test3\n");
		System.out.print("test4");

	} // 프로그램 끝

}
