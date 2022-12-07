package kr.letech.demo.cmn.board.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.letech.demo.cmn.attach.dao.AtchDAO;
import kr.letech.demo.cmn.attach.vo.AtchVO;
import kr.letech.demo.cmn.board.dao.BoardDAO;
import kr.letech.demo.cmn.board.vo.BoardVO;
import kr.letech.demo.cmn.cmnt.dao.CmntDAO;
import kr.letech.demo.cmn.cmnt.vo.CmntVO;
import kr.letech.demo.cmn.paging.PagingVO;
import kr.letech.demo.cmn.utils.date.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDao;
	private final AtchDAO atchDao;
	private final CmntDAO cmntDao;

	@Value("${atch.file.store.path}")
	private String savePath;

	// 게시판 조회
	@Override
	public List<BoardVO> retrieveBoardList(PagingVO<BoardVO> paging) {
		return this.boardDao.selectBoardList(paging);
	}

	// 총 게시판 수 조회
	@Override
	public int retrieveBoardTotalCount(PagingVO<BoardVO> paging) {
		return this.boardDao.selectBoardTotalCount(paging);
	}

	// 게시판 상세 조회
	@Override
	public BoardVO retrieveBoardOne(int boardNo) {
		this.boardDao.updateBoardHit(boardNo);
		BoardVO board = this.boardDao.selectBoardOne(boardNo);
		List<AtchVO> atchList = this.boardDao.selectBoardOneAtchList(boardNo);
		List<CmntVO> cmntList = this.boardDao.selectBoardOneCmntList(boardNo);
		board.setAtchList(atchList);
		board.setCmntList(cmntList);
		return board;
	}

	// 게시판 등록
	@Transactional
	@Override
	public void createBoard(BoardVO board) {
		// 첨부파일이 있는 경우
		uploadProcess(board);

		this.boardDao.insertBoard(board);
	}

	public void uploadProcess(BoardVO board) {
		List<AtchVO> atchList = board.getAtchList();
		if(atchList != null && atchList.size() > 0) {
			String atchId = board.getAtchId();
			if(atchId == null || atchId.isBlank()) {
				atchId =  UUID.randomUUID().toString();
				board.setAtchId(atchId);
				this.boardDao.updateBoardAtchId(board);
			}
			String rgstId = board.getRgstId();
			String saveRealPath = savePath + "/" + DateUtils.getInstance().getFormatDate();

			board.setAtchId(atchId);
			board.uploadFiles(saveRealPath);

			for(AtchVO atch : board.getAtchList()) {
				atch.setAtchId(atchId);
				atch.setRgstId(rgstId);
				atch.setAtchPath(saveRealPath);
				this.atchDao.insertAtch(atch);
			}
		}
	}

	// 게시판 삭제
	@Transactional
	@Override
	public void removeBoard(BoardVO board) {
		// 게시판 첨부파일 삭제
		List<AtchVO> atchList = board.getAtchList();
		if(atchList != null && atchList.size() > 0) {
			for(AtchVO atch : atchList) {
				this.atchDao.deleteAtch(atch);
			}
		}

		// 게시판 댓글 삭제
		this.cmntDao.deleteCmntAll(board.getBoardNo());
		// 게시판 삭제
		this.boardDao.deleteBoard(board);
	}

	// 게시판 수정
	@Transactional
	@Override
	public void modifyBoard(BoardVO board) {
		log.info("수정 게시판: {}", board);
		// 첨부파일 삭제가 있는 경우
		if(board.getDelSeq().length > 0) {
			String atchId = board.getAtchId();

			AtchVO atch = null;
			for(int atchSeq : board.getDelSeq()) {
				atch = new AtchVO();
				atch.setAtchId(atchId);
				atch.setAtchSeq(atchSeq);
				this.atchDao.deleteAtch(atch);
			}
		}

		// 추가된 첨부파일이 있는 경우
		uploadProcess(board);

		// 수정
		this.boardDao.updateBoard(board);
	}


}
