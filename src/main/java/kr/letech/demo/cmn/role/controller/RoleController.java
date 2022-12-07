package kr.letech.demo.cmn.role.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.letech.demo.cmn.base.BaseController;
import kr.letech.demo.cmn.role.service.RoleService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RoleController extends BaseController {

	private RoleService roleService;

	@GetMapping("/admin/role")
	public String roleList() {
		return "admin/roleList.base";
	}
}
