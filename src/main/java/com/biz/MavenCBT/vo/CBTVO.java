package com.biz.MavenCBT.vo;



public class CBTVO {
	private long cb_id ;
    private String cb_Question ;
    private String cb_bogi ;
    private String cb_answer ;
	public CBTVO(long cb_id, String cb_Question, String cb_bogi, String cb_answer) {
		super();
		this.cb_id = cb_id;
		this.cb_Question = cb_Question;
		this.cb_bogi = cb_bogi;
		this.cb_answer = cb_answer;
	}
	public CBTVO(String cb_Question, String cb_bogi, String cb_answer) {
		super();
		this.cb_Question = cb_Question;
		this.cb_bogi = cb_bogi;
		this.cb_answer = cb_answer;
	}
	public CBTVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCb_id() {
		return cb_id;
	}
	public void setCb_id(long cb_id) {
		this.cb_id = cb_id;
	}
	public String getCb_Question() {
		return cb_Question;
	}
	public void setCb_Question(String cb_Question) {
		this.cb_Question = cb_Question;
	}
	public String getCb_bogi() {
		return cb_bogi;
	}
	public void setCb_bogi(String cb_bogi) {
		this.cb_bogi = cb_bogi;
	}
	public String getCb_answer() {
		return cb_answer;
	}
	public void setCb_answer(String cb_answer) {
		this.cb_answer = cb_answer;
	}
	@Override
	public String toString() {
		return "CBTVO [cb_id=" + cb_id + ", cb_Question=" + cb_Question + ", cb_bogi=" + cb_bogi + ", cb_answer="
				+ cb_answer + "]";
	}
}
