package org.kh.shareware.member.service;

import java.util.List;

import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.domain.PageInfo;

public interface memberService {

	public Member loginMember(Member member);
	public Member printOneById(String memberNum); //사원정보
	
	public int getListCount(); //페이징
	public List<Member> printAll(PageInfo pi); //주소록
	public List<Member> modalPrintAll();
}
