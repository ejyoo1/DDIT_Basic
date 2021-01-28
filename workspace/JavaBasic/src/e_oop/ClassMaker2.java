package e_oop;

public class ClassMaker2 {
	//인스턴스 변수 하나를 선언하고 명시적으로 초기화 해주세요.
	int instanceVar = 10;
	
	//위에서 선언한 인스턴스 변수를 초기화 블럭을 사용해 초기화 해주세요.
	{
		instanceVar = 20;
	}
	
	//위에서 선언한 instanceVar 인스턴스 변수를 생성자의 파라미터를 사용해 초기화 해주세요
	ClassMaker2(int instanceVar){
		this.instanceVar = instanceVar;
	}
	
	//위에서 선언한 인스턴스 변수를 생성자를 하나 더 만들어서 초기화 해주세요
	ClassMaker2(){
		instanceVar=40;
	}
	
	//초기화 순서 : 명시적 초기화 -> 초기화 블럭 -> 생성자
	//최종적으로 생성자를 값으로 가지게됨.
	
	public static void main (String[] args) {
		ClassMaker2 cm = new ClassMaker2();
		System.out.println (cm.instanceVar);
		
		System.out.println (new ClassMaker2(30).instanceVar);
		
		//생성자를 통하여 출력을 했기 때문에 명시적초기화, 초기화 블럭에 잇는 값은 출력할 수 없다.
		//출력하고자 하는 경우 명시적 초기화 하는 시점에 System.out.println을 출력해야 한다.
	}
}
