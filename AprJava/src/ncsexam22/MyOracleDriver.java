package ncsexam22;

public class MyOracleDriver {
	static {
		try {
			Class.forName("jdbc.oracle.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
