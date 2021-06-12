package day0604;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesEx {

	public static void main(String[] args) {

		String driver = null;
		String url = null;
		String user = null;
		String password = null;

		Properties prop = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\daumu\\Desktop\\JDBC-20210604T003436Z-001\\JDBC\\db.properties");
			prop = new Properties(); // 프로퍼티스 객체에 저장할 수 있도록

			prop.load(fis); // load >> 파일 정보 읽어와서 prop 객체에 저장

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("username");
			password = prop.getProperty("password");
			// 변수 꺼냄

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, user, password);
			// 저장된 정보로 커넥션 연결

			pstmt = con.prepareStatement("select ename from emp");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("사원 이름 : " + rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle) {
			}
		}

	}

}
