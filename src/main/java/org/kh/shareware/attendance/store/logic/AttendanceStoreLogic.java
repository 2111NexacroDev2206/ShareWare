package org.kh.shareware.attendance.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.store.AttendanceStore;
import org.kh.shareware.member.common.PageInfo;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceStoreLogic implements AttendanceStore{

	//등록
	@Override
	public int insertAttendance(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.insert("AttendanceMapper.insertAttendance", attendance);
		return result;
	}

	//근태리스트
	@Override
	public List<Attendance> selectAll(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getMemberLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Attendance> aList 
			= sqlSession.selectList("AttendanceMapper.selectAllList", pi, rowBounds);
		return aList;
	}
	@Override
	public int selectListCount(SqlSession sqlSession) {
		int totalCount = sqlSession.selectOne("AttendanceMapper.selectListCount");
		return totalCount;
	}

}
