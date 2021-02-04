package h_exception;

import java.io.IOException;

public class ThrowException {
	public static void main (String[] args) {
		/*
		 * 예외 발생시키기
		 * -throw new Exception();
		 * -throw 예약어와 예외 클래스의 객체로 예외를 고의로 발생시킬 수 있다.
		 * */
		try{
			IOException ioe = new IOException("고의로 발생시켰음");
			throw ioe;
		}catch (IOException e) {
			e.printStackTrace ();
		}
		
		/*
		 * 메서드에 예외 선언하기
		 * - 메서드 호출 시 발생할 수 있는 예외를 선언해줄 수 있다.
		 * - void method() throws IOException{}
		 * - 메서드의 구현부 끝에 throws 예약어와 예외 클래스명으로 예외를 선언할 수 있다.
		 * - 예외를 선언하면 예외처리를 하지 않고 자신을 호출한 메서드로 예외처리를 넘겨준다.
		 * */
		
		try {
			method();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void method() throws IOException {
		throw new IOException("고의로 발생시켰음");
	}
}
