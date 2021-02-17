package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
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
		String sql = " SELECT A.BOARD_NO, A.TITLE, A.CONTENT, A.USER_ID, A.USER_NAME, A.REG_DATE"
				+ " FROM TB_JDBC_BOARD A"
				+ " LEFT OUTER JOIN TB_JDBC_USER B"
				+ " ON A.USER_ID = B.USER_ID"
				+ " ORDER BY A.BOARD_NO DESC";
//		44. 조회한 결과를 리스트에 담아서 서비스에 보내준다.
		return jdbc.selectList(sql);
	}
//	51. 게시글 등록 메서드
	public int insertBoard (Map<String, Object> param) {
//		52. JDBCUtil에 넘겨줄 쿼리를 작성한다.
		String sql = " INSERT INTO TB_JDBC_BOARD(BOARD_NO,TITLE,CONTENT,USER_ID,REG_DATE,USER_NAME)\r\n"
				+ "VALUES(BOARD_NO_SEQ.NEXTVAL,?,?,?,SYSDATE,?)";
//		53. 쿼리에 물음표가 있으므로 물음표 값을 담을 ArrayList를 생성함.
		List<Object> p = new ArrayList<>();
		p.add (param.get ("TITLE"));
		p.add (param.get ("CONTENT"));
		p.add (Controller.loginUser.get ("USER_ID"));
		p.add (Controller.loginUser.get ("USER_NAME"));
//		54. jdbc 접근하여 데이터 insert 후 결과 값을 boardService로 리턴
		return jdbc.update (sql, p);
	}
//	63. 한개의 게시글을 조회
	public Map<String, Object> selectBoard (Map<String, Object> param) {
//		64. JDBCUtil에 넘겨줄 쿼리를 작성한다.
		String sql = " select * from tb_jdbc_board where board_no=?";
//		65. 쿼리에 물음표가 잇으므로 물음표 값을 담을 ArrayList를 생성한다.
		List<Object> p = new ArrayList<>();
		p.add (param.get ("BOARD_NO"));
//		66. jdbc 접근하여 데이터 조회 후 결과값을 boardService로 리턴
		return jdbc.selectOne(sql, p);
	}
//	75. 게시글 업데이트
	public int updateBoard (Map<String, Object> param, int input) {
//		76. 사용자가 수정한 행위 별로 sql과 list 처리
		String sql = "";
		List<Object> p = new ArrayList<>();
		if(input==1) {
			sql = " UPDATE TB_JDBC_BOARD SET TITLE = ? WHERE BOARD_NO = ?";
			p.add (param.get("TITLE"));
		}else if(input==2) {
			sql = " UPDATE TB_JDBC_BOARD SET CONTENT = ? WHERE BOARD_NO = ?";
			p.add (param.get ("CONTENT"));
		}else if(input==3) {
			sql = " UPDATE TB_JDBC_BOARD SET TITLE = ?,CONTENT = ? WHERE BOARD_NO = ?";
			p.add (param.get("TITLE"));
			p.add (param.get ("CONTENT"));
		}
		p.add (param.get ("BOARD_NO"));
//		77. jdbc 접근하여 데이터 update 후 결과 값을 boardService로 리턴
		return jdbc.update (sql, p);
	}
//	85. 게시글 삭제
	public int deleteBoard (Map<String, Object> param) {
//		86.JDBCUtil에 넘겨줄 쿼리를 작성한다.
		String sql = " DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
//		87. 쿼리에 물음표가 있으므로 물음표 값을 담을 ArrayList를 생성한다.
		List<Object> p = new ArrayList<>();
		p.add (param.get ("BOARD_NO"));
//		88. jdbc 접근하여 데이터 조회 후 결과값을 boardService로 리턴
		return jdbc.update (sql, p);
	}
	
}
