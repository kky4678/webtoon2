package org.support.domain;

public class Member {
	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_nick;
	private String m_birthday;
	private String m_gender;
	private String m_class;
	private String m_location;
	private String m_hobby[];
	
	public String[] getM_hobby() {
		return m_hobby;
	}
	public void setM_hobby(String[] m_hobby) {
		this.m_hobby = m_hobby;
	}
	
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_birthday() {
		return m_birthday;
	}
	public void setM_birthday(String m_birthday) {
		this.m_birthday = m_birthday;
	}
	public String getM_class() {
		return m_class;
	}
	public void setM_class(String m_class) {
		this.m_class = m_class;
	}
	public String getM_location() {
		return m_location;
	}
	public void setM_location(String m_location) {
		this.m_location = m_location;
	}
	
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	
	@Override
	public String toString() {
		String text = "번호 : " + m_no + " 아이디 : " + m_id + " 비밀번호: " + m_pw + " 닉네임 : " + m_nick + " 생년월일 " + m_birthday +
				" 성별 :" + m_gender + " 유형 : " + m_class + " 지역: " + m_location + " 관심 :  ";
		
		for(String str : m_hobby) {
			text += str + ", ";
		}
		return text;
	}
}
