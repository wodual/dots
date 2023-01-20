package aa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private static ProductDAO product = new ProductDAO();

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		return product;
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
	String sql_INSERT = "INSERT INTO PRODUCT (PNUM, PNAME, PRICE, CNT) VALUES " + "(0, ?, ?, ?)";
	String sql_SELECT_ALL = "SELECT * FROM PRODUCT order by pnum desc";
	String sql_SELECT_ONE = "SELECT * FROM PRODUCT WHERE PNUM=?";
	String sql_UPDATE = "UPDATE PRODUCT SET PNAME=?, PRICE=?, CNT=? WHERE PNUM=?";
	String sql_DELETE = "DELETE FROM PRODUCT WHERE PNUM=?";

	PreparedStatement pstmt = null;

	// 상품추가
	public int addProduct(ProductVO vo) {
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_INSERT);
			pstm.setString(1, vo.getpName());
			pstm.setInt(2, vo.getPrice());
			pstm.setInt(3, vo.getCnt());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

//물품전체목록
	public ArrayList<ProductVO> selectProductList() {
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int pNum = rs.getInt("pNum");
				String pName = rs.getString("pName");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				ProductVO vo = new ProductVO(pNum, pName, price, cnt);
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

	// 단일상품조회
	public ProductVO seeProduct(ProductVO vo) {
		ProductVO data = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_SELECT_ONE);
			pstm.setInt(1, vo.getPnum());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int pNum = rs.getInt("pNum");
				String pName = rs.getString("pName");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				data = new ProductVO(pNum, pName, price, cnt);
			}
			rs.close();
			pstm.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 상품변경
	public int updateProduct(ProductVO vo) {
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_UPDATE);
			pstm.setString(1, vo.getpName());
			pstm.setInt(2, vo.getPrice());
			pstm.setInt(3, vo.getCnt());
			pstm.setInt(4, vo.getPnum());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// 상품삭제
	public int deleteProduct(ProductVO vo) {
		try {
			PreparedStatement pstm = conn.prepareStatement(sql_DELETE);
			pstm.setInt(1, vo.getPnum());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		ProductDAO qq = ProductDAO.getInstance();
//		ProductVO vo = new ProductVO(1, "ww", 33333, 3);
//		int test1 = qq.addProduct(vo);
//		System.out.println(test1);
		List<ProductVO> zz = qq.selectProductList();
		for (ProductVO aa : zz) {
			System.out.println(aa);

		}

	}
}
