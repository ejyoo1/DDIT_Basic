package a_variable;

import java.util.Scanner;

public class SignReport {
	public static void main(String[] args){
		final int SIGNLIST = 5;
		//과제 : 다음과 같은프로그램을 작성하시오.
		/* 입력 및 출력
		 * =====회원가입=====
		 * 아이디 > admin
		 * 비밀번호(4자리숫자)>1234
		 * 이름>홍길동
		 * 나이>99
		 * 키>185.5
		 * ===============
		 * 아이디:admin
		 * 비밀번호:1234
		 * 이름:홍길동
		 * 나이:99세
		 * 키:185.5cm
		 * ===============
		 */

		System.out.println("아이디, 비밀번호,이름, 나이, 키를 순서대로 입력하세요 - 구분은 엔터");
		//회원가입의 정보를 받을 스트링 배열 생성
		String[] signUserList = new String[SIGNLIST];
		//스캐너 클래스를 사용할 변수와 System.in이라는 매개변수를 삽입하여 Scanner(매개변수) 메소드 호출
		Scanner sc = new Scanner(System.in);
		
		//for문을 돌려 사용자 정보를 5회 입력받음
		for(int i=0;i<signUserList.length;i++){
			signUserList[i] = sc.nextLine();
		}
		
		//사용자 정보를출력
		System.out.printf("회원가입 정보입니다.=====\n"
				+ "아이디 : %s \n" + "비밀번호 : %d \n"
				+ "이름 : %s \n" + "나이 : %s 세 \n"
				+ "키 : %s cm\n",
				signUserList[0],
				Integer.parseInt(signUserList[1]),
				signUserList[2],
				signUserList[3],
				Double.parseDouble(signUserList[4]));
						
	}
}
