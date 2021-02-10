
public interface IssueManagement {
//	로그인
	public abstract void login();
//	이슈 전체 목록 조회
	public abstract void issueReadAll();
//	이슈 생성
	public abstract void issueCreate();
//	이슈 개별 조회(이슈 상세)
	public abstract void issueRead();
//	이슈 수정
	public abstract void issueUpdate();
//	이슈 삭제
	public abstract void issueDelete();
//	이슈 통계 : 나에게 할당된 이슈 개수 조회
	public abstract void assignedMe();
//	이슈 통계 : 특정 담당자에게 할당한 이슈 개수 조회(유은지,박상영,박예진)
	public abstract void assignedOther();
//	이슈 통계 : 특정 마일스톤에 존재하는 이슈 개수 조회(1월패치,2월패치,3월패치)
	public abstract void searchMilestone();
//	이슈 통계 : 특정 타입에 존재하는 이슈 개수 조회(Bug,Improvement,NewFeature)
	public abstract void searchType();
//	이슈 통계 : 특정 처리 상태에 존재하는 이슈 개수 조회(New, Submit, Review, Resolved, Complated)
	public abstract void searchStatus();
//	이슈 관리 : 본인에게 할당된 이슈 조회 후(assignedMe) Next Process
	public abstract void nextProcess();
//	이슈 관리 : 본인에게 할당된 이슈 조회 후(assignedMe) Previous Process
	public abstract void previousProcess();
	
	
//	서브 기능-----
//	메뉴
	public abstract void userMenu();
//	메시지 알림(Success, Error, Warning)
//	Success : 작업 성공, Error : 작업실패, Warning : 경고(삭제시 사용)
	public abstract void message();
}
