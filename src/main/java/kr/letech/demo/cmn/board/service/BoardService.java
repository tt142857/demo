package kr.letech.demo.cmn.board.service;

import java.util.List;

import kr.letech.demo.cmn.board.vo.BoardVO;
import kr.letech.demo.cmn.paging.PagingVO;

public interface BoardService {
	// 게시판 조회
	public List<BoardVO> retrieveBoardList(PagingVO<BoardVO> paging);

	// 총 게시판 수 조회
	public int retrieveBoardTotalCount(PagingVO<BoardVO> paging);

	// 게시판 상세 조회
	public BoardVO retrieveBoardOne(int boardNo);

	// 게시판 등록
	public void createBoard(BoardVO board);

	// 게시판 삭제
	public void removeBoard(BoardVO board);

	// 게시판 수정
	public void modifyBoard(BoardVO board);
}
