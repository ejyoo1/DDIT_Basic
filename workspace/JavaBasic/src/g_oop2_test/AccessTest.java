package g_oop2_test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier{
	public static void main (String[] args) {
		AccessModifier am = new AccessModifier ();
		
		System.out.println (am.publicVar);
		am.publicMethod ();
		
		//상속은 받았지만 이렇게 사용할 수 없음. AccessModifier의 변수,메서드에 접근하는 것임.
		//따라서 상속 받은 후 자식 객체를 통하여 접근하여야 함.
		//System.out.println (am.protectedVar);
		//am.protectedMethod ();
		
		AccessTest at = new AccessTest();
		System.out.println (at.protectedVar);
		at.protectedMethod ();
		
		//같은 패키지가 아니라 상속받아도 사용할 수 없음.
		//System.out.println (am.defaultVar);
		//am.defaltMethod ();
		//System.out.println (at.defaultVar);
		//at.defaltMethod ();
		
		//사용불가
		//System.out.println (am.privateVar);
		//am.privateVar;
	}
}
