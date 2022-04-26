package org.kh.shareware.project.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.service.ProjectService;
import org.kh.shareware.project.store.ProjectStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private ProjectStore pStore;
	@Override
	
	//프로젝트 등록
	public int registerProject(Project project) {
		int result = pStore.insertProject(project, sqlSession);
		return result;
	}

}
