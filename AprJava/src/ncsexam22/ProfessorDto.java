package ncsexam22;
import java.util.*;

public class ProfessorDto {
	
	private int profno;
	private String name;
	private String userid;
	private String position;
	private int sal;
	private Date hiredate;
	private int comm;
	private int deptno;
	
	public ProfessorDto(int profno, String name, String userid, String position, int sal, Date hiredate, int comm,
			int deptno) {
		super();
		this.profno = profno;
		this.name = name;
		this.userid = userid;
		this.position = position;
		this.sal = sal;
		this.hiredate = hiredate;
		this.comm = comm;
		this.deptno = deptno;
	}

	public ProfessorDto() {
	}

	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "ProfessorDto [profno=" + profno + ", name=" + name + ", userid=" + userid + ", position=" + position
				+ ", sal=" + sal + ", hiredate=" + hiredate + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
}
