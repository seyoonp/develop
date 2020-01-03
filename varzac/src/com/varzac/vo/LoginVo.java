package com.varzac.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVo extends BaseVo {
	
	private static final long serialVersionUID = -1801249399369291357L;
	
	private String loginId;
	private String loginPwd; 
}