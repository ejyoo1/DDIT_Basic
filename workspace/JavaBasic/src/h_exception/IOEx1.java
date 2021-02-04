package h_exception;

import java.io.*;
import java.util.Arrays;

public class IOEx1 {
	public static void main (String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];//이전 예제와 배열의 크기가 다르다.
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println ("Input Source : " + Arrays.toString (inSrc));
		
		try {
			while(input.available () > 0) {//스트림으로부터 읽어올 수 있는 데이터 크기 반환
				int len = input.read(temp); //읽어온 데이터의 개수를 반환한다.
				output.write (temp, 0, len);//읽어온 만큼만 write한다.
//				System.out.println ("temp : " + Arrays.toString (temp));
				
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}
		}catch (IOException e) {}
	}
	
	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println ("temp : " + Arrays.toString (temp));
		System.out.println("Output Source : " + Arrays.toString (outSrc));
	}
}
