package com.varzac.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileVo extends BaseVo {
	private String fileIdx;
	private String orgFileName;
	private String saveFileName;
	private String savePath;
	private String useYn;
}