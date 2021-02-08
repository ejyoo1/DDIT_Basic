package i_api;

import java.util.ArrayList;

public class Score {
	public static void main (String[] args) {
		String[] nameList = new String[]{"김민지","서주형","최윤성","변형균","김두환","현유진","김현슬","이광렬","박예진","강건우","명민호","박상영","이휘로","김현태","최영준","정영인","정유진","공슬기","김이현","전윤주","전재수","유은지"};
		String[] subjectList = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};	
		
//		과목삽입
		ArrayList<String> subjects = new ArrayList<>();
		for(int i = 0 ; i < subjectList.length ; i++) {
			subjects.add (subjectList[i]);
		}
//		이름삽입
		ArrayList<String> names = new ArrayList<>();
		for(int i = 0 ; i < nameList.length ; i++) {
			names.add (nameList[i]);
		}
		
//		점수삽입
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
//		합계 삽입
		ArrayList<Integer> sums = new ArrayList<>();
		for(int i = 0 ; i < names.size () ; i++) {
//			합계변수
			int sum = 0;
			ArrayList<Integer> score = new ArrayList<>();
			for(int j = 0 ; j < subjects.size() ; j++) {
				score.add ((int)(Math.random () * 101));
				sum += score.get (j);
			}			
			scores.add (score);
			sums.add (sum);
		}
		
//		평균 계산
		ArrayList<Double> avgs = new ArrayList<>();
		for(int i = 0 ; i < sums.size () ; i++) {
			avgs.add (Math.round(((double)sums.get (i)/ subjects.size())*10)/10.0);
		}
		
//		석차 구하기
		ArrayList<Integer> rank = new ArrayList<>();
//		석차 1등으로 초기화
		for(int i = 0 ; i < scores.size (); i++) {
			rank.add (1);
		}
//		석차 계산
		for(int i = 0 ; i < scores.size () ; i++) {
			int result = rank.get (i);
			for(int j = 0 ; j < scores.size () ; j++) {
				if(sums.get (i) < sums.get (j)) {
					result++;
				}
			}
			rank.set (i,result);
		}
		
		//석차순으로 정렬(시험에서 출제되지 않음)
		for(int i = 0; i < sums.size() - 1; i++){
			int min = i;
			for(int j = i + 1; j < sums.size(); j++){
				if(sums.get (j) > sums.get (min)){
					min = j;
				}
			}
			ArrayList<Integer> temp = scores.get (i);
			scores.set(i, scores.get (min));
			scores.set(min, temp);
			
			int temp2 = sums.get (i);
			sums.set(i, sums.get(min));
			sums.set(min, temp2);
			
			double temp3 = avgs.get(i);			
			avgs.set(i, avgs.get(min));
			avgs.set(min, temp3);
			
			int temp4 = rank.get(i);		
			rank.set(i, rank.get(min));
			rank.set(min, temp4);
			
			String temp5 = names.get(i);		
			names.set(i, names.get(min));
			names.set(min, temp5);
		}
		
//		과목합계, 과목평균
		ArrayList<Integer> subSum = new ArrayList<>();
		ArrayList<Double> subAvg = new ArrayList<>();
		for(int i = 0; i < subjects.size(); i++){
			int sum = 0;
			for(int j = 0; j < scores.size(); j++){
				sum += scores.get (j).get (i);
			}
			subSum.add (sum);
			subAvg.add (Math.round((double)subSum.get (i) / scores.size() * 100) / 100.0);
		}
		
		
		
		
		
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subjects.get (i));
		}
		
		System.out.println("\t합계\t평균\t석차");
		
//		점수출력
		for(int i = 0; i < scores.size(); i++){
			System.out.print(names.get(i) + "\t");
			for(int j = 0; j < subjects.size(); j++){
				System.out.print(scores.get (i).get (j) + "\t");
			}
//			합계,평균,석차 출력
			System.out.println(sums.get (i) + "\t" + avgs.get (i) + "\t" + rank.get (i));
		}
		
		System.out.print("과목합계\t");
		for(int i = 0; i < subSum.size(); i++){
			System.out.print(subSum.get (i) + "\t");
		}
		System.out.println();
		
		System.out.print("과목평균\t");
		for(int i = 0; i < subAvg.size(); i++){
			System.out.print(subAvg.get (i) + "\t");
		}
	}
}
