package day0607.jdbc.dept;

public class MyOracleDriver {

	static {
		try {
			Class.forName("jdbc.oracle.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
