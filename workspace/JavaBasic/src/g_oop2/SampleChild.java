package g_oop2;

public class SampleChild extends SampleParent{
	
	void childMethod() {
		System.out.println (var);
		System.out.println (method(1, 2));
	}
	
	
	
	//오버라이딩
	//super, super() : 부모와 자식 변수를 구분하기 위해 사용
	//다형성 : 타입은 부모클래스인데 실제 객체는 자식클래스임.(타입과 객체가다른것)
	
	//오버라이딩 ; 상속받은 메서드의 내용을 재정의 하는것.
	
	@Override //어노테이션 : 클래스, 변수, 메서드 등에 표시해놓는것.(재정의가 잘못된 경우 사용자에게 알려줌.)
	int method(int a, int b) {//리턴타입 메서드명 파라미터 모두같아야 한다.
		return a*b;		
	}
	
	//super,super()
	//super : 부모클래스의 멤버와 자식클래스의 멤버가 이름이 중복될 때 둘을 구분하기 위해 사용한다.
	int var;
	void test(double var) {
		System.out.println (var);//지역변수
		System.out.println (this.var);//SimpleChild에 잇는 인스턴스 변수
		System.out.println (super.var);//SimpleParent에 잇는 변수
		
		System.out.println (this.method (10, 20));
		System.out.println (super.method (10, 20));	
	}
	
	SampleChild(){
		super();//부모클래스의 생성자 호출 
		//super()를 통해 클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
		//super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
		//변수를 사용하려면 부모 클래스의 변수가 초기화 상태여야 사용할 수 있으므로 super()가 필요함.
	}
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
		//SampleParent sp = new SampleChild2();
		//SampleParent sp = new SampleChild3();
		//부모타입의 변수로 자식타입의 객체를 사용하는 것이 다형성이다.
		
		//부모와 자식간에는 서로 형변환이 가능하다.
		//작은거에서 큰타입으로 형변환은 데이터 손실 염려가 없지만 큰타입에서 작은거로 형변환 시 데이터 손실이 있을 수 있음(이개념과 좀 비슷)
		sc = (SampleChild)sp;
		sp = (SampleParent)sc; //sp = sc;
		//자식타입 -> 부모타입 형변환은 생략할 수 있다.
		
		//형변환을 생략 못하는 이유가 문제가 생성될 수 있기 때문에 발생하는 것임.
		SampleChild sc2 = (SampleChild)new SampleParent();
		//SampleParent는 2개의 멤버를 가지고있다. var, method
		//SampleChild는 5개의 멤버를 가지고 잇다. childMethod, var, test, 부모멤버변수 2개
		//SampleChild는 5개의 멤버를 사용할 수 잇어야하는데, SampleParent는 2개임.
		//5개를 사용해야되는데 실제로는 2개밖에 사용 못하니까 형변환을 명시해줘야하는것임.
		//5개를 사용해야되는데 2개밖에 사용 못하니까 문제가 될수있어 명시적으로 형변환을 입력해주어야함.
		//부모 타입의 객체를 자식 타입으로 형변환 하는 것은 에러를 발생시키는 것이다.
		//자바에서는 부모 타입의 객체를 자식 타입으로 형변환 하는 것을 원칙적으로 금지한다.
		//컴파일 에러는 발생하지 않지만, 실행함ㄴ 오류가 발생한다.
		
		//SampleParent 타입의 변수로는
		//SampleChild 객체를 가지고도 2개의 멤버만 사용할 수 잇다.
		//sp = (SampleParent)sc;
		System.out.println (sp.var);
		System.out.println (sp.method (10, 20));
		//sp.childMethod(); // 사용불가
		//sp.test(); //사용불가
		//자식 객체를 부모 객체에 넣어서 사용하므로 부모 객체에 대한 멤버만 사용할 수 있다.
	}
	
}
