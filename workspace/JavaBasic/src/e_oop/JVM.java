package e_oop;

public class JVM {
	public static void main (String[] args) {
		/*
		 * JVM(Java Virtual Machine)
		 * - 자바로 만들어진 프로그램이 실행되는 컴퓨터 안의 가상 컴퓨터
		 * - 운영체제 -> JVM -> 자바 프로그램
		 * - 장점: 운영체제에 상관없이 실행할 수  있다.
		 * - 단점 : 속도가 느리다.
		 * 
		 * JVM 메모리 구조
		 * - Method Area(메서드 영역) : 클래스 멤버가 저장된다.
		 * - Call Stack(호출 스택) : 현재 호출되어 있는 메서드가 저장된다.
		 * - Heap : 객체가 저장된다.
		 * 
		 */
		
		/*
		 * Method Area : main(), classVar, classMethod(), System.out 메모리에 올라옴 
		 * Heap : JVM{instanceVar, instanceMethod()}
		 * Call Stack : main(), {println()호출되고 종료되면 삭제됨}, {classMethod() 호출되고 {println()호출되고 종료되면 삭제됨}종료되면 삭제됨}, {main(){jvm = new JVM() 하여 주소를 가지고 있엇음.}객체가 생성됨}
		 *             ,{println()호출되고 종료되면 삭제됨}, {instanceMethod()호출되고 {println()왓다가}{println()}종료되면 삭제됨},{main(){jvm = null}} jvm의 주소를 null로 변경됨
		 * 
		 * */
		// heap이라는 곳에 JVM 객체는 있지만, jvm에 null을 넣음으로써 아무도 참조하지 않게 되었다. 아무도 사용할 수 없는 상태이므로 GarbageCollector에 의해 제거됨.
		// GarbegeCollector가 메모리를 돌아다니면서 참조하지 않는 객체를 삭제함.
		// GarbegeCollector라는 것에 의해서 Heap에서도 지움.
		// GarbegeCollector라는 것에 의해서 Heap에 있는 JVM을 지우고 Call stack에서 작업이 모두 완료되면 프로그램이 종료되면서 Method Area에서도 없어짐
		
		System.out.println (classVar);
		
		classMethod();
		
		JVM jvm = new JVM();
		
		System.out.println (jvm.instanceVar);
		
		jvm.instanceMethod();
		
		jvm = null;
	}
	
	int instanceVar;
	static int classVar;
	
	void instanceMethod() {
		System.out.println (instanceVar);
		System.out.println (classVar);
	}
	
	static void classMethod() {
		//System.out.println (instanceVar);아직 메모리에 올라가지 않은 상태
		System.out.println (classVar);
	}
}
