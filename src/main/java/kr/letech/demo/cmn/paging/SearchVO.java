package kr.letech.demo.cmn.paging;

import kr.letech.demo.cmn.base.BaseVO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchVO extends BaseVO {

	private static final long serialVersionUID = -2733927085845475071L;

	private String searchType;
	private String searchWord;
}
