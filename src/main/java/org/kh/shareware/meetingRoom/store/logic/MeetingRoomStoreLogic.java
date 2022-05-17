package org.kh.shareware.meetingRoom.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.meetingRoom.domain.MeetingRoom;
import org.kh.shareware.meetingRoom.store.MeetingRoomStore;
import org.springframework.stereotype.Repository;

@Repository
public class MeetingRoomStoreLogic implements MeetingRoomStore{

	@Override
	public int insertRoom(SqlSession sqlsession, MeetingRoom meetingRoom) {
		int result = sqlsession.insert("MeetingRoomMapper.insertRoom", meetingRoom);
		return result;
	}

	@Override
	public List<MeetingRoom> selectCheck(SqlSession sqlsession, MeetingRoom meetingRoom) {
		List<MeetingRoom> mList = sqlsession.selectList("MeetingRoomMapper.selectCheck", meetingRoom);
		return mList;
	}
	
	//회원 개인 예약 확인
	@Override
	public List<MeetingRoom> selectListReservation(SqlSession sqlsession, PageInfo pi, String memberNum) {
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<MeetingRoom> mList = sqlsession.selectList("MeetingRoomMapper.selectListReservation",memberNum,rowBounds);
		return mList;
	}
	//회의실 예약취소
	@Override
	public int updateRoom(SqlSession sqlsession, MeetingRoom meetingRoom) {
		int result = sqlsession.update("MeetingRoomMapper.updateRoomCancle", meetingRoom);
		return result;
	}

	@Override
	public int selectClistCount(SqlSession sqlsession, String memberNum) {
		int totalCount =sqlsession.selectOne("MeetingRoomMapper.selectClistCount", memberNum);
		return totalCount;
	}

}
