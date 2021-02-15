package k_jdbc;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SelectMember extends JDBCConnection {
	public static void main (String[] args) {
		try {
//			db 연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리작성
			String sql = "select * from member";
//			쿼리실행
			ps = con.prepareStatement (sql);
//			쿼리결과 삽입
			rs = ps.executeQuery ();
			
//			쿼리 컬럼 객체 가져오기
			ResultSetMetaData md = rs.getMetaData ();
			
//			컬럼 개수 조회
			int columnCount = md.getColumnCount ();
			
			for(int i = 1 ; i <= columnCount ; i++) {//컬럼 수 만큼 찍기
//				컬럼 이름 출력
				System.out.print (md.getColumnName(i) + "\t\t");
			}
			System.out.println ();
			
//			컬럼 출력
			while(rs.next()) {//다음에 행이 존재하는가?
				for(int i = 1 ; i <= columnCount ; i++) {//컬럼 수 만큼 찍기
//					타입에 상관없이 결과값 가져오기
					Object value = rs.getObject (i);
					System.out.print (value + "\t\t");
				}
				System.out.println ();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}
	}
}
