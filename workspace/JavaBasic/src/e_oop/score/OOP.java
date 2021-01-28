package e_oop.score;

public class OOP {

	public static void main (String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는 것이 아니라 객체간의 상호작용으로 보는 것.
		 * -코드의 재사용성이 높고 유지보수가 용이하다.
		 * */
		
		//방금 만든 클래스의 객체를 생성하고 변수에 저장해주세요.
		//객체가 저장된 변수를 통해 메서드를 호출해주세요.
		//파라미터가 잇는 메서드는 타입에 맞는 값을 넘겨주시고,
		//리턴타입이 있는 메서드를 리턴받은 값을 출력해주세요.
		SampleClass sc = new SampleClass();
		
		System.out.println (sc.field);
		
		sc.mathod1 ();
		String returnValue = sc.method2 (10);
		System.out.println (returnValue);
		
		sc.flowTest1 ();
		
		//다음 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번 결과값 * 123456
		//3. 2번 결과값 / 123456
		//4. 3번 결과값 - 654321
		//5. 4번 결과값 % 123456
		Calculator cal = new Calculator();
		
		double result = cal.add(123456,654321);
		System.out.println ("1. 123456 + 654321 : " + result);
		
		result = cal.mul (result, 123456);
		System.out.println ("2. 1번 결과 * 123456 : " + result);
		
		result = cal.div (result, 123456);
		System.out.println ("3. 2번 결과 / 123456 : " + result);
		
		result = cal.sub (result, 654321);
		System.out.println ("4. 3번 결과 - 654321 : " + result);
		
		result = cal.mod (result, 123456);
		System.out.println ("5. 4번 결과 % 123456 : " + result);
		
	}

}
