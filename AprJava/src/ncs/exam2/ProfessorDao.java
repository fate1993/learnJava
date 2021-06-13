package ncs.exam2;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProfessorDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 새로운 교수가 임용되면 교수의 이름, 아이디, 포지션, 연봉, 임용날짜, 커미션, 부서번호를 받아와 DB에 삽입한다. 교수 번호는 시퀀스를 사용한다.

	public int insertProfessor(ConnectionPool cp, ProfessorDto dto) {
		int i = 0;
		try {
			con = cp.getConnection();
			
			pstmt = con.prepareStatement("insert into professor values(professor_seq.NEXTVAL,?,?,?,?,?,?,?)");
			pstmt.setString(1, dto.name);
			pstmt.setString(2, dto.userid);
			pstmt.setString(3, dto.position);
			pstmt.setInt(4, dto.sal);
			pstmt.setTimestamp(5, new Timestamp(dto.getHiredate().getTime()));
			pstmt.setInt(6, dto.comm);
			pstmt.setInt(7, dto.deptno);
			
			i = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ProfessorMain.close(null, con, pstmt);
		}
		return i;
	}
	
	public void raiseSal(ConnectionPool cp, double rate) throws IOException, SQLException{
		
			con = cp.getConnection();
			
			pstmt = con.prepareStatement("update professor set sal = sal + (sal * ?)");
			pstmt.setDouble(1, rate);
			pstmt.executeUpdate();
	}
	
	public int deleteProfessor(ConnectionPool cp, int profno, String name)  throws IOException, SQLException{
		int i = 0;
		
			con = cp.getConnection();
			pstmt = con.prepareStatement("delete from professor where profno = ? and name = ?");
			pstmt.setInt(1, profno);
			pstmt.setString(2, name);
			
			i = pstmt.executeUpdate();
		
		return i;
	}
}
