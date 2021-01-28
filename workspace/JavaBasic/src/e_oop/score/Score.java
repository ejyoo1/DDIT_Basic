package e_oop.score;

public class Score {

	public static void main (String[] args) {
		Student[] students = new Student[10];//[null, null, null,... , null]
		
		
		for(int i = 0 ; i < students.length ; i++){
			Student student = new Student ();//학생을 열명을 만들어야되기때문에
			
			student.name 	= "학생" + (i + 1);
			student.rank 	= 1;
			student.kor		= (int)(Math.random () * 101);
			student.eng		= (int)(Math.random () * 101);
			student.math	= (int)(Math.random () * 101);
			
			student.sum		= student.kor + student.eng + student.math;
			student.avg		= Math.round (((double)student.sum / 3.0)*100)/100.0;
			
			
			students[i] = student;//[null, null, ... , new Student()];
		}
		
		//석차
		for(int i = 0 ; i < students.length ; i++){
			for(int j = 0 ; j < students.length ; j++){
				if(students[i].sum < students[j].sum){
					students[i].rank++;
				}
			}
		}
		
		//정렬
		for(int i = 1 ; i < students.length; i++){
			Student temp = students[i];//students[i]를 기본값으로 세팅
			int j = 0;
			
			for(j = i - 1 ; j >= 0 ; j--){//j는 i보다 -1 된 값부터 시작하고 0이 되기 전까지 1씩 감소한다.
				if(temp.rank < students[j].rank){ //j보다 작으면
					students[j+1] = students[j];//j의 인덱스를 저장한다.
				}else{//j보다 크면
					break;
				}
			}
			students[j+1] = temp;	//그자리에 넣는다.
		}
		
	
		//출력
		System.out.println("이름\t국어\t수학\t영어\t합계\t평균\t석차");
		for(int i = 0 ; i < students.length ; i++){
			System.out.print(students[i].name + "\t" + students[i].kor + "\t"
							+ students[i].eng	+ "\t" + students[i].math+"\t"+students[i].sum+"\t"
							+ students[i].avg	+ "\t" + students[i].rank);
			System.out.println();
		}
		
		int[] subSum = new int[3];
		double[] subAvg = new double[3];
		
		for(int i = 0 ; i < students.length ; i++){
			subSum[0] += students[i].kor;
			subSum[1] += students[i].eng;
			subSum[2] += students[i].math;
		}
		
		System.out.print("과목합계\t");
		for(int i = 0 ; i < subSum.length ; i++){
			System.out.print(subSum[i] + "\t");
		}
		
		System.out.println();
		
		
		for(int i = 0 ; i < subAvg.length ; i++){
			subAvg[i] = Math.round (((double)subSum[i] / 3.0)*100)/100.0;
		}
		
		System.out.print("과목평균\t");
		for(int i = 0 ; i < subAvg.length ; i++){
			System.out.print(subAvg[i] + "\t");
		}
		
		System.out.println();
		
		
		
		/*
		ScoreClass[] scoreclasses = new ScoreClass[5];
		for(int i = 0 ; i < scoreclasses.length ; i++){
			ScoreClass sclass = new ScoreClass ();
			sclass.classSum = 1000;
			scoreclasses[i] = sclass;
			
			System.out.println(scoreclasses[i].classSum);
		}
		*/
	}
}
