package ncsexam22;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class ProfessorDao {

	// 교수 추가(insert)
	public int insertProfessor(ProfessorDto dto) {
		int x = 0;
		PreparedStatement pstmt = null;
		
		Connection con = GetConnection.getConnection();
		try {
			pstmt = con.prepareStatement("insert into professor values(professor_seq.NEXTVAL,?,?,?,?,?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getPosition());
			pstmt.setDouble(4, dto.getSal());
			pstmt.setTimestamp(5, new Timestamp(dto.getHiredate().getTime()));
			pstmt.setInt(6, dto.getComm());
			pstmt.setInt(7, dto.getDeptno());
			
			x = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	// 교수 연봉 인상(update)
	public void raiseSal(double rate) {
		Connection con = GetConnection.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update professor set sal = sal + (sal * ?)");
			pstmt.setDouble(1, rate);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 교수 삭제(delete)
	public int deleteProfessor(ProfessorDto dto) {
		int x = 0;
		PreparedStatement pstmt = null;
		
		Connection con = GetConnection.getConnection();
		
		try {
			pstmt = con.prepareStatement("delete from professor where profno = ?");
			pstmt.setInt(1, dto.getProfno());
			
			x = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	// 단일 교수 정보 조회(select)
	public ProfessorDto selectOneProfessor(int profno) {
		Connection con = GetConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProfessorDto dto = null;
		
		try {
			pstmt = con.prepareStatement("select * from professor where profno = ?");
			pstmt.setInt(1, profno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new ProfessorDto();
				dto.setProfno(rs.getInt("profno"));
				dto.setName(rs.getString("name"));
				dto.setUserid(rs.getString("userid"));
				dto.setPosition(rs.getString("position"));
				dto.setSal(rs.getInt("sal"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
			}
			
			GetConnection.Closed(rs, pstmt);
			GetConnection.closed(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 모든 교수 정보 조회(select)
	public List<ProfessorDto> selectAllProfessor() {
		List<ProfessorDto> list = new ArrayList<>();
		
		Connection con = GetConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProfessorDto dto = null;
		
		try {
			pstmt = con.prepareStatement("select * from professor");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new ProfessorDto();
				dto.setProfno(rs.getInt("profno"));
				dto.setName(rs.getString("name"));
				dto.setUserid(rs.getString("userid"));
				dto.setPosition(rs.getString("position"));
				dto.setSal(rs.getInt("sal"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				
				list.add(dto);
			}
			
			GetConnection.Closed(rs, pstmt);
			GetConnection.closed(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
















