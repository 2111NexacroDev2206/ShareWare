package org.kh.shareware.project.service;

import java.util.List;

import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.domain.WorkChart;

public interface ProjectService {

	public int registerProject(Project project);  //프로젝트  등록
	public int registerParticipant(Participant participant); // 참여자 등록
	public List<Project> printAllProject(Project project, PageInfo pi);	//프로젝트 목록
	public Project printOneProject(int projectNo);  //프로젝트 메인페이지
	public Project printOneProjectDetail(int projectNo); //프로젝트 정보(상세)
	public int modifyProject(Project project);	//프로젝트 정보 수정
	public int removeProject(int projectNo);	//프로젝트 삭제
	public int removeParticipant(Participant participant); // 참여자 삭제
	public List<Member> printAllParticipant(int projectNo);// 참여자 목록
	public int registerChart(WorkChart workChart); // 업무 진행률 등록 
	public int printChart(WorkChart workChart); // 업무 진행률 조회(개인)
	public int modifyChart(WorkChart workChart); // 업무 진행률 수정(개인)
	public List<WorkChart> printAllChart(int projectNo); //진행률 전체 조회
	public int getListCount(Project project); //페이징
	public int getSearchCount(Search search); //검색 페이징
	public List<Project> printSearch(Search search, PageInfo pi); //프로젝트 검색
	public List<Project> homeProject(String memberNum); // 홈 - 프로젝트 관리

	

}
