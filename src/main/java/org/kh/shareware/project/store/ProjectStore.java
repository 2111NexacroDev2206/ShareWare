package org.kh.shareware.project.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.domain.WorkChart;

public interface ProjectStore {

	public int insertProject(Project project, SqlSession sqlSession); //프로젝트 등록
	public int insertParticipant(Participant participant, SqlSession sqlSession); // 참여자 등록
	public List<Project> selectAllProject(Project project, PageInfo pi, SqlSession sqlSession ); // 프로젝트 목록
	public Project selectOneProject(int projectNo, SqlSession sqlSession); //프로젝트 메인
	public Project selectOneProjectDetail(int projectNo, SqlSession sqlSession); //프로젝트 정보(상세)
	public int updateProject(Project project, SqlSession sqlSession);	  // 프로젝트 정보 수정
	public int deleteProject(int projectNo, SqlSession sqlSession);		//프로젝트 삭제
	public int deleteParticipant(Participant participant, SqlSession sqlSession); //참여자 삭제
	public List<Member> selectAllParticipant(SqlSession sqlSession, int projectNo);// 참여자 목록
	public int insertChart(SqlSession sqlSession, WorkChart  workChart); //진행률 등록 
	public int printChart(SqlSession sqlSession, WorkChart workChart); // 업무 진행률 조회(개인)
	public int updateChart(SqlSession sqlSession, WorkChart workChart); // 업무 진행률 수정(개인)
	public List<WorkChart> selectListChart(SqlSession sqlSession, int projectNo); //진행률 전체조회
	public int selectListCount(SqlSession sqlSession, Project project); //페이징
	public int selectListSearchCount(SqlSession sqlSession, Search search); //검색 페이징
	public List<Project> selectListSearch(SqlSession sqlSession, Search search, PageInfo pi); //프로젝트 검색

}
