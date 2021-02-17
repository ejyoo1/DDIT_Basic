package util;


import java.util.Scanner;

public class ScanUtil {
	
	static Scanner s = new Scanner(System.in);
	
	public static String nextLine() {
		return s.nextLine();
		//return new ScanUtil.s.nextLine();
	}
	
	public static int nextInt() {
		return Integer.parseInt (new ScanUtil().s.nextLine ());
	}
	
}
