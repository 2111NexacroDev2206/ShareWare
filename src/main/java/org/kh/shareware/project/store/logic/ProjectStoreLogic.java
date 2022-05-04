package org.kh.shareware.project.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
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
	public List<Project> selectAllProject(String memberNum, SqlSession sqlSession) {
		List<Project> pList = sqlSession.selectList("ProjectMapper.selectAllProject",memberNum);
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
	


}
