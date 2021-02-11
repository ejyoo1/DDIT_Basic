import java.util.ArrayList;
import java.util.HashMap;

public class IssueProcess implements IssueManagement{

	@Override
	public void login () {
		
	}

	@Override
	public int issueReadAll () {
//		DB에서 등록된 모든 이슈 목록을 가져옴 dbconntect()
		return 0;
	}

	@Override
	public void issueCreate () {
		
	}

	@Override
	public void issueRead () {
		
	}

	@Override
	public void issueUpdate () {
		
	}

	@Override
	public void issueDelete () {
		
	}

	@Override
	public void assignedMe () {
		
	}

	@Override
	public void assignedOther () {
		
	}

	@Override
	public void searchMilestone () {
		
	}

	@Override
	public void searchType () {
		
	}

	@Override
	public void searchStatus () {
		
	}

	@Override
	public void nextProcess () {
		
	}

	@Override
	public void previousProcess () {
		
	}

	@Override
	public void userMenu () {
//		issueReadAll() 호출
	}

	
//	메시지 알림(Success, Error, Warning)
//	Success : 작업 성공, Error : 작업실패, Warning : 경고(삭제시 사용)
	@Override
	public String message (String code) {
		if(code.equalsIgnoreCase ("success")) {
			return "### [ " + code + " ] ";
		} else if(code.equalsIgnoreCase ("error")) {
			return "### [ " + code + " ] ";
		} else if(code.equalsIgnoreCase ("warning")) {
			return "### [ " + code + " ] ";
		}else {
			return "### [ null ] ";
		}
	}

	@Override
	public ArrayList<HashMap<String, Object>> dbconntect (String url,
			String uid, String upw) {
		// TODO Auto-generated method stub
		return null;
	}

//	싱글톤 패턴 적용(객체생성 단 1번만)
	static IssueProcess issueProcess;
	public static IssueProcess getInstance () {
		if(issueProcess == null) {
			issueProcess = new IssueProcess();
		}
		return issueProcess;
	}
}
