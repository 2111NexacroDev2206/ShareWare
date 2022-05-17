package org.kh.shareware.project.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.domain.WorkChart;
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
	public List<Project> printAllProject(Project project , PageInfo pi) {
		List<Project> pList = pStore.selectAllProject(project, pi, sqlSession);
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
	//진행률 등록 
	@Override
	public int registerChart(WorkChart workChart) {
		int result = pStore.insertChart(sqlSession, workChart);
		return result;
	}
	// 업무 진행률 조회(개인)
	@Override
	public int printChart(WorkChart workChart) {
		int chart = pStore.printChart(sqlSession, workChart);
		return chart;
	}
	// 업무 진행률 수정(개인)
	@Override
	public int modifyChart(WorkChart workChart) {
		int result= pStore.updateChart(sqlSession, workChart);
		return result;
	}
	//진행률 전체조회
	@Override
	public List<WorkChart> printAllChart(int projectNo) {
		List<WorkChart> cList = pStore.selectListChart(sqlSession, projectNo);
		return cList;
	}
	//페이징
	@Override
	public int getListCount(Project project) {
		int totalCount = pStore.selectListCount(sqlSession, project);
		return totalCount;
	}
	//검색 페이징
	@Override
	public int getSearchCount(Search search) {
		int totalCount = pStore.selectListSearchCount(sqlSession, search);
		return totalCount;
	}
	//프로젝트 검색
	@Override
	public List<Project> printSearch(Search search, PageInfo pi) {
		List<Project> pList = pStore.selectListSearch(sqlSession, search, pi);
		return pList;
	}
	// 홈 - 프로젝트 관리
	@Override
	public List<Project> homeProject(String memberNum) {
		List<Project> pList = pStore.selectListHomeProject(sqlSession, memberNum);
		return pList;
	}

}
