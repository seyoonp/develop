package com.varzac.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseVo implements Serializable {
	
	private static final long serialVersionUID = 4683917947554815888L;
	
	private String insId;
	private Date insDate; 
	private String uptId;
	private Date uptDate;
}