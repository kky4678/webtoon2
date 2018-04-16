package org.support.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.support.domain.Member;

@Repository
public class MemberDao implements Member_interface {

	@Inject
	private SqlSession sqlsession;

	private final String NameSpace = "org.support.toon.mappers.memberMapper.";

	@Override
	public int InsertMember(Member m) {
		// 0 = 정상, 1 = 아이디 중복, 2 = 닉네임 중복, 3= insert 신텍스 오류
		if ((int) sqlsession.selectOne(NameSpace + "overlapCheck_ID", m.getM_id()) == 1) {
			return 1;
		} else if ((int) sqlsession.selectOne(NameSpace + "overlapCheck_NICK", m.getM_nick()) == 1) {
			return 2;
		}
		try {
			sqlsession.insert(NameSpace + "Insert_Member", m);
			Map<String, Object> parameter = new HashMap<String, Object>();
			String slice;
			if (m.getM_hobby() != null) {
				for (int i = 0; i < m.getM_hobby().length; i++) {
					slice = m.getM_hobby()[i].replace("[", "");
					slice = slice.replace("]", "");
					parameter.put("m_id", m.getM_id());
					parameter.put("m_hobby", slice);
					sqlsession.insert(NameSpace + "Insert_Member_Hobby", parameter);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}

		return 0;
	}

	@Override
	public int LoginMember(String m_id, String m_pw, HttpSession session) {
		// 0 정상, 1 아이디 비번 검색이 안됨, 2 아이디 검색중 DB 신텍스 오류, 3 아이디 검색 결과가 없음, 4 아이디 검색중 신텍스 오류
		Map<String, String> Parameter = new HashMap<String, String>();
		Parameter.put("m_id", m_id);
		Parameter.put("m_pw", m_pw);
		try {
			if ((int) sqlsession.selectOne(NameSpace + "LoginMember", Parameter) == 1) {

				try {
					Member m = sqlsession.selectOne(NameSpace + "Member_info", Parameter.get("m_id"));
					if(m == null) return 3;
					session.setAttribute("m", m);
				}
				catch (Exception e) {
					e.printStackTrace();
					return 4;
				}
				
			} else {
				return 1;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
		return 0;
	}
}
