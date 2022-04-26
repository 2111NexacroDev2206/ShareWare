package org.kh.shareware.project.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.store.ProjectStore;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectStoreLogic implements ProjectStore {

	@Override
	public int insertProject(Project project, SqlSession sqlSession) {
		int result = sqlSession.insert("ProjectMapper.insertProject", project);
		return result;
	}

}
