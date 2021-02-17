package service;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import dao.UserDao;
import util.ScanUtil;
import util.View;

public class UserService {
//	UserService와 dao는 싱글톤 패턴으로 만드는 것이 좋음
	
//	생성자 만듬(private)
	private UserService(){}
	
//	객체를 보관할 변수 생성
	private static UserService instance;
	
//	메서드 호출 시 객체 주소 부여 
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}
		return instance;
	}
	
//	2. 서비스 전역변수를 만듬
	private UserDao userDao = UserDao.getInstance();
	
//	13. 회원 가입을 진행
	public int join(){
//		14. 사용자에게 입력을 받음
		System.out.println("=========== 회원가입 =============");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		System.out.print("이름>");
		String userName = ScanUtil.nextLine();
		
//		**회원가입시 반드시 들어가야하는 과정**
//		아이디 중복확인 생략
//		비밀번호 확인 생략
//		정규표현식(유효성 검사) 생략
		
//		15. 해쉬 맵에 사용자에게 입력받은 유저 아이디, 비밀번호, 이름 입력
		Map<String, Object> param = new HashMap<>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", userName);
		
//		16. 디비 연결을 하는 유저다오 사용자가 입력한 해쉬맵을(유저아이디, 비밀번호, 이름) 넣어서 호출한 뒤 몇개의 행에 영향을 받았는지의 결과를 저장한다.
//		23. 받아온 결과값을 가지고
		int result = userDao.insertUser(param);
		
//		24. 회원가입 결과 유효성 검사를 한다.
//		25. 영향 받은 행이 잇다면, 회원가입성공 메시지가 출력되고 그것이 아니면 실패 메시지가 생성된다.
		if(0 < result){
			System.out.println("회원가입 성공");
		}else{
			System.out.println("회원가입 실패");
		}
//		26. 회원가입이 완료되면 메인화면으로 이동된다.
		return View.HOME;
	}

//	28. 로그인 메서드
	public int login() {
		System.out.println("========== 로그인 =============");
//		29. 사용자에게 아이디, 비밀번호 입력받음
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		
//		30. 데이터베이스에 사용자가 입력한 아이디, 비밀번호를 일치하는 회원을 찾기위해 
//		데이터 베이스와 연결되는 유저 다오에 조회하기 위한 값을 넣고 호출한다.
		
//		userDao에 접속하여 유저를 검색 결과를 맵 형태로 받을것임.
//		35. dao 에서 데이터 베이스 접근하여 데이터를 리턴한 뒤 가져온 값을 저장한 뒤.
		Map<String, Object> user = userDao.selectUser(userId, password);
		
//		36. 로그인 유효성 검사를한다. 갖고온 데이터가 없으면 홈화면이고, 정상적인 데이터면 로그인 된 유저의 정보를 가지고있는다.
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else{
			System.out.println("로그인 성공");
//			로그인 ? id,pw 입력해서 들어간 사람을 기억해야 함. '이사람이 누구다'
//			가져온 사용자 정보를 어딘가에 보관하고 있어야 함.
//			컨트롤러에 변수를 만들어서 사용자의 아이디, 비밀번호를 보관할것임.
//			37. 로그인 성공 시 변수에 조회한 user를 저장한다.
			Controller.loginUser = user;
//			38. 로그인이 완료되면 게시판 목록 뷰 번호를 리턴한다.
			return View.BOARD_LIST;
		}
//		id나 비밀번호를 잘못 입력하는 경우 홈화면으로 이동한다.
		return View.HOME;
	}//close login
}
