package kr.letech.demo.cmn.member.service;

import kr.letech.demo.cmn.member.vo.MemberVO;

public interface MemberService {

	// 동일 회원 아이디 검증
	public int verifyMemId(String memId);

	// 회원 등록
	public int createMember(MemberVO mem);

	// 로그인
	public MemberVO retrieveMemberByMemId(String memId);
}
