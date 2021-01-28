package d_array;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args){
	
	/*
	 * 정렬 
	 * - 석차구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
	 * - 선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
	 * - 버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
	 * - 삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로밀고 중간에 삽입하는 방식 작은 숫자를 만나면 비교하는 것을 끝내고 빈자리에 값을 넣음
	 * */
		
		
		
		int[] arr = new int[10];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		//System.out.println(Arrays.toString(arr));
		
		/* 
		//----석차 구하기 -----
		//등수를 저장할 배열 생성
		int[] rank = new int[arr.length];
		
		//등수는 1등부터 해야하기 때문에 1로 초기화
		for(int i = 0 ; i < rank.length ; i++){
			rank[i] = 1;
		}
		
		//등수 계산 시 내 등수만 비교하는 것이 아닌 모든 사람의 수를 비교해야함.
		for(int i = 0 ; i < arr.length ; i++){//i = 나
			for(int j = 0 ; j < arr.length ; j++){//j = 다른사람
				if(arr[i] < arr[j]){ //나보다 다른사람의 점수가 높으면
					rank[i]++; //나의 등수를 1씩 증가
				}
			}
		}
		
		//등수 출력
		System.out.println(Arrays.toString(rank));
		*/
		
		
		//선택정렬
		/*
		 * i,j
		 * 0,1 0,2 0,3 0,4 0,5 0,6 0,7 0,8 0,9
		 * 1,2 1,3 1,4 1,5 1,6 1,7 1,8 1,9
		 * 2,3 2,4 2,5 2,6 2,7 2,8 2,9
		 * 3,4 3,5 3,6 3,7 3,8 3,9 
		 * 4,5 4,6 4,7 4,8 4,9
		 * 5,6 5,7 5,8 5,9
		 * 6,7 6,8 6,9
		 * 7,8 7,9
		 * 8,9
		 * */
		/*
		System.out.println("변경전 : " + Arrays.toString(arr));
		
		for(int i = 0 ; i < arr.length-1; i++){//8보다 작을때까지
			int subKey = i;//최소값이 있는 위치를 알아야함.
			for(int j = i+1 ; j < arr.length ; j++){//9보다작을때까지
				if(arr[subKey] > arr[j]){ //비교 대상인것을 찾아야함.
					subKey = j; 
				}
			}
			int temp = arr[i];
			arr[i] = arr[subKey];
			arr[subKey] = temp;
			
		}
		System.out.println("변경후 : " + Arrays.toString(arr));
		*/
		
		
		
		//버블정렬
		/*      0   1   2   3   4   5   6   7   8
		 * 0 : 0,1 1,2 2,3 3,4 4,5 5,6 6,7 7,8 8,9
		 * 1 : 0,1 1,2 2,3 3,4 4,5 5,6 6,7 7,8 
		 * 2 : 0,1 1,2 2,3 3,4 4,5 5,6 6,7
		 * 3 : 0,1 1,2 2,3 3,4 4,5 5,6
		 * 4 : 0,1 1,2 2,3 3,4 4,5
		 * 5 : 0,1 1,2 2,3 3,4
		 * 6 : 0,1 1,2 2,3
		 * 7 : 0,1 1,2
		 * 8 : 0,1
		 */
		
		/*
		System.out.println("변경전 : " + Arrays.toString(arr));
		
		
		for(int i = 0 ; i < arr.length-1; i++){
			boolean flag = false;
			for(int j = 0 ; j < arr.length-i-1 ; j++){
				if(arr[j] > arr[j+1]){ //비교 대상인것을 찾아야함.
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			System.out.println((i+1)+"회변경");
			if(!flag){//flag == false;
				break;
			}
		}
		System.out.println("변경후 : " + Arrays.toString(arr));
		*/
		
		
		//삽입정렬
		for(int i = 1 ; i < arr.length; i++){
			int temp = arr[i];//arr[i]를 기본값으로 세팅
			int j = 0;
			
			for(j = i - 1 ; j >= 0 ; j--){//j는 i보다 -1 된 값부터 시작하고 0이 되기 전까지 1씩 감소한다.
				if(temp < arr[j]){ //j보다 작으면
					arr[j+1] = arr[j];//j의 인덱스를 저장한다.
				}else{//j보다 크면
					break;
				}
			}
			arr[j+1] = temp;	//그자리에 넣는다.
		}
		System.out.println(Arrays.toString(arr));
		
		
	}
}