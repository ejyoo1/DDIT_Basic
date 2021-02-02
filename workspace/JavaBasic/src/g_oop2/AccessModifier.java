package g_oop2;

public class AccessModifier {
	public String publicVar = "public : 접근 제한이 없음";
	protected String protectedVar = "protected : 같은 패키지 + 상속받은 클래스에서 접근 가능";
	String defaultVar = "default : 같은 패키지에서만 접근 가능";
	private String privateVar = "private : 클래스 내에서만 접근 가능";
	
	public void publicMethod() {
		System.out.println (publicVar);
	}
	
	protected void protectedMethod() {
		System.out.println (protectedVar);
	}
	
	void defaltMethod() {
		System.out.println (defaultVar);
	}
	
	private void privateMethod() {
		System.out.println (privateVar);
	}
	
	public static void main (String[] args) {
		AccessModifier am = new AccessModifier ();
		
		System.out.println (am.publicVar);
		am.publicMethod ();
		
		System.out.println (am.protectedVar);//같은 패키지
		am.protectedMethod ();
		
		System.out.println (am.defaultVar);
		am.defaltMethod ();
		
		System.out.println (am.privateVar);//클래스 내에서 사용가능
		am.privateMethod ();
		
		Time t = new Time();
		//t.hour = 14;
		//t.minute = 2;
		//이렇게 잘못 들어오는 것들에 대해서 제어가 되지 않음. -> 접근 제어자 필요함.
		//t.second = -15;
		
		//setter, getter를 통한 접근
		t.setHour (4);
		t.setMinute (-1);
		t.setSecond (-15);
		System.out.println (t.getTime ());
		
		
		/*
		 * 접근제어자를 사용하는 이유
		 * - 데이터를 보호하기 위해
		 * - 사용하는데 불필요한 멤버를 숨기기 위해
		 * */
		
		t.clock ();//초를 찍어줌
		//t.stop (interval); //출력할때 잠깐 멈춰주기 위한 메서드인데 클래스 입장에서는 멈출 이유가 없기에 클래스 사용에 혼란을 줄 수 잇음.
	}
}
