package aa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private static MemberDAO mem = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return mem;
	}

	private Connection conn = getConnect();
	private Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "wodual", "0000");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("접속성공");
		return conn;
	}
	// SQL문
	String sql_INSERT = "INSERT INTO MEMBER (MNUM, USERID, USERPW, USERNAME) VALUES " + "(0, ?, ?, ?)";
	String sql_SELECT_ALL = "SELECT * FROM MEMBER";
	String sql_SELECT_ONE = "SELECT * FROM MEMBER WHERE USERID LIKE ? AND USERPW LIKE ?";
	String sql_UPDATE = "UPDATE MEMBER SET USERPW=?, USERNAME=? WHERE MNUM=?";
	String sql_DELETE = "DELETE FROM MEMBER WHERE MNUM=?";

	PreparedStatement pstmt = null;

//회원가입
	public int joinMem(MemberVO vo) {
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_INSERT);
			pstm.setString(1, vo.getUserID());
			pstm.setString(2, vo.getUserPW());
			pstm.setString(3, vo.getUserName());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

//회원전체목록 반환
	public ArrayList<MemberVO> selectMemList() {
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int mNum = rs.getInt("mNum");
				String userID = rs.getString("userID");
				String userPW = rs.getString("userPW");
				String userName = rs.getString("userName");
				MemberVO vo = new MemberVO(mNum, userID, userPW, userName);
				datas.add(vo);
			}
			rs.close();
			pstm.close();
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// [단일회원 반환]
	public MemberVO selectOneMem(MemberVO vo){
		MemberVO vo1 = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_SELECT_ONE);
			pstm.setString(1, vo.getUserID());
			pstm.setString(2, vo.getUserPW());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int mNum = rs.getInt("mNum");
				String userID = rs.getString("userID");
				String userPW = rs.getString("userPW");
				String userName = rs.getString("userName");
				vo1 = new MemberVO(mNum, userID, userPW, userName);
				
			}
			rs.close();
			pstm.close();
			return vo1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//회원정보수정
	public int updateMem(MemberVO vo) {
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_UPDATE);
			pstm.setString(1, vo.getUserPW());
			pstm.setString(2, vo.getUserName());
			pstm.setInt(3, vo.getMnum());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
//회원탈퇴
	public int deleteMem(int n) {
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_DELETE);
			pstm.setInt(1, n);
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		MemberDAO mem = MemberDAO.getInstance();
//		MemberVO vo = new MemberVO(1, "ww", "ㅇ", "wodual");
//		int test = mem.joinMem(vo);
//		System.out.println(test);
//		List<MemberVO> mm = mem.selectMemList();
//		for(MemberVO nn:mm) {
//			System.out.println(nn);
//		}
		
		int test = mem.deleteMem(2);
		System.out.println(test);
	}
}
