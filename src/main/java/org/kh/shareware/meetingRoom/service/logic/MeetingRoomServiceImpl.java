package org.kh.shareware.meetingRoom.service.logic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.meetingRoom.domain.MeetingRoom;
import org.kh.shareware.meetingRoom.service.MeetingRoomService;
import org.kh.shareware.meetingRoom.store.MeetingRoomStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService{
	@Autowired
	private MeetingRoomStore mStore;
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int registerRoom(MeetingRoom meetingRoom) {
		int result = mStore.insertRoom(sqlsession, meetingRoom);
		return result;
	}

	@Override
	public List<MeetingRoom> selectCheck(MeetingRoom meetingRoom) {
		List<MeetingRoom> mList = mStore.selectCheck(sqlsession, meetingRoom);
		return mList;
	}

	@Override
	public List<MeetingRoom> reservationList(PageInfo pi,String memberNum) {
		List<MeetingRoom> mList = mStore.selectListReservation(sqlsession, pi, memberNum);
		return mList;
	}

	@Override
	public int modifyRoom(MeetingRoom meetingRoom) {
		int result = mStore.updateRoom(sqlsession, meetingRoom);
		return result;
	}

	@Override
	public int getListCount(String memberNum) {
		int result = mStore.selectClistCount(sqlsession, memberNum);
		return result;
	}

	@Override
	public List<MeetingRoom> adminReservationList(MeetingRoom meetingRoom) {
		List<MeetingRoom> mList= mStore.selectListAdminReservation(sqlsession, meetingRoom);
		return mList;
	}

}
