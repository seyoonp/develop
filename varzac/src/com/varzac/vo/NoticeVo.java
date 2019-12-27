package com.varzac.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVo extends BaseVo {
	private String idx;
	private String title; 
	private String content;
}