package com.varzac.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloDto {
	private String idx;
	private String title; 
	private String content; 
	private String insId;
	private Date insDate; 
	private String uptId;
	private Date uptDate;
}