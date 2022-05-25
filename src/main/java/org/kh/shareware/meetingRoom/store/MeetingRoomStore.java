package org.kh.shareware.meetingRoom.store;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.meetingRoom.domain.MeetingRoom;

public interface MeetingRoomStore {

	int insertRoom(SqlSession sqlsession, MeetingRoom meetingRoom);

	List<MeetingRoom> selectCheck(SqlSession sqlsession, MeetingRoom meetingRoom);
	//회원 개인 예약 확인
	List<MeetingRoom> selectListReservation(SqlSession sqlsession,PageInfo pi, String memberNum);
	//회의실 예약 취소
	int updateRoom(SqlSession sqlsession, MeetingRoom meetingRoom);

	int selectClistCount(SqlSession sqlsession, String memberNum);
	//관리자 리스트페이지 onload
	List<MeetingRoom> selectListAdminReservation(SqlSession sqlsession, MeetingRoom meetingRoom);

}
