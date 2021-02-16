package k_jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtilTest {
	public static void main (String[] args) {
//		객체를 가져옴
		JDBCUtil jdbc = JDBCUtil.getInstance ();
		
//		날리고 싶은 쿼리를 작성함.(파라미터 1)
		String sql = "select * from cart "
				+ "where cart_member = ?";
		
//		물음표에 있는 경우 물음표에 들어갈 값을 list에 담음(파라미터 2)
//		list를 사용한 이유는 list가 다른 상속받은 클래스들 (Vector, ArrayList, LinkedList 등)을 확장성 높게 사용하기 위함(다형성)
		List<Object> param = new ArrayList<>();
		param.add ("a001");
		
//		메서드 호출 => result : 결과가 담겨져 있는 리스트를 뿌려줌 'List<Map<String, Object>>
		List<Map<String, Object>> list = jdbc.selectList (sql, param); 
		System.out.println (list);
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		
		
//		날리고 싶은 쿼리를 작성함(파라미터1)
		sql = "select * from cart";
//		물음표가 없는 쿼리이므로 메서드 호출 => result : 결과가 담겨져 있는 리스트를 뿌려줌 'List<Map<String, Object>>'
		list = jdbc.selectList (sql);
		System.out.println (list);
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		
		
		sql = "select * from member where mem_name = '미역은대'";
		Map<String, Object> map = jdbc.selectOne (sql);
		System.out.println (map.get ("MEM_ID"));//대소문자 구별함. 꼭 컬럼명과 동일하게 쓸것
		System.out.println (map.get ("MEM_NAME"));
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		
		sql = " select * from member where mem_name = ? ";
		param = new ArrayList<>();
		param.add ("이쁜이");
		map = jdbc.selectOne (sql,param);
		System.out.println (map.get ("MEM_ID"));//대소문자 구별함. 꼭 컬럼명과 동일하게 쓸것
		System.out.println (map.get ("MEM_NAME"));
		System.out.println ("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	
		
		
		sql = "INSERT INTO TB_JDBC_BOARD(BOARD_NO,TITLE,CONTENT,USER_ID,REG_DATE)\r\n"
				+ "VALUES(BOARD_NO_SEQ.NEXTVAL,'db제목1','db제목2','ejyoo',sysdate)";
		int result = jdbc.update (sql);
		if(result > 0) {
			System.out.println (result + "개 행에 영향을 주었습니다.");
		}else {
			System.out.println ("영향을 준 행이 없습니다.");
		}
		
		sql = "INSERT INTO TB_JDBC_BOARD(BOARD_NO,TITLE,CONTENT,USER_ID,REG_DATE)\r\n"
				+ "VALUES(BOARD_NO_SEQ.NEXTVAL,?,?,?,sysdate)";
		param = new ArrayList<>();
		param.add ("하이");
		param.add ("안녕");
		param.add ("ejyoo");
		result = jdbc.update (sql,param);
		if(result > 0) {
			System.out.println (result + "개 행에 영향을 주었습니다.");
		}else {
			System.out.println ("영향을 준 행이 없습니다.");
		}
	}
}
