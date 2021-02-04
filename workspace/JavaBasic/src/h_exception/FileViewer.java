package h_exception;

import java.io.FileInputStream;

public class FileViewer {
	public static void main (String[] args) {
			try {
				FileInputStream fis = new FileInputStream(args[0]);
				int data = 0;
				
				while((data=fis.read()) != -1) {
					char c = (char)data;
					System.out.println (c);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
