package day0608.exam2;

import java.sql.*;

public class BookDao {
	public void insertBook(Book b) {
		Connection con = GetConnection.getScottConnection();
		String sql = "insert into book values(?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getBookName());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());

			pstmt.executeUpdate();

			GetConnection.closed(pstmt);
			GetConnection.closed(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
