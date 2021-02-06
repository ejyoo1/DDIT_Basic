package model1;

import java.util.Date;

public class Board {
	int bno;// number,
    String title;// varchar2(200) not null,
    String content;// varchar2(255),
    String writer;// varchar2(50) not null,
    String regdate;// date default sysdate not null,
    int viewcnt;// number default 0,
    int replycnt;// number default 0
	public int getBno () {
		return bno;
	}
	public void setBno (int bno) {
		this.bno = bno;
	}
	public String getTitle () {
		return title;
	}
	public void setTitle (String title) {
		this.title = title;
	}
	public String getContent () {
		return content;
	}
	public void setContent (String content) {
		this.content = content;
	}
	public String getWriter () {
		return writer;
	}
	public void setWriter (String writer) {
		this.writer = writer;
	}
	public String getRegdate () {
		return regdate;
	}
	public void setRegdate (String regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt () {
		return viewcnt;
	}
	public void setViewcnt (int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getReplycnt () {
		return replycnt;
	}
	public void setReplycnt (int replycnt) {
		this.replycnt = replycnt;
	}
}
