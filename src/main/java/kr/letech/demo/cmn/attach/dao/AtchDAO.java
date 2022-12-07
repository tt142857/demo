package kr.letech.demo.cmn.attach.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.letech.demo.cmn.attach.vo.AtchVO;

@Mapper
public interface AtchDAO {

	// 첨부파일 상세 조회
	public AtchVO selectAtch(AtchVO atchVo);

	// 첨부파일 등록
	public void insertAtch(AtchVO atchVo);

	// 첨부파일 삭제
	public void deleteAtch(AtchVO atchVo);

}
