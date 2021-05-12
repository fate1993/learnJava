package day0511.exception;
//회원의 정보를 저장하는 클래스 - 캡슐화 적용
public class Member {

	//저장된 회원의 정보가 없어서
	//id와 password가 같은 값을 가지고 있다면 로그인 성공으로 인정
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}