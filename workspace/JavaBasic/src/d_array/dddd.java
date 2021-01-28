package d_array;

public class dddd {
	public static void main(String[] args){
		int[] arr = new int[10];
		for(int i = 0; i<arr.length;i++){
			arr[i] = (int)(Math.random()*100)+1;
		}
		for(int i = 0;i<arr.length;i++){
			int temp = arr[i];
			int j = 0;
			
			for(j = i-1;j>=0;j--){
				if(temp < arr[j]){
					arr[j+1] = arr[j];
				}else{
					break;
				}
			}
			arr[j+1] = temp;
		}
	}
}
