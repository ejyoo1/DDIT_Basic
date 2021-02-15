package k_jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertMember extends JDBCConnection {
	public static void main (String[] args) {
		try {
//			db 연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리작성
			String sql = "INSERT INTO MEMBER(MEM_ID,MEM_PASS,MEM_NAME,MEM_REGNO1,MEM_REGNO2,MEM_ZIP,MEM_ADD1,MEM_ADD2,MEM_HOMETEL,MEM_COMTEL,MEM_MAIL)\r\n"
					+ "VALUES('EJYOO11','JAVA','유은지','1111','2222','000000','주소1','주소2','042-000-0000','070-0000-0000','EMAIL')";
//			쿼리실행
			ps = con.prepareStatement (sql);
//			쿼리결과 삽입
			int result = ps.executeUpdate ();
			System.out.println (result + "개 행이 삽입되었습니다.");
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
