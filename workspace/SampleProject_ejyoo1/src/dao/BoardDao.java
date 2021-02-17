package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {
//	싱글톤 패턴 으로 제작
	
//	생성자 만듬(private)
	private BoardDao(){}
	
//	객체를 보관할 변수 생성
	private static BoardDao instance;
	
//	메서드 호출 시 객체 주소 부여 
	public static BoardDao getInstance(){
		if(instance == null){
			instance = new BoardDao();
		}
		return instance;
	}
	
//	다오이기 때문ㅇ ㅔ jdbc 가 필요함.
	private JDBCUtil jdbc = JDBCUtil.getInstance();
//	42. 게시판의 목록을 조회하는 메서드 생성
	public List<Map<String, Object>> selectBoardList(){
//		43. 쿼리 작성
		String sql = "select a.board_no, a.title, a.content, a.user_id, a.user_name, a.reg_date"
				+ " from tb_jdbc_board a"
				+ " left outer join tb_jdbc_user b"
				+ " on a.user_id = b.user_id"
				+ " order by a.board_no desc";
//		44. 조회한 결과를 리스트에 담아서 서비스에 보내준다.
		return jdbc.selectList(sql);
	}
}
