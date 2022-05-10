package org.kh.shareware.meetingRoom.service;

import java.util.List;

import org.kh.shareware.meetingRoom.domain.MeetingRoom;

public interface MeetingRoomService {
	//예약
	int registerRoom(MeetingRoom meetingRoom);
	//체크
	List<MeetingRoom> selectCheck(MeetingRoom meetingRoom);

}
