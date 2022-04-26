package org.kh.shareware.project.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.domain.Project;

public interface ProjectStore {

	public int insertProject(Project project, SqlSession sqlSession); //프로젝트 등록

}
