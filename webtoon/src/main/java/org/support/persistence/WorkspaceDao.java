package org.support.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.support.domain.Workspace;

@Repository
public class WorkspaceDao implements Workspace_interface {

	@Inject
	private SqlSession sqlsession;
	private final String Namespace = "org.support.toon.mappers.WorkspaceMapper.";
	
	@Override
	public int InsertWorkspace(Workspace w) {
		//0 정상 가입, 1 팀이름 중복, 2 설렉트 신텍스 오류, 3 인설트 신텍스 오류, 4 장르 인설트 오류
		System.out.println(w.getW_teamname());
		try {
			if((int) sqlsession.selectOne(Namespace + "overlapCheck_teamname", w.getW_teamname()) == 1) return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
		
		try {
			sqlsession.insert(Namespace + "Insert_Workspace", w);
		}
		catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		
		try {
			Map<String, Object> parameter = new HashMap<String, Object>();
			//밑에 부분 함수로 만들자
			String slice;
			if (w.getW_hobby() != null) {
				for (int i = 0; i < w.getW_hobby().length; i++) {
					slice = w.getW_hobby()[i].replace("[", "");
					slice = slice.replace("]", "");
					parameter.put("w_teamname", w.getW_teamname());
					parameter.put("w_hobby", slice);
					sqlsession.insert(Namespace + "Insert_Workspace_Hobby", parameter);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 4;
		}
		return 0;
	}

}
