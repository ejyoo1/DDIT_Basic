package e_oop.score;

public class Student2 {
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	String name;
	int rank;
	
	Student2(){
		rank 	= 1;
		kor		= (int)(Math.random () * 101);
		eng		= (int)(Math.random () * 101);
		math	= (int)(Math.random () * 101);
	}


	public int sumMethod (int kor, int eng, int math) {
		return kor + eng + math;
	}
	
	public double avgMethod(int sum) {
		avg = Math.round (((double)this.sum / 3.0)*100)/100.0;
		return avg;
	}
	
	public Student2[] sturankMethod(Student2[] students) {
		for(int i = 0 ; i < students.length ; i++){
			for(int j = 0 ; j < students.length ; j++){
				if(students[i].sum < students[j].sum){
					students[i].rank++;
				}
			}
		}
		return students;
	}
}