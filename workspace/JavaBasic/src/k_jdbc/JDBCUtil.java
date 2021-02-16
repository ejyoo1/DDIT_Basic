package k_jdbc;

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
	
}
