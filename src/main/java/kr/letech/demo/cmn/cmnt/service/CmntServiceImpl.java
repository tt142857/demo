package kr.letech.demo.cmn.cmnt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.letech.demo.cmn.cmnt.dao.CmntDAO;
import kr.letech.demo.cmn.cmnt.vo.CmntVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CmntServiceImpl implements CmntService {

	private final CmntDAO cmntDAO;

	@Override
	public void createCmnt(CmntVO cmnt) {
		this.cmntDAO.insertCmnt(cmnt);
	}

	@Override
	public void modifyCmnt(CmntVO cmnt) {
		this.cmntDAO.updateCmnt(cmnt);
	}

	@Override
	public void removeCmnt(CmntVO cmnt) {
		this.cmntDAO.deleteCmnt(cmnt);
	}

	@Override
	public List<CmntVO> retrieveBoardOneCmntList(int boardNo) {
		return this.cmntDAO.selectBoardOneCmntList(boardNo);
	}

	@Override
	public String retrieveBoardOneCmntRgstId(CmntVO cmnt) {
		return this.cmntDAO.selectBoardOneCmntRgstId(cmnt);
	}

}
