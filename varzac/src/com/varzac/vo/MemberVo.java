package com.varzac.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVo extends BaseVo {
	
	private static final long serialVersionUID = 8167325169902514702L;
	
	private String loginId;
	private String loginPwd;
	private String name;
	private String no;
	private String email;
}