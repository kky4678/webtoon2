package org.support.persistence;

import javax.servlet.http.HttpSession;

import org.support.domain.Member;

public interface Member_interface {
	public int InsertMember(Member m);
	public int LoginMember(String m_id, String m_pw, HttpSession session);
}
