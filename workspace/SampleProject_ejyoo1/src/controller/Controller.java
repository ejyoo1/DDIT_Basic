package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtil;
import util.VerifiedUtil;
import util.View;

public class Controller {
	public static void main (String[] args) {
		/*
		 * 금 : 오후 발표(ppt 준비)
		 * 발표순서 : 조소개 > 주제 소개 > 주제 선정 이유 > 메뉴 구조 > 시연
		 * 	- 메뉴 구조 : 프로그램의 구조(어떤메뉴? 어떤흐름?)
		 *  - 발표 시간 : 15분 ~ 20분
		 * 발표인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 
		 * Controller : 화면 이동(페이지 화면 이동)
		 * Service : 화면 기능(페이지의 화면 기능)
		 * Dao(Data Access object) : 쿼리 작성(데이터 접근 클래스-쿼리 작성하고 JDBC 호출하고)
		 * 
		 * */
		
		
//		1. 컨트롤러 객체를 생성해서 start 메서드에 접근한다.
		new Controller().start();
	}
//	유저 로그인 정보를 저장할 전역변수 생성
	public static Map<String, Object> loginUser;
	
//	유저 서비스 객체 생성 (start에서 호출해야하기 때문에)
	private UserService userService = UserService.getInstance();
//	보드 서비스 객체 생성
	private BoardService boardService = BoardService.getInstance();
//	유효성 검사 서비스 객체 생성
	private VerifiedUtil verifiedUtil = VerifiedUtil.getInstance ();
//	2. 프로그램 시작 시 start()메서드가 시작된다.
	private void start () {
//		3. View.HOME 번호를 넣고 시작한다.
		int view = View.HOME;
		
//		4. 무한 반복문이 실행된다.
		while(true){
//			5. 스위치의 조건문으로 뷰 번호를 세팅한다.
			switch (view) {
//				화면이 실행이되면 화면 기능이 끝나고 난 뒤, 리턴은 view임 (어떤 화면으로 이동할 지 값을 받음)
//				받은다음 break;로 빠져나간뒤 와일문이 다시 돌아감.
//				6. 처음 start() 메서드를 실행할 때, home 번호를 넣었으므로 이 케이스가 실행된다.
				case View.HOME: view = home(); break;
//				27. 회원가입 후 로그인을 한다.
				case View.LOGIN: view = userService.login(); break;
//				12. 유저 서비스 클래스의 조인을 호출한 뒤 결과값을 저장함.
				case View.JOIN: view = userService.join(); break;
//				39. 보드 리스트 호출한다.
				case View.BOARD_LIST: view = boardService.boardList(); break;
			}
		}
	}
	
//	7. 처음 메뉴
	private int home() {
//		8. 사용자는 메뉴를 선택한다.
		System.out.println("--------------------------------------");
		System.out.println("1.로그인\t2.회원가입\t3.프로그램 종료");
		System.out.println("--------------------------------------");
		System.out.print("번호 입력>");
		
//		9. 수행할 행위를 번호로 입력을 받는다.
		int input = ScanUtil.nextInt();
		boolean flag = verifiedUtil.verifiedMenu (3, input);
		
		if(flag) {
	//		10. 사용자가 입력한 번호를 기준으로 뷰를 세팅한다.
			switch (input) {
				case 1: return View.LOGIN;
	//			11. start 메서드에게 회원가입 뷰 번호를 리턴한다.
				case 2: return View.JOIN;
				case 3:
					System.out.println("프로그램이 종료되었습니다.");
					System.exit(0);
			}
		}else {
			System.out.println ("잘못 입력하셨습니다.");
		}
		return View.HOME;
	}
	
}
