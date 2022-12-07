package kr.letech.demo.cmn.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.letech.demo.cmn.role.vo.RoleVO;

@Mapper
public interface RoleDAO {

	// 권한 조회
	public List<RoleVO> selectRoleList(String memId);

	// 권한 등록
	public void insertDefaultRole(String memId);
}
