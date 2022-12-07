package kr.letech.demo.cmn.role.service;

import java.util.List;

import kr.letech.demo.cmn.role.vo.RoleVO;

public interface RoleService {

	// 권한 목록 조회
	public List<RoleVO> retrieveRoleList(String memId);

	// 권한 등록
	public void createDefaultRole(String memId);
}
