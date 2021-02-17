package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class UserDao {
//	싱글톤 패턴 으로 제작
//	UserService와 dao는 싱글톤 패턴으로 만드는 것이 좋음
	
//	생성자 만듬(private)
	private UserDao(){}
	
//	객체를 보관할 변수 생성
	private static UserDao instance;
	
//	메서드 호출 시 객체 주소 부여 
	public static UserDao getInstance(){
		if(instance == null){
			instance = new UserDao();
		}
		return instance;
	}
	
//	1. 전역변수로 jdbc 객체 생성함
//	모든 메서드 안에서 사용할 수 있도록 생성
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
//	17. 유저 테이블에 인서트를 하는 메서드 제작
	public int insertUser(Map<String, Object> param){
//		18. JDBCUtil 에 넘겨줄 쿼리작성한다.
		String sql = "insert into tb_jdbc_user values (?,?,?)";
//		19. 쿼리에 물음표가 있으므로, 물음표가 있는 값을 넘겨주기 위해 ArrayList를 생성함.
		List<Object> p = new ArrayList<>();
//		20. 물음표에 들어갈 데이터를 넣음
		p.add(param.get("USER_ID"));
		p.add(param.get("PASSWORD"));
		p.add(param.get("USER_NAME"));
//		쿼리 실행할 준비 완료.
//		21.jdbc 호출하여 결과를 가져온다.(sql과 list 변수인 p를 담아서)
		return jdbc.update(sql, p);//22.UserService로 돌아감.
	}

//	31. 유저를 조회하는 메서드
	public Map<String, Object> selectUser(String userId, String password) {
//		32.유저를 조회하는 쿼리 작성
		String sql = "select * from tb_jdbc_user where user_id = ? and password = ?";
//		33.물음표에 들어갈 값(userId와 password를 넣는다.) arrayList에 담아야함.
		List<Object> param = new ArrayList<>();
		param.add(userId);
		param.add(password);
		
//		34.sql과 param을 넣어 쿼리를 조회한다.
		return jdbc.selectOne(sql, param);
	}
}
