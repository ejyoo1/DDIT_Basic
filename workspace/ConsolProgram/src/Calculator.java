/*
 * 콘솔 입력을 통해서 사칙연산 및  % 연산을 누적해서 계산 할 수 있도록 만든 간단한 프로그램
 * 
 *  작동 원리 :
 *  계산식을 입력하면 입력한 계산식에서 연산자를 찾는다.
 *  이때 연산자가 존재하지 않을 경우 다시 계산식을 입력받는다.
 *  계산식을 입력햇을 때 오류가 나는 경우(4가지)
 *  1. 연산자를 찾을 수 없는 경우
 *  2. 계산식에 실수가 포함되는 경우
 *  3. 계산식에 공백이 포함되는 경우
 *  4. byZero(0으로 나누기)가 되는 경우
 *  연산자를 찾은 후 해당 연산을 실행한 뒤 누적 계산 또는 새로운 계산을 실행함.
 */

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		
		//연산자 선언
		String[] Oper = {"+", "-", "*", "/", "%"};
		
		
		//사용자에게 입력을 받기위한 변수
		String input = null;
		//
		int oper = 5;
		int accum = 0;
		long num1 = 0l;
		long num2 = 0l;
		double sum = 0;
		
		Loop:while(true){//
			switch(accum){//0: , 1:
			case 0 : //
				System.out.println("계산할 두 숫자를 연산자와 함께 입력하세요. (ex : 14+2)");
				break;
			case 1 : //
				System.out.println("누적 계산할 숫자를 단항식으로 입력하세요. (ex : *3)");
				break;
			}
			//사용(이 라인을 Loop:while 밖에 쓰면 오류가 남. 원인모름)
			input = sc.nextLine();
			
			//계산식을 저장할 배열 생성 (사용자 입력만큼 )
			String[] save = new String[input.length()];
			
			//사용자가 입력한 문장을 계산식 배열에 한글자씩 분리하여 저장
			for(int q = 0; q<input.length(); q++){
				save[q] = input.substring(q, q+1);
			}
		}	
	}
}
