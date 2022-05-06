package org.kh.shareware.project.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;

public interface ProjectStore {

	public int insertProject(Project project, SqlSession sqlSession); //프로젝트 등록
	public int insertParticipant(Participant participant, SqlSession sqlSession); // 참여자 등록
	public List<Project> selectAllProject(String memberNum, SqlSession sqlSession ); // 프로젝트 목록
	public Project selectOneProject(int projectNo, SqlSession sqlSession); //프로젝트 메인
	public Project selectOneProjectDetail(int projectNo, SqlSession sqlSession); //프로젝트 정보(상세)
	public int updateProject(Project project, SqlSession sqlSession);	  // 프로젝트 정보 수정
	public int deleteProject(int projectNo, SqlSession sqlSession);		//프로젝트 삭제
	public int deleteParticipant(Participant participant, SqlSession sqlSession); //참여자 삭제
	public List<Member> selectAllParticipant(SqlSession sqlSession, int projectNo);// 참여자 목록
//	public int updateEndStatus(SqlSession sqlSession, int projectNo); //프로젝트 종료

}
