package org.kh.shareware.meetingRoom.service;

import java.util.List;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.meetingRoom.domain.MeetingRoom;

public interface MeetingRoomService {
	//예약
	int registerRoom(MeetingRoom meetingRoom);
	//체크
	List<MeetingRoom> selectCheck(MeetingRoom meetingRoom);
	//회원 개인 예약 확인
	List<MeetingRoom> reservationList(PageInfo pi, String memberNum);
	//회의실 예약 취소
	int modifyRoom(MeetingRoom meetingRoom);
	int getListCount(String memberNum);

}
