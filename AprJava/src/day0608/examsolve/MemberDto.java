package day0608.examsolve;

public class MemberDto {

	String id;
	String password; 
	String name;
	String email;
	
	// 객체 생성자
	public MemberDto() {}
	public MemberDto(String password, String name, String email) {
		this(null, password, name, email);
		
	} 
	public MemberDto(String id, String password, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	} 
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	} // 사용되진 않았음
}
