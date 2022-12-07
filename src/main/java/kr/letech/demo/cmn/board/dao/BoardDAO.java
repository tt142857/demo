package kr.letech.demo.cmn.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.letech.demo.cmn.attach.vo.AtchVO;
import kr.letech.demo.cmn.board.vo.BoardVO;
import kr.letech.demo.cmn.cmnt.vo.CmntVO;
import kr.letech.demo.cmn.paging.PagingVO;


@Mapper
public interface BoardDAO {
	// 게시판 조회
	public List<BoardVO> selectBoardList(PagingVO<BoardVO> paging);

	// 총 게시판 수 조회
	public int selectBoardTotalCount(PagingVO<BoardVO> paging);

	// 게시판 상세 조회
	public BoardVO selectBoardOne(int boardNo);

	// 게시판 등록
	public void insertBoard(BoardVO board);

	// 게시판 삭제
	public void deleteBoard(BoardVO board);

	// 게시판 수정
	public void updateBoard(BoardVO board);

	// 게시판 조회수 증가
	public void updateBoardHit(int boardNo);

	// 게시판 첨부파일 조회
	public List<AtchVO> selectBoardOneAtchList(int boardNo);

	// 게시판 댓글 조회
	public List<CmntVO> selectBoardOneCmntList(int boardNo);

	// 게시판 첨부파일 아이디 수정
	public void updateBoardAtchId(BoardVO board);
}
