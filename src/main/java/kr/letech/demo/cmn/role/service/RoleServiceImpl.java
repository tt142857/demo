package kr.letech.demo.cmn.role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.letech.demo.cmn.role.dao.RoleDAO;
import kr.letech.demo.cmn.role.vo.RoleVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

	private final RoleDAO roleDAO;

	@Override
	public List<RoleVO> retrieveRoleList(String memId) {
		return roleDAO.selectRoleList(memId);
	}

	@Override
	public void createDefaultRole(String memId) {
		roleDAO.insertDefaultRole(memId);
	}

}
