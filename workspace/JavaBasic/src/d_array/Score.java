package d_array;

import java.util.Arrays;

public class Score {
	public static void main(String[] args){
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, oracle, java 점수를
		 * 0~100까지 랜덤으로 생성해주고, 아래와 같이 출력한다.
		 * 
		 *     국어     영어     수학    사회     과학     Oracle     Java     합계     평균
		 *홍길동  90    .                                          90.00
		 * 
		 * 과목합계 450 560
		 * 과목평균 90.00
		 */
		
		final int SUBJECT = 8;
		String[] names = new String[]{"김민지","서주형","최윤성","변형균","김두환","현유진","김현슬","이광렬","박예진","강건우","명민호","박상영","이휘로","김현태","최영준","정영인","정유진","공슬기","김이현","전윤주","전재수","유은지"};
		String[][] scores = new String[names.length][SUBJECT];//int[학생수][과목수]
		
		int[] sum = new int[scores.length];//합계
		double[] avg = new double[scores.length];//평균
		int[] rank = new int[scores.length];//석차
		
		int[] totalSum = new int[SUBJECT];
		double[] totalAvg = new double[SUBJECT];
		
		
		//랜덤으로 점수 삽입
		for(int i = 0 ; i < scores.length; i++){
			for(int j = 0; j < 8 ; j++){
				if(j==0){
					scores[i][0] = names[i];
				}else{
					scores[i][j] = Integer.toString((int)(Math.random() * 101));
					sum[i] += Integer.parseInt(scores[i][j]);
					totalSum[j] += Integer.parseInt(scores[i][j]);
				}
			}
			avg[i] = Math.round(((double)sum[i]/scores[i].length)*10)/10.0;
		}
		for(int i = 0 ; i < totalSum.length; i++){
			totalAvg[i] = Math.round(((double)totalSum[i]/scores.length)*10)/10.0;
		}
		
		//석차 모두 1등으로 초기화
		for(int i = 0 ; i < scores.length; i++){
			rank[i] = 1;
		}
		
		//석차 구하기
		for(int i = 0 ; i < scores.length; i++){
			for(int j = 1 ; j < scores.length; j++){
				if(avg[i] < avg[j]){
					rank[i]++;
				}
			}
		}
		
		//출력
		System.out.println("이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
		
		for(int i = 0 ; i < scores.length; i++){
			for(int j = 0; j < scores[i].length ; j++){
				System.out.print(scores[i][j]+"\t");
				
			}
			System.out.print(sum[i]+"\t");
			System.out.print(avg[i]+"\t");
			System.out.print(rank[i]+"\t");
			System.out.println();
		}
		System.out.print("과목합계 \t");
		for(int i = 1 ; i < totalSum.length ; i++){
			System.out.print(totalSum[i]+"\t");
		}
		
		System.out.println();
		
		System.out.print("과목평균 \t");
		for(int i = 1 ; i < totalAvg.length ; i++){
			System.out.print(totalAvg[i]+"\t");
		}
		
	}
}
