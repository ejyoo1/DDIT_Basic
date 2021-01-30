package e_oop;

import e_oop.ScanUtil;

public class Static {
	/*
	 * - static을 붙이면 프로그램 실행 시 메모리에 올라간다.
	 * - 객체 생성을 하지 않아도 사용할 수 있다.
	 * - static을 붙인 변수는 객체간에 변수의 값을 공유한다.
	 * - static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
	 * - static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 * 
	 * */
	//변수의 값을 공유하기 위해 static을 붙인다.
	static int var;
	int var2;
	
	public static void main(String[] args) {
		//뻘짓.... main 메서드 입장에서는 static이 선언되지 않은 Static 내 sc 객체를 사용한다고 하니 당연히 안되는것...
		new Static().var2 = 1;
		//static int var; <- 메서드 안에 붙일 수없음.(전역변수로만 사용가능)
		Human 철수 = new Human();
		Human 영희 = new Human();
		
		철수.saveMoney (100000);
		영희.saveMoney (200000);
		
		철수.saveDatemoney (200000);
		영희.saveDatemoney (200000);
		
		System.out.println ("문자열 입력>");
		String str = ScanUtil.nextLine();
		System.out.println ("입력받은 문자열: " + str);
		
		System.out.println ("숫자 입력>");
		int num = ScanUtil.nextInt ();
		System.out.println ("입력받은 숫자 : " + num);
	}
}

class Human{
	int account; //계좌, 통장
	
	void saveMoney(int money) {
		account += money;
		System.out.println ("통장잔고 : " + account);
	}
	
	static int dateAccount;
	
	void saveDatemoney(int money) {
		dateAccount += money;
		System.out.println ("데이트 통장 잔고 : " + dateAccount);
	}
}