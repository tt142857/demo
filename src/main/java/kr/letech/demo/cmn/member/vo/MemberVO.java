package kr.letech.demo.cmn.member.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
@RequiredArgsConstructor
@Slf4j
public class MemberVO {

	private String memId;
	private String memPswd;
	private String memNm;
	private String memEml;
}


