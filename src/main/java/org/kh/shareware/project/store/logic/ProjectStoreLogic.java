package org.kh.shareware.project.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.domain.WorkChart;
import org.kh.shareware.project.store.ProjectStore;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectStoreLogic implements ProjectStore {

	//프로젝트 등록
	@Override
	public int insertProject(Project project, SqlSession sqlSession) {
		int result = sqlSession.insert("ProjectMapper.insertProject", project);
		return result;
	}
	//참여자 등록
	@Override
	public int insertParticipant(Participant participant, SqlSession sqlSession) {
		int result = sqlSession.insert("ProjectMapper.insertParticipant", participant);
		return result;
	}
	//프로젝트 목록
	@Override
	public List<Project> selectAllProject(Project project, PageInfo pi, SqlSession sqlSession) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Project> pList = sqlSession.selectList("ProjectMapper.selectAllProject", project, rowBounds);
		return pList;
	}
	//프로젝트 메인
	@Override
	public Project selectOneProject(int projectNo, SqlSession sqlSession) {
		Project project = sqlSession.selectOne("ProjectMapper.selectOneProject", projectNo);
		return project;
	}
	//프로젝트 정보(상세)
	@Override
	public Project selectOneProjectDetail(int projectNo, SqlSession sqlSession) {
		Project project = sqlSession.selectOne("ProjectMapper.selectOneProjectDetail", projectNo );
		return project;
	}
	//프로젝트 정보 수정
	@Override
	public int updateProject(Project project, SqlSession sqlSession) {
		int result = sqlSession.update("ProjectMapper.updateProject", project );
		return result;
	}
	//프로젝트 삭제
	@Override
	public int deleteProject(int projectNo, SqlSession sqlSession) {
		int result = sqlSession.delete("ProjectMapper.deleteProject", projectNo);
		return result;
	}
	//참여자 목록
	@Override
	public List<Member> selectAllParticipant(SqlSession sqlSession, int projectNo) {
		List<Member> pList = sqlSession.selectList("ProjectMapper.selectAllParticipant", projectNo);
		return pList;
	}
	//참여자 삭제
	@Override
	public int deleteParticipant(Participant participant, SqlSession sqlSession) {
		int result = sqlSession.delete("ProjectMapper.deleteParticipant", participant);
		return result;
	}
	//진행률 입력
	@Override
	public int insertChart(SqlSession sqlSession, WorkChart workChart) {
		int result = sqlSession.insert("ProjectMapper.insertChart", workChart);
		return result;
	}
	// 업무 진행률 조회(개인)
	@Override
	public int printChart(SqlSession sqlSession, WorkChart workChart) {
		int chart = sqlSession.selectOne("ProjectMapper.selectOneChart", workChart);
		return chart;
	}
	// 업무 진행률 수정(개인)
	@Override
	public int updateChart(SqlSession sqlSession, WorkChart workChart) {
		int result = sqlSession.update("ProjectMapper.updateChart", workChart );
		return result;
	}
	//진행률 전체조회
	@Override
	public List<WorkChart> selectListChart(SqlSession sqlSession, int projectNo) {
		List<WorkChart> cList = sqlSession.selectList("ProjectMapper.selectListChart" , projectNo);
		return cList;
	}
	//페이징
	@Override
	public int selectListCount(SqlSession sqlSession, Project project) {
		int totalCount = sqlSession.selectOne("ProjectMapper.selectOneCount", project);
		return totalCount;
	}
	//검색 페이징
	@Override
	public int selectListSearchCount(SqlSession sqlSession, Search search) {
		int totalCount = sqlSession.selectOne("ProjectMapper.selectOneSearchCount", search);
		return totalCount;
	}
	//프로젝트 검색
	@Override
	public List<Project> selectListSearch(SqlSession sqlSession, Search search, PageInfo pi) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Project> pList = sqlSession.selectList("ProjectMapper.selectSearchProject", search, rowBounds);
		return pList;
	}


}
