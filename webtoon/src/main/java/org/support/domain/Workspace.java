package org.support.domain;

import java.sql.Timestamp;

public class Workspace {
	private int w_no;
	private int w_owner;
	private String w_ownername;
	private String w_teamname;
	private String w_title;
	private String w_information;
	private String w_logo;
	private String w_synopsis;
	private String w_enable;
	private String w_hobby[];
	private Timestamp w_regdate;

	

	public String[] getW_hobby() {
		return w_hobby;
	}
	public void setW_hobby(String[] w_hobby) {
		this.w_hobby = w_hobby;
	}
	public int getW_no() {
		return w_no;
	}
	public void setW_no(int w_no) {
		this.w_no = w_no;
	}
	public int getW_owner() {
		return w_owner;
	}
	public void setW_owner(int w_owner) {
		this.w_owner = w_owner;
	}
	public String getW_ownername() {
		return w_ownername;
	}
	public void setW_ownername(String w_ownername) {
		this.w_ownername = w_ownername;
	}
	public String getW_teamname() {
		return w_teamname;
	}
	public void setW_teamname(String w_teamname) {
		this.w_teamname = w_teamname;
	}
	public String getW_title() {
		return w_title;
	}
	public void setW_title(String w_title) {
		this.w_title = w_title;
	}
	public String getW_information() {
		return w_information;
	}
	public void setW_information(String w_information) {
		this.w_information = w_information;
	}
	public String getW_logo() {
		return w_logo;
	}
	public void setW_logo(String w_logo) {
		this.w_logo = w_logo;
	}
	public String getW_synopsis() {
		return w_synopsis;
	}
	public void setW_synopsis(String w_synopsis) {
		this.w_synopsis = w_synopsis;
	}
	public String getW_enable() {
		return w_enable;
	}
	public void setW_enable(String w_enable) {
		this.w_enable = w_enable;
	}
	public Timestamp getW_regdate() {
		return w_regdate;
	}
	public void setW_regdate(Timestamp w_regdate) {
		this.w_regdate = w_regdate;
	}
	
	@Override
	public String toString() {
		String Text = "번호 : " + w_no + " 주인(번호) : " + w_owner + " 주인(이름) " + w_ownername + " 팀 이름 : " + w_teamname + " 웹툰 제목 : " + w_title;
		Text += " 소개 : " + w_information + " 로고 : " + w_logo + " 시놉시스 : " + w_synopsis + " 사용여부 : " + w_enable + " 등록일 :  " + w_regdate + " 취미 : ";
		
		for(String str : w_hobby) {
			Text += str;
		}
		return Text;
	}
}
