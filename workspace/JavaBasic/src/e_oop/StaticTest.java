package e_oop;

public class StaticTest {
	static int classVar; //클래스 변수
	int instanceVar; //인스턴스 변수
	
	
	public static void main(String[] args) {
		StaticTest su = new StaticTest();
		System.out.println (classVar);
		System.out.println (su.instanceVar);
	}
	
	void instanceMethod() {
		System.out.println (classVar);
		System.out.println (instanceVar);
	}
}
