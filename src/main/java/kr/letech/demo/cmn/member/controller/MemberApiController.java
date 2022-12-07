package kr.letech.demo.cmn.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.demo.cmn.member.service.MemberService;
import kr.letech.demo.cmn.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

	private final MemberService memberService;

	// 동일 회원 아이디 검증
	@GetMapping("/api/v1/member/check")
	public ResponseEntity<?> checkMemId(String memId) {
		int count = 0;
		count = memberService.verifyMemId(memId);
		return ResponseEntity.ok(count);
	}

	@PostMapping("/api/v1/member")
	public ResponseEntity<?> insertMember(MemberVO member) {
		int count = 0;
		count = memberService.createMember(member);
		if(count > 0) {
			return ResponseEntity.ok("success");
		} else {
			return ResponseEntity.ok("failed");
		}
	}
}
