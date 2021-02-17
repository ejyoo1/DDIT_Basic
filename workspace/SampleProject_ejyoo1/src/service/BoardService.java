package service;

import java.util.List;
import java.util.Map;

import dao.BoardDao;
import util.ScanUtil;
import util.View;

public class BoardService {
//	BoardService는 UserService, UserDao 의 유저와 관련되어 있지 않으므로 별도의 서비스를 생성함
	
//	생성자 만듬(private)
	private BoardService(){}
	
//	객체를 보관할 변수 생성
	private static BoardService instance;
	
//	메서드 호출 시 객체 주소 부여 
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
//	40. 목록을 출력하는 메서드 생성
	public int boardList(){
//		게시판에 데이터가 필요하므로 Db에 접속을 해야됨
//		db 접속은 DAO에서 해야되므로, DAO 패키지에 클래스를 하나 더 만듬.
//		board Dao를 전역변수로 생성한 뒤그것을 가져와서 호출
		
//		41. 게시판을 출력하기 위해서 보드 다오를 호출하여 데이터를 가져온다.
//		45. 호출하여 가져온 데이터를 보드리스트에 담은뒤
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
//		출력한다.
		System.out.println("=======================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("---------------------------------------");
		for(Map<String, Object> board : boardList){
			System.out.print (board.get("BOARD_NO") + "\t");
			System.out.print (board.get("TITLE") + "\t");
			System.out.print (board.get("USER_ID") + "\t");
			System.out.print (board.get("USER_NAME") + "\t");
			System.out.print (board.get("REG_DATE") + "\t");
			System.out.println ();
		}
//		46.게시물을 가지고 사용자가 어떤 행위를 할지 결정한다.
		System.out.println("=======================================");
		System.out.println("1.조회\t2.등록\t0.로그아웃");
		System.out.print("입력>");
		
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			
			break;
		}
		
//		목록으로 돌아오도록
		return View.BOARD_LIST;
	}
}
