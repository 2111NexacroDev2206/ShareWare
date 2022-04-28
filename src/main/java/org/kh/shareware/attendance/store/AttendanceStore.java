package org.kh.shareware.attendance.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.member.common.PageInfo;

public interface AttendanceStore {
	//등록
	public int insertAttendance(SqlSession sqlSession, Attendance attendance);
	public int updateAttendance(SqlSession sqlSession, Attendance attendance);

	//근태리스트
	List<Attendance> selectAll(SqlSession sqlSession, PageInfo pi, String memNum);
	public int selectListCount(SqlSession sqlSession, String memNum);

}
