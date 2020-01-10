package com.varzac.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVo extends BaseVo {
	
	private static final long serialVersionUID = 8167325169902514702L;
	
	private int userNo;
	private String loginId;
	private String loginPwd;
	private String userName;
	private String email;
	private int userPoint;
	private String sessionKey;
	private String sessionLimit;
	private String userImgFile;
	private Date userJoinDate;
	private Date userLoginDate;
	private String userSingnature;
}