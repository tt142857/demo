package kr.letech.demo.cmn.member.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.letech.demo.cmn.member.vo.MemberVO;

@Mapper
public interface MemberDAO {

	// 동일 회원 아이디 검증
	public int checkMemId(String memId);

	// 회원 등록
	public int insertMember(MemberVO member);

	// 로그인
	public MemberVO selectMemberByMemId(String memId);
}
