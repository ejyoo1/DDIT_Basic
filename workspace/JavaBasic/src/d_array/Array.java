package d_array;

import java.util.Arrays;

public class Array {
	public static void main(String[] args){
		/*
		 * 배열
		 * - 여러개의 값을 하나로 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다.
		 */
		
		int[] array; //배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5];//배열이 생성되고 그 주소가 저장된다.
		//배열 초기화 시 기본값이 저장된다.
		
		/*
		 * 기본값 : 내가 저장하지 않았을 때 저장되는 값
		 * byte, short, int, long : 0
		 * float, double : 0.0
		 * char : ' '(0)
		 * boolean : false
		 * 참조형 : null
		 */
		
		/*
		 * 변수 = 주소
		 * 주소{0, 0, 0, 0, 0}
		 */
		
		array = new int[]{1, 2, 3, 4, 5};
		//array = {1, 2, 3, 4, 5};//선언과 초기화를 동시에 해야한다. 현재 작성된 문장은 오류가 남.
		int[] array2 = {1, 2, 3, 4, 5};
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		for(int i = 0; i< array.length; i++){
			System.out.println(array[i]);
		}
		
		for(int i = 0; i < array.length; i++){
			array[i] = (i+1)*10;
			System.out.println(array[i]);
		}
		
		//10개의 정수를 저장할 수 잇는 배열을 선언 및 초기화 해주세요.
		int[] arrayInt = new int[10];
		
		//배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요
		//(int) (Math.random() * 9) + 1;
		for(int i = 0; i < arrayInt.length; i++){
			arrayInt[i] = (int)(Math.random() * 100) + 1;//0~99+1
		}
		System.out.println(Arrays.toString(arrayInt));//모든 배열의 값을 문자열로 변경해주는 메서드
		
		//배열에 저장된 모든 값의 합게화 평균을 구해주세요
		//내가 무엇을 만들고자 하면 그것에 대한 변수를 만들고 시작
		int sum = 0;
		double avg = 0.0;
		for(int i = 0; i < arrayInt.length; i++){
			sum += arrayInt[i];
		}
		//int int = int 이므로 둘중 하나는 double로 캐스팅
		avg = sum/(double)arrayInt.length;
		System.out.println("SUM : "+sum);
		System.out.println("AVERAGE : " + Math.round(avg*10)/10.0);
		
		//배열에 저장된 값 중 최소값과 최대값을 출력해주세요
		//변수 2개 생성, 0번 인덱스에 잇는 값을 초기화
		int max = arrayInt[0];
		int min = arrayInt[0];
		for(int i = 1; i < arrayInt.length; i++){
			if(max<arrayInt[i]){
			}else if(min>arrayInt[i]){
				min = arrayInt[i];
			}
		}
		System.out.println("MAX : "+max+" MIN : "+min);
		
		//--------------------------------------------------------------------------------
		
		//섞자 0부터 사이에 랜덤 숫자 발생 -> 인덱스로 사용
		//랜덤으로나온 인덱스의 자리를 변경 -> 여러번반복하면 배열이 섞일것이다.
		int[] shuffle = new int[10];
		for(int i = 0; i < shuffle.length; i++){
			shuffle[i] = i + 1;
		}
		
		System.out.println("변경 전 :"+ Arrays.toString(shuffle));
		//100회 반복
			for(int i = 0; i < 100; i++){
				int shuffleIndex = (int)(Math.random() * 10);//0~9
				System.out.println("뽑은 숫자 : " + shuffleIndex);
				
				int temp = shuffle[0];
				shuffle[0] = shuffle[shuffleIndex];
				shuffle[shuffleIndex] = temp;
				
			}
		System.out.println("변경 후 :"+ Arrays.toString(shuffle));
		
		//----------------------------------------------------------------------------------
		
		//1~10 사이의 랜덤값 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요
		/*
		//방법1. result 변수에 값을 증가
		int[] randomCount = new int[500];
		//int[] count = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] result = new int[10];
		//랜덤함수 500 출력
		for(int i = 0; i < randomCount.length; i++){
			randomCount[i] = (int)(Math.random() * 10)+1;
			result[randomCount[i]-1]++;
		}
		*/
		
	
		
		/*
		//500개의 배열과 숫자 비교할 배열에 따라 결과 카운트 증가
		//방법2** 뽑은 배열과 비교할 배열에 따라 결과 배열에 카운트 증가
		for(int i = 0; i < randomCount.length; i++){
			for(int j = 0; j < count.length; j++){
				if(randomCount[i]==count[j]){
					result[j]++;
				}
			}
		}
		*/
		
		//방법3** 뽑자마자 결과 배열에 카운트 증가
		int[] result = new int[10];
		for(int i = 0; i < 500; i++){
			result[((int)(Math.random() * 10)+1)-1]++;//1~10
			/*
			 //방법 4** 변수로 받음
			  int random = (int)(Math.random()*10)+1;
			  count[random - 1]++;
			*/
		}
		
		//결과출력
		System.out.println(Arrays.toString(result));
		/*for(int i = 0; i < result.length; i++){
			System.out.println(i+"개수 : "+result[i]);
		}*/
		
		//----------------------------------------------------------------------------------------
	}
}
