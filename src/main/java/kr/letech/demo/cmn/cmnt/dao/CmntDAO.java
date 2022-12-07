package kr.letech.demo.cmn.cmnt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.letech.demo.cmn.cmnt.vo.CmntVO;

@Mapper
public interface CmntDAO {

	// 댓글 등록
	public void insertCmnt(CmntVO cmnt);

	// 댓글 수정
	public void updateCmnt(CmntVO cmnt);

	// 댓글 삭제
	public void deleteCmnt(CmntVO cmnt);

	// 댓글 전체 삭제(게시판 삭제 시 사용)
	public void deleteCmntAll(int boardNo);

	// 게시글 댓글 목록 조회
	public List<CmntVO> selectBoardOneCmntList(int boardNo);

	// 게시글 댓글 작성자 조회
	public String selectBoardOneCmntRgstId(CmntVO cmnt);
}
