package backup;

public class Msg2 {
	static void prodMsg(String code) {
		if(code.equals ("Alert")) {
			System.out.print (" ### [ "+ code +" ] ");
		}else if(code.equals ("Question")) {
			System.out.print (" ### [ "+ code +" ] ");
		}else if(code.equals ("Warning"))	{
			System.out.print (" ### [ "+ code +" ] ");
		}
	}
}
