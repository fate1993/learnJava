package day0607.jdbc.dept;
// DTO 데이터 저장하고 사용 >> private 접근자로 캡슐화
public class DeptDto {
	
	private int deptno;
	private String dname;
	private String loc;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	@Override
	public String toString() {
		return "DeptDto [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
}
