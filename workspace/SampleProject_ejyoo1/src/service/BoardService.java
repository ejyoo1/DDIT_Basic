package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
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
		System.out.println("번호\t제목\t아이디\t이름\t작성일");
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
//		58. 게시글 조회 메서드 호출
		case 1:	
			readBoard(); 
			if(Controller.loginUser==null) {
				return View.HOME;
			}else {
				break;
			}
//		47. 게시글 등록 메서드 호출
		case 2: createBoard(); break;
//		92. 로그아웃
		case 0: userLogout(); break;
		}
		
//		목록으로 돌아오도록
		return View.BOARD_LIST;
	}
	public void userLogout () {
		System.out.println (Controller.loginUser.get ("USER_ID")+"님 로그아웃 되었습니다.");
		Controller.loginUser = null;
		System.out.println("=========== 사용자 로그아웃 완료 =============");
	}
	//	59. 게시글 조회 메서드
	public int readBoard () {
		System.out.println("=========== 게시글 조회 =============");
//		60. 사용자에게 조회할 게시글 번호를 입력받음
		System.out.print ("조회할 게시글 번호 입력>");
		int board_no = ScanUtil.nextInt ();
		
//		61. 게시글 번호를 해쉬맵에 데이터를 담음.
		Map<String, Object> param = new HashMap<>();
		param.put ("BOARD_NO", board_no);
		
//		62. DB에 접근할 BoardDao에 게시글 번호를 파라미터로 담아 호출한다.
//		67. BoardDao에서 게시글 번호에 해당하는 게시글을 가져와 저장한다.
		Map<String, Object> board = boardDao.selectBoard(param);
//		68. 게시글 내용 출력
		System.out.println ("번호 : " + board.get ("BOARD_NO"));
		System.out.println ("제목 : " + board.get ("TITLE"));
		System.out.println ("내용 : " + board.get ("CONTENT"));
		System.out.println ("아이디 : " + board.get ("USER_ID"));
		System.out.println ("이름 : " + board.get ("USER_NAME"));
		System.out.println ("작성시간 : " + board.get ("REG_DATE"));
//		69. 이 게시글을 사용하여 사용자가 어떤 행위를 할지 결정한다.
		System.out.println("=======================================");
		System.out.println("1.수정\t2.삭제\t0.로그아웃");
		System.out.print("입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
//			70. 수정할 게시글 번호를 담은 수정 메서드 호출
			case 1: updateBoard(board_no); break;
//			81. 게시글 삭제할 번호를 담은 삭제 메서드 호출
			case 2: deleteBoard(board_no); break;
			case 0: userLogout(); break;
		}
		
//		조회나 삭제가 끝나면 목록으로 돌아오도록
		return View.BOARD_LIST;
	}
//	82. 게시글 삭제 메서드
	public int deleteBoard (int board_no) {
		System.out.println("=========== 게시글 삭제 =============");
//		83. 게시글 번호를 HashMap에 담음
		Map<String, Object> param = new HashMap<>();
		param.put ("BOARD_NO", board_no);
//		84. 데이터베이스를 수행할 boardDao에 게시글 업데이트 메서드 호출
//		89. delete 문을 수행한 결과를 int 변수에 저장한다.
		int result = boardDao.deleteBoard(param);
//		90. 결과 유효성 검사.
		if(0 < result) {
			System.out.println ("게시글 삭제 성공");
		}else {
			System.out.println ("게시글 삭제 실패");
		}
//		91. 게시글 삭제 성공 실패 시 게시글 목록을 출력함.
		return View.BOARD_LIST;
	}
	//	71. 게시글 수정 메서드
	public int updateBoard (int board_no) {
		System.out.println("=========== 게시글 수정 =============");
		System.out.println("1.제목수정\t2.내용수정\t3.제목+내용수정");
		System.out.print("입력>");
		int input = ScanUtil.nextInt();
//		72. 게시글 번호, 제목, 내용을HashMap에 담음
		Map<String, Object> param = new HashMap<>();
		param.put ("BOARD_NO", board_no);
//		73.수정할 행위 선택한 후 행위에 따라 map에 담음
		switch(input) {
			case 1:
				System.out.print("게시글 제목>");
				String title = ScanUtil.nextLine ();
				param.put ("TITLE", title);	
				break;
			case 2: 
				System.out.print("게시글 내용>");
				String content = ScanUtil.nextLine ();
				param.put ("CONTENT", content);	
				break;
			case 3:
				System.out.print ("게시글 제목>");
				title = ScanUtil.nextLine ();
				System.out.print ("게시글 내용>");
				content = ScanUtil.nextLine ();
				param.put ("TITLE", title);	
				param.put ("CONTENT", content);	
		}
//		74. 데이터베이스를 수행할 boardDao에 게시글 업데이트 메서드 호출
//		78. 업데이트 문을 수행한 결과를 int 변수에 저장한다.
		int result = boardDao.updateBoard(param,input);
		
//		79. 결과 유효성 검사.
		if(0 < result) {
			System.out.println ("게시글 수정 성공");
		}else {
			System.out.println ("게시글 수정 실패");
		}
//		80. 게시글 수정 성공 실패 시 게시글 목록을 출력함.
		return View.BOARD_LIST;
	}
	//	48. 게시글 등록 메서드
	public int createBoard() {
		System.out.println("=========== 게시글 등록 =============");
		System.out.print ("게시글 제목 >");
		String title = ScanUtil.nextLine ();
		System.out.print ("게시글 내용 >");
		String content = ScanUtil.nextLine ();
//		49. 해쉬맵에 입력한 데이터를 담음.
		Map<String, Object> param = new HashMap<>();
		param.put ("TITLE", title);
		param.put ("CONTENT", content);
//		50. 데이터 베이스를 수행할 boardDao 에 게시글 등록메서드 호출
//		55. 데이터베이스에 게시글 등록을 완료한 결과값을 가져옴
		int result = boardDao.insertBoard(param);
		
//		56.결과 유효성 검사.
		if(0 < result) {
			System.out.println ("게시글 등록 성공");
		}else {
			System.out.println ("게시글 등록 실패");
		}
		
//		57. 게시글 생성 완료 또는 실패 시 게시글 목록을 출력함.
		return View.BOARD_LIST;
	}
}
