package e_oop.score;

public class ClassMaker {
	//전역변수 하나를 선언 및 초기화 해주세요
	int test1 = 10;
	
	//리턴타입과 파라미터가 없는 메서드를 하나 만들어주세요.
	//메서드 안에서전역변수를 출력해주세요
	void methodTest() {
		System.out.println ("methodTest : " + test1);
	}
	
	//전역변수와 동일한 타입의 리턴타입이 잇고 파라미터가 없는 메서드를 하나만들어주세요.
	//메서드 안에서 전역변수를 리턴해주세요
	int methodTest2() {
		return test1;
	}
	
	//리턴 타입은 없고 파라미터가 있는 메서드를 하나 만들어주세요
	//메서드 안에서 파라미터를 출력해주세요.
	void mathodTest3(int test1) {
		System.out.println ("mathodTest3 : " + test1);
	}
	
	//int 타입의 리턴타입과 int 타입의 파라미터 두개가 잇는 메서드를 하나 만들어주세요
	//메서드 안에서 두 파라미터를 곱한 결과를 리턴해주세요
	int mothodTest4(int test1, int test2) {
		//return 메서드 종료, 값을 보내주는 2가지 역할을 함.
		return test1*test2;
	}
	
	
	
	
	
	public static void main (String[] args) {
		ClassMaker cm = new ClassMaker ();
		
		cm.methodTest ();
		
		int mtTest2 = cm.methodTest2 ();
		System.out.println ("mathodTest2 : " + mtTest2);
		
		cm.mathodTest3 (100);
		
		int mtTest4 = cm.mothodTest4(2,6);
		System.out.println ("mathodTest4 : " + mtTest4);
	}
}
