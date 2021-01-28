package d_array;

import java.util.ArrayList;



public class s {
	public static void main(String[] args){
		String s = "abcde";
		String answer = "";
		
		if(s.length()%2==0){//짝수이면 
			//가운데 두글자 반환
			answer = s.substring ( (s.length()/2)-1 , (s.length ()/2)+1) ; //1,3
		}else{
			answer = s.substring ( s.length()/2 , (s.length()/2)+1 ) ; //2,3
		}
	}
}
