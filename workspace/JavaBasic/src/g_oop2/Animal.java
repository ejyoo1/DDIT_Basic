package g_oop2;

public abstract class Animal {
	
	void run() {
		System.out.println ("달려간다~~~");
	}
	
	//동물이 내는 소리는 서로 다르기 때문에
	//동물 객체 생성 시 꼭 필요한 메서드이기 때문에 자식 클래스를 생성할 때 이것을 꼭 구현해야한다는 것을 알려주기 위함임.
	//꼭 구현하지 않아도 되면 개별 동물 객체에 메서드를 별도로 만들어도 좋다.
	abstract void sound();
}

class Dog extends Animal{
	@Override
	void sound () {//부모클래스의 추상메서드인 sound를 오버라이딩
			System.out.println ("멍멍!!");
	}
}

class Cat extends Animal{
	@Override
	void sound () {
		System.out.println ("야옹!!");
	}
}

class Mouse extends Animal{
	@Override
	void sound () {
		System.out.println ("찍찍!!");
	}
	
}
