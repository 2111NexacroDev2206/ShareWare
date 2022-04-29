package org.kh.shareware.project.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.service.ProjectService;
import org.kh.shareware.project.store.ProjectStore;
import org.kh.shareware.report.domain.Daily;
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
	//참여자 등록
	@Override
	public int registerParticipant(Participant participant) {
		int result = pStore.insertParticipant(participant, sqlSession);
		return result;
	}
	//프로젝트 목록
	@Override
	public List<Project> printAllProject(String memberNum) {
		List<Project> pList = pStore.selectAllProject(memberNum, sqlSession );
		return pList;
	}
	//프로젝트 메인페이지로
	@Override
	public Project printOneProject(int projectNo) {
		Project project = pStore.selectOneProject(projectNo, sqlSession );
		return project;
	}
	//프로젝트 정보(상세)
	@Override
	public Project printOneProjectDetail(int projectNo) {
		Project project = pStore.selectOneProjectDetail(projectNo, sqlSession);
		return project;
	}
	//프로젝트 정보 수정
	@Override
	public int modifyProject(Project project) {
		int result= pStore.updateProject(project, sqlSession);
		return result;
	}
	//프로젝트 삭제  
	@Override
	public int removeProject(int projectNo) {
		int result = pStore.deleteProject(projectNo ,sqlSession); 
		return result;
	}
	//참여자 삭제
	@Override
	public int removeParticipant(Participant participant) {
		int result= pStore.deleteParticipant(participant, sqlSession);
		return result;
	}
	//참여자 목록
	@Override
	public List<Member> printAllParticipant(int projectNo) {
		List<Member>  pList = pStore.selectAllParticipant(sqlSession , projectNo);
		return pList;
	}




}
