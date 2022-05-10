package org.kh.shareware.meetingRoom.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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

}
