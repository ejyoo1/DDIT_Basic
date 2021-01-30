package sub;

public class Hint {
	String criminalHint1;
	String criminalHint2;
	String motivationHint1;
	String motivationHint2;
	String toolHint1;
	String toolHint2;
	
	Hint(String criminalHint1, String criminalHint2, String motivationHint1, String motivationHint2, String toolHint1, String toolHint2){
		this.criminalHint1 		= criminalHint1;
		this.criminalHint2 		= criminalHint2;
		this.motivationHint1 	= motivationHint1;
		this.motivationHint2	= motivationHint2;
		this.toolHint1			= toolHint1;
		this.toolHint2			= toolHint2;
	}
	
	void hintPrintln(int count) {
		Card cd = new Card();
		System.out.print ("**[[범인 힌트" + (count) +  " : " + criminalHint1 + ", " + criminalHint2 + "]] ");
		cd.cardCriminalPrintin();
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		
		System.out.print ("**[[살해동기 힌트" + (count) +  " : " + motivationHint1 + ", " + motivationHint1 + "]] ");
		cd.cardMotivationPrintin ();
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
		
		
		
		System.out.print ("**[[살해도구 힌트" + (count) +  " : " + toolHint1 + ", " + toolHint2 + "]] ");
		cd.cardToolPrintin ();
		System.out.println ("---------------------------------------------------------------------------------------------");
		System.out.println ();
	}
}
