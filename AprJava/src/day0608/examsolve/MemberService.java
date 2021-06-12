package day0608.examsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
// 콘솔창에 입력한 값을 읽어오고 그것을 dao에 보내서 sql문 실행할 수 있도록 함
public class MemberService {
	MemberDao dao = new MemberDao(); // dao 객체 생성

	public void createMember(ConnectionPool cp) {
		dao.createMember(cp); // connection을 사용하는 dao 객체로 메서드 호출
	}

	public void insertMember(ConnectionPool cp, String id) {

		MemberDto dto = new MemberDto(); // id 검사에 통과한 상태로 옴
		System.out.println("해당 아이디는 사용할 수 있습니다.");
		dto.setId(id);
		dto.setPassword(consoleInput("password"));
		dto.setName(consoleInput("name"));
		dto.setEmail(consoleInput("email"));
		// 콘솔에 입력된 값들을 dto 객체에 저장

		int i = dao.insertMember(cp, dto);
		// 안에 있는 데이터를 모두 꺼내서 insert

		if (i == 0) {
			System.out.println("입력 실패");
		} else {
			System.out.println("입력 성공");
		}
	} // 명령 끝나면 main으로 돌아감

	public String confirmId(ConnectionPool cp) {
		String id = consoleInput("id");
		int x = dao.confirmId(cp, id); 
		if (x != -1) { // -1 or 1
			id = null;
			System.out.println("해당 아이디는 사용할 수  없습니다.");
		}
		return id; // main에 id 값을 보냄
	}

	public void loginMember(ConnectionPool cp) throws IOException, SQLException {

		String id = consoleInput("id");
		String password = consoleInput("password");
		dao.loginMember(cp, id, password);
	}

	public void updateName(ConnectionPool cp) throws IOException, SQLException {
		String id = consoleInput("id");
		String name = consoleInput("name");
		int i = dao.updateName(cp, id, name);

		if (i != 0) {
			System.out.println("이름 변경");
		} else {
			System.out.println("해당 id 없음");
		}
	}

	public void selectPwd(ConnectionPool cp) throws IOException, SQLException {
		String id = consoleInput("id");
		String name = consoleInput("name");

		dao.selectPwd(cp, id, name);
	}

	public void deleteMember(ConnectionPool cp) throws IOException, SQLException {

		String id = consoleInput("id");
		String password = consoleInput("password");

		int i = dao.deleteMember(cp, id, password);

		if (i != 0) {
			System.out.println("회원 탈퇴");
		} else {
			System.out.println("탈퇴 실패");
		}
	}

	// 화면에 입력한 값을 가져오는 메서드. 이 클래스에서만 쓸거니까 private으로 만듬
	private String consoleInput(String input) {
		BufferedReader br = null; // BufferedReader 사용하기 위해 객체 선언
		String message = null; 
		try {
			System.out.print(input + " : "); // 콘솔창에 id / password : 라고 보여지도록 출력
			InputStreamReader isr = new InputStreamReader(System.in);
			// InputStreamReader 사용해서 입력 값 받고 1byte를 2byte로 늘리고(한글 깨지지 않음) isr에 저장
			br = new BufferedReader(isr); 
			// 연결된 스트림을 BufferedReader로 연결.그래야 한줄씩 읽을 수 있음 
			message = br.readLine(); // BufferedReader의 readLine으로 읽고 저장한 값 message에 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message; // 받아온 message 반환. 사용자가 입력한 id값 얻음
	}
}
