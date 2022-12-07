package kr.letech.demo.cmn.base;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;
import kr.letech.demo.cmn.member.vo.MemberVO;

public class BaseController {

	public MemberVO getMember() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();

		MemberVO member = (MemberVO) httpSession.getAttribute("userInfo");

		return member;
	}

	// 로그인한 userId 반환
	public String userId() {
		MemberVO member = this.getMember();
		String memId = null;
		if (member != null) {
			memId = member.getMemId();
		}
		return memId;
	}

}
