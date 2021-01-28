package e_oop;

import java.util.Arrays;

public class Boss {
	public static void main (String[] args) {
		Alba ab = new Alba();//new Alba() 인스턴스를 생성하여 인스턴스의 주소를 객체에 저장
		
		String[] order = ab.order ();
		System.out.println(Arrays.toString (order));
		
		System.out.println ("요리 만드는 중..... 완성!!");
		String[] foods = {"완성된 짜장면", "완성된 탕수육"};
		
		ab.sub (foods);
		
		ab.pay (order);
	}
}
