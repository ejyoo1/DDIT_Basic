package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Finally {
	public static void main (String[] args) {
		/*
		 * finally
		 * - 필요에 따라 try - catch 뒤에 finally를 추가할 수있다.
		 * - finally는 예외의 발생 여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * 자동 자원 반환
		 * - try(변수선언;변수선언){} catch(Exceiption e) {}
		 * - 사용 후 반환이 필요한 객체를 try의 ()안에서 선언하면 try 블럭 종료시 자동으로 반환된다.
		 *  
		 * */
		
		FileInputStream fis = null; //파일 읽기
		try {
			fis = new FileInputStream("d:/file1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close ();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//자동 자원 반환(JDK1.7)
		try{//파일 만들기
			FileOutputStream fos = new FileOutputStream("d:/file1.txt");
			String str = "아무 내용이나 글을 적어봅니다...";
			
			//문자열을 바이트타입으로변경해줌
			byte[] bytes = str.getBytes();
			
			for(int i = 0 ; i < bytes.length; i++) {
				fos.write (bytes[i]);
			}
		}catch (Exception e) {
			e.printStackTrace ();
		}
				
	}
}
