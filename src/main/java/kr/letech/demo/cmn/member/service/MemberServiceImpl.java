package kr.letech.demo.cmn.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.letech.demo.cmn.member.dao.MemberDAO;
import kr.letech.demo.cmn.member.vo.MemberVO;
import kr.letech.demo.cmn.role.dao.RoleDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

	private final MemberDAO memberDAO;
	private final RoleDAO roleDAO;

	@Override
	public int verifyMemId(String memId) {
		return memberDAO.checkMemId(memId);
	}

	@Transactional
	@Override
	public int createMember(MemberVO member) {
		int count = 0;

		count = memberDAO.insertMember(member);
		if(count > 0) {
			roleDAO.insertDefaultRole(member.getMemId());
		}
		return count;
	}

	@Override
	public MemberVO retrieveMemberByMemId(String memId) {
		return memberDAO.selectMemberByMemId(memId);
	}
}
