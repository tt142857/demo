package kr.letech.demo.cmn.board.vo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.letech.demo.cmn.attach.vo.AtchVO;
import kr.letech.demo.cmn.base.BaseVO;
import kr.letech.demo.cmn.cmnt.vo.CmntVO;
import kr.letech.demo.cmn.exception.FileUploadException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BoardVO extends BaseVO {

	private static final long serialVersionUID = 7790406301936752351L;

	private Integer boardNo;
	private String boardDiv;
	@NonNull
	private String boardTtl;
	private String boardCat;
	@NonNull
	private String boardCont;
	private String atchId;
	private String rgstId;
	private String rgstDt;
	private String updtId;
	private String updtDt;
	private String delYn;
	private Integer boardHit;

	private String boardDivNm;
	private String boardCatNm;

	private List<CmntVO> cmntList;

	private MultipartFile[] files;
	private List<AtchVO> atchList;
	private Integer[] delSeq;

	public void setFiles(MultipartFile[] files) {
		if(files == null || files.length == 0) {
			return;
		}

		this.files = files;
		this.atchList = new ArrayList<AtchVO>();
		for(int seq = 0; seq < files.length; seq++) {
			if(!files[seq].isEmpty()) {
				AtchVO atch = new AtchVO(files[seq]);
				atch.setAtchSeq(seq);
				atchList.add(atch);
			}
		}
	}

	public void uploadFiles(String savePath) {
		for(int i = 0; i < atchList.size(); i++) {
			AtchVO atch = atchList.get(i);

			File dir = new File(savePath);
			if(!dir.exists()) {
				dir.mkdirs();
			}

			String filePath = savePath + "/" + atch.getAtchSaveNm();
			try {
				files[i].transferTo(new File(filePath));
			} catch (IllegalStateException | IOException e) {
				String message = "파일 업로드 중 파일 오류 발생";
				throw new FileUploadException(message, e);
			}
		}
	}
}
