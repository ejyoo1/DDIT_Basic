package k_jdbc;

public class BoardDTO {
	private int board_no;// number not null,
    private String title;// varchar2(100),
    private String content;// varchar2(300),
    private String user_id;// varchar2(15),
    private String reg_date;// timestamp,
    
	public int getBoard_no () {
		return board_no;
	}
	public void setBoard_no (int board_no) {
		this.board_no = board_no;
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
	public String getUser_id () {
		return user_id;
	}
	public void setUser_id (String user_id) {
		this.user_id = user_id;
	}
	public String getReg_date () {
		return reg_date;
	}
	public void setReg_date (String reg_date) {
		this.reg_date = reg_date;
	}
    
    
}
