package com.varzac.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	private String loginId;
	private String loginPwd; 
	private boolean useCookie;
}