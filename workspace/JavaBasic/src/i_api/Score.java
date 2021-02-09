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
		ArrayList<String> students = new ArrayList<>();
		for(int i = 0 ; i < nameList.length ; i++) {
			students.add (nameList[i]);
		}
		
//		점수삽입
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
		for(int i = 0; i < students.size(); i++){
			ArrayList<Integer> score = new ArrayList<>();
			for(int j = 0; j < subjects.size(); j++){
				score.add((int)(Math.random() * 101));
			}
			scores.add(score);
		}
		
//		합계,평균 계산
		ArrayList<Integer> sums = new ArrayList<>();
		ArrayList<Double> avgs = new ArrayList<>();
		for(int i = 0; i < scores.size(); i++){
			int sum = 0;
			for(int j = 0; j < scores.get(i).size(); j++){
				sum += scores.get(i).get(j);
			}
			sums.add(sum);
			avgs.add(Math.round((double)sum / subjects.size() * 100) / 100.0);
		}
		
//		석차 구하기
		ArrayList<Integer> ranks = new ArrayList<>();
		for(int i = 0; i < sums.size(); i++){
			ranks.add(1);
			for(int j = 0; j < sums.size(); j++){
				if(sums.get(i) < sums.get(j)){
					ranks.set(i, ranks.get(i) + 1);
				}
			}
		}
		
		//석차순으로 정렬(시험에서 출제되지 않음)
		for(int i = 0; i < sums.size() - 1; i++){
			int min = i;
			for(int j = i + 1; j < sums.size(); j++){
				if(sums.get (j) > sums.get (min)){
					min = j;
				}
			}
//			점수정렬
			ArrayList<Integer> temp = scores.get (i);
			scores.set(i, scores.get (min));
			scores.set(min, temp);
			
//			합계정렬
			int temp2 = sums.get (i);
			sums.set(i, sums.get(min));
			sums.set(min, temp2);
			
//			평균정렬
			double temp3 = avgs.get(i);			
			avgs.set(i, avgs.get(min));
			avgs.set(min, temp3);

//			석차정렬
			int temp4 = ranks.get(i);		
			ranks.set(i, ranks.get(min));
			ranks.set(min, temp4);
			
//			학생정렬
			String temp5 = students.get(i);		
			students.set(i, students.get(min));
			students.set(min, temp5);
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
			System.out.print(students.get(i) + "\t");
			for(int j = 0; j < subjects.size(); j++){
				System.out.print(scores.get (i).get (j) + "\t");
			}
//			합계,평균,석차 출력
			System.out.println(sums.get (i) + "\t" + avgs.get (i) + "\t" + ranks.get (i));
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
