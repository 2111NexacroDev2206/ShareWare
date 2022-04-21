package org.kh.shareware.member.service;

import org.kh.shareware.member.domain.Member;

public interface memberService {

	public Member loginMember(Member member);
	public Member printOneById(String memberNum);
}
