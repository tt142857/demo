package kr.letech.demo.cmn.cmnt.service;

import java.util.List;

import kr.letech.demo.cmn.cmnt.vo.CmntVO;

public interface CmntService {

	// 댓글 등록
	public void createCmnt(CmntVO cmnt);

	// 댓글 수정
	public void modifyCmnt(CmntVO cmnt);

	// 댓글 삭제
	public void removeCmnt(CmntVO cmnt);

	// 게시글 댓글 목록 조회
	public List<CmntVO> retrieveBoardOneCmntList(int boardNo);

	// 게시글 댓글 작성자 조회
	public String retrieveBoardOneCmntRgstId(CmntVO cmnt);
}
