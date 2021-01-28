package d_array;

import java.util.Arrays;

public class Quiz {
	public static void main(String[] args){
		/*
		int money = (int)(Math.random() * 500) * 10;
		int[] coin = {500, 100, 50, 10};
		int[] change = new int[4];
		
		System.out.println("거스름돈 : " + money);
		
		
		 //거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요
		 //거스름돈 : 2860원
		 //500원 : 5개
		 //100원 : 3개
		 //50원 : 1개
		 //10원 : 1개
		 
		
		/*
		for(int i = 0; i<coin.length;i++){
			change[i] = money / coin[i];
			money %= coin[i];
		}
		
		System.out.printf(Arrays.toString(change));
		*/
		
		
		
		
		/*
		int[] arr = new int[20];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		//1~5의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요
		// 1: *** 3
		// 2: **** 4
		// 3: ** 2
		// 4: ***** 5
		// 5: * 1
		
		int[] count = new int[5];
		for(int i = 0 ; i < arr.length ; i++){
			count[arr[i]-1]++;
		}
		
		for(int i = 0; i < count.length;i++){
			System.out.print((i+1)+" : ");
			for(int j = 0; j < count[i] ;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		
		
		
		int[] arr = new int[10];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		// 1~5 사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		int[] temp = new int[5];
		int index = 0;
		for(int i = 0 ; i < arr.length; i++){
			boolean flag= false;
			for(int j = 0 ; j < temp.length; j++){
				if(arr[i] == temp[j]){
					flag = true;
				}
			}
			//같은게 없을 때만 삽입
			if(flag == false){
				temp[index++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		
		int[] result = new int[index];
		for(int i = 0 ; i< result.length;i++){
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));
	}
}
