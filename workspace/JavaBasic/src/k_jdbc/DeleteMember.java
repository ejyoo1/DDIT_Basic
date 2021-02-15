package k_jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteMember extends JDBCConnection {
	public static void main (String[] args) {
		try {
//			db 연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리작성
			String sql = "DELETE FROM MEMBER WHERE MEM_ID = 'EJYOO11'";
//			쿼리실행
			ps = con.prepareStatement (sql);
//			쿼리결과 삽입
			int result = ps.executeUpdate ();
			System.out.println (result + "개 행이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
//			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}
	}
}
