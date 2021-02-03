package model1;

public class User {
	int idx;// number,
    String uid;// userid varchar2(50) not null,
    String upw;// userpw varchar2(50) not null,
    public int getIdx () {
		return idx;
	}
	public void setIdx (int idx) {
		this.idx = idx;
	}
	public String getUid () {
		return uid;
	}
	public void setUid (String uid) {
		this.uid = uid;
	}
	public String getUpw () {
		return upw;
	}
	public void setUpw (String upw) {
		this.upw = upw;
	}
	public String getRegdate () {
		return regdate;
	}
	public void setRegdate (String regdate) {
		this.regdate = regdate;
	}
	String regdate;// date default sysdate
}
