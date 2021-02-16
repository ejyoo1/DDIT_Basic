package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
//	싱클톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만사용하는 디자인 패턴
//	클래스 내부에서 객체를 하나만 만들고 다른 클래스에서 필요하다고 하면 빌려주는 형태임.( 객체를 딱 한개만 생성한다 ! => 외부에서 객체를 못만들게 해야함. )
	
	//객체 생성은 딱 한개만 할 수 있도록 제한.(클래스 외부에서 이 클래스의 객체를 생성하지 못함. = 생성자를 호출할 수 없으므로)
	private JDBCUtil () {
		
	}
	
//	객체 생성은 클래스 내부에서 생성한다.
//	변수 생성 : 인스턴스를 보관할 변수
	private static JDBCUtil instance;
	
//	인스턴스를 빌려주는 메서드
//	이 메서드가 처음으로 호출하는 경우 객체를 생성하고 두번째 부터는 이미 생성된 객체를 반환함.
	public static JDBCUtil getInstance() {
		if(instance == null) {
			instance = new JDBCUtil();
		}
		return instance;
	}
	
	
//	JDBC 연결
	String url 	= "jdbc:oracle:thin:@localhost:1521:xe";
	String id	= "pc19";
	String pw	= "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
//	메서드 생성(ibatis, mybatis와 비슷한 구조 : jdbc를 편히 사용할 수 잇게 하는 메서드임.)
	/* selectOne : 한줄을 조회하는 메서드
	 * selectList : 여러줄을 조회하는 메서드
	 * update : insert, update, delete 시 사용하는 메서드
	 * (String sql) : 물음표가 없는 경우
	 * (String sql, List<Object> param) : 물음표가 있는 경우
	 * 
	 * Map<String, Object> selectOne(String sql){}
	 * Map<String, Object> selectOne(String sql, List<Object> param){}
	 * List<Map<String, Object>> selectList(String sql){}
	 * List<Map<String, Object>> selectList(String sql, List<Object> param){}
	 * int update(String sql){}
	 * int update(String sql, List<Object> param){}
	 * 
	 * */
//	한줄 쿼리
	Map<String, Object> selectOne(String sql){
		Map<String, Object> row = new HashMap<>();
		try {
//			DB연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리실행
			ps = con.prepareStatement (sql);
//			실행(select)
			rs = ps.executeQuery ();
//			resultSet에 무슨 데이터가 잇는지 모르기에 메타데이터를 얻고
			ResultSetMetaData metaData = rs.getMetaData ();
//			컬럼 수를 알면 데이터를 뽑을 수 잇음.
			int columnCount = metaData.getColumnCount ();
//			값을 추출
			if(rs.next()) {//true
				for(int i = 1 ; i <= columnCount ; i++) {
	//				추출한 내용을 HashMap<String, Object> 에 담아서 리턴함.
	//				해쉬맵에 put 해서 저장(키:컬럼명, 값:컬럼값)
	//				무엇을 가져왓는지 모르기에 getObject로 받음
					row.put (metaData.getColumnName (i), rs.getObject (i));
				}//close for
			}//close if
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}//close finally
		return row;		
	}
	
//	물음표가 없는 select
	List<Map<String, Object>> selectList(String sql){
		List<Map<String, Object>> list = new ArrayList<>();
		try {
//			DB 연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리 실행
			ps = con.prepareStatement (sql);
//			실행(select)
			rs = ps.executeQuery ();
//			resultSet에 무슨 데이터가 있는지 모르기에 메타데이터를 얻고
			ResultSetMetaData metaData = rs.getMetaData ();
//			컬럼 수를 알면 데이터를 뽑을 수 잇음.
			int columnCount = metaData.getColumnCount ();
//			값을 추출
			while(rs.next()) {
//				한줄한줄 가져온 행을 해쉬맵에 담아서(우리가 알고있는 맵이 해쉬맵뿐) list에 저장해야 하는 목적을 가진 hashmap을 생성함.
				HashMap<String, Object> row = new HashMap<>();
//				한줄 한줄을 해쉬맵에 담음.
				for(int i = 1 ; i <= columnCount ; i++) {
//					추출한 내용을 List<Map<String, Object>> list = new ArrayList<>();에 담아서 리턴하는 목적임.
//					한줄을 해쉬맵 형태로 만들어서 담아야함. 그래서 for문 돌리기 전에 hashmap을 만듬
//					해쉬맵에 put 해서 저장(키:컬럼명, 값:컬럼값)
//					무엇을 가져왔을 지 모르기에 getObject로 받음.
					row.put (metaData.getColumnName (i), rs.getObject (i));
				}//close for
//				arrList에 저장
				list.add (row);
			}//close while
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}//close finally
		
		return list;
	}
//	해야될것? 
//	DB 연결 -> 넘어온 쿼리 실행 -> 물음표가 있으니 list param에 있는것을 sql에 삽입 -> result 셋이 왓으면 값을 추출한 뒤 -> list<map>형식으로 만들어서 리턴을 함.
	List<Map<String, Object>> selectList(String sql, List<Object> param){
//		리턴타입에 맞는 객체 생성
		List<Map<String, Object>> list = new ArrayList<>();
		try {
//			DB 연결
			con = DriverManager.getConnection (url,id,pw);
//			쿼리 실행
			ps = con.prepareStatement (sql);
//			메서드 사용하여 값을 sql에 넘겨주어야 함.
//			list : 여러개 순서대로 이므로 for 문을 돌려서 넘겨줌
			for(int i = 0 ; i < param.size () ; i++) {
//				물음표 모두 세팅 완료. (list된 타입이 어떤 타입인지 모르고 제네릭이 <Object> 이므로 Object로 받은것임.
				ps.setObject ( i + 1 , param.get (i) );//물음표는 1부터 시작하므로 +1을 함.
			}
//			실행(select)			
			rs = ps.executeQuery ();//resultSet
//			resultSet에 무슨 데이터가 잇는지 모르기에 메타데이터를 얻고
			ResultSetMetaData metaData = rs.getMetaData ();
//			컬럼 수를 알면 데이터를 뽑을 수 있음.
			int columnCount = metaData.getColumnCount ();
//			값을 추출
			while(rs.next ()) {
//				한줄한줄 가져온 행을 해쉬맵에 담아서 list에 저장해야하는 목적을 가진 hashmap을 생성
				HashMap<String, Object> row = new HashMap<>();
				for(int i = 1 ; i <= columnCount ; i++) {
//					추출한 내용을 List<Map<String, Object>> list = new ArrayList<>(); 담아서 리턴해야됨.
//					한줄을 해쉬맵 형태로 만들어서 담아야함. 그래서 for문 돌리기전에 hashmap을 만듬
//					해쉬맵에 put해서 저장(키:컬럼명, 값:컬럼값)
					row.put (metaData.getColumnName (i), rs.getObject (i));
				}
				list.add (row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			객체 반환
			if( rs != null ) try { rs.close (); } catch(Exception e) {}
			if( ps != null ) try { ps.close (); } catch(Exception e) {}
			if( con != null ) try { con.close (); } catch(Exception e) {}
		}
		
		
		return list;
	}
	
}
