package org.kh.shareware.attendance.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.member.common.PageInfo;

public interface AttendanceStore {
	//등록
	public int insertAttendance(SqlSession sqlSession, Attendance attendance);
	public int updateAttendance(SqlSession sqlSession, Attendance attendance);

	//근태리스트
	List<Attendance> selectAll(SqlSession sqlSession, String memNum);
	public int selectListCount(SqlSession sqlSession, String memNum);
	
	//통계
	public List<Stats> selectStats(SqlSession sqlSession, String memNum);
	
	// 홈 - 근태 관리
	public Attendance selectOneAtt(SqlSession sqlSession, String memberNum);

}
