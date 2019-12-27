package com.varzac.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloVo extends BaseVo implements Serializable {
	
	private static final long serialVersionUID = -7386474958681710123L;
	private String idx;
	private String title; 
	private String content;
}