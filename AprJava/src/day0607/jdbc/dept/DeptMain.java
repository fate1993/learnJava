package day0607.jdbc.dept;

public class DeptMain {

	public static void main(String[] args) {

		DeptService ds = new DeptService();
		//ds.selectOne();
		
		// ds.insertDept();
		ds.updateDept();
		ds.selectAll();
	}
}