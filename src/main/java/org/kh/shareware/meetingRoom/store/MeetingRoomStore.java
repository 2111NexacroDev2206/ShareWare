package org.kh.shareware.meetingRoom.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.meetingRoom.domain.MeetingRoom;

public interface MeetingRoomStore {

	int insertRoom(SqlSession sqlsession, MeetingRoom meetingRoom);

	List<MeetingRoom> selectCheck(SqlSession sqlsession, MeetingRoom meetingRoom);

}
