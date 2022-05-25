package org.kh.shareware.meetingRoom.domain;



import java.sql.Date;

import org.kh.shareware.member.domain.Member;
import org.springframework.format.annotation.DateTimeFormat;

public class MeetingRoom {
private String memberNum;
private String meetingNo;
private String meetingDate;
private int meetingTime;
private String meetingReservation;

private Member member;

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}

public MeetingRoom() {}

public String getMemberNum() {
	return memberNum;
}

public void setMemberNum(String memberNum) {
	this.memberNum = memberNum;
}

public String getMeetingNo() {
	return meetingNo;
}

public void setMeetingNo(String meetingNo) {
	this.meetingNo = meetingNo;
}

public String getMeetingDate() {
	return meetingDate;
}

public void setMeetingDate(String meetingDate) {
	this.meetingDate = meetingDate;
}

public int getMeetingTime() {
	return meetingTime;
}

public void setMeetingTime(int meetingTime) {
	this.meetingTime = meetingTime;
}

public String getMeetingReservation() {
	return meetingReservation;
}

public void setMeetingReservation(String meetingReservation) {
	this.meetingReservation = meetingReservation;
}

@Override
public String toString() {
	return "MeetingRoom [memberNum=" + memberNum + ", meetingNo=" + meetingNo + ", meetingDate=" + meetingDate
			+ ", meetingTime=" + meetingTime + ", meetingReservation=" + meetingReservation + ", member=" + member
			+ "]";
}

}
