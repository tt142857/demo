package kr.letech.demo.cmn.role.vo;

import kr.letech.demo.cmn.base.BaseVO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RoleVO extends BaseVO {

	private static final long serialVersionUID = 64145025838460714L;

	private String memId;
	private String roleId;
	private String roleNm;
}
