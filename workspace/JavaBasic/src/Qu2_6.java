
public class Qu2_6 {
	public static void main(String[] args){
		int number = 30;
		char ch = 'C';
		
		int result = number++ + 3 + ++ch + ++number;
		System.out.println(result);
		System.out.println(30+3+68+32);
	}
}