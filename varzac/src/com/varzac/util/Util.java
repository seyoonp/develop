package com.varzac.util;

import javax.servlet.ServletContext;

public class Util {
	
	public static CodeUtility code;
	public static DateUtility date;
	
	/**
	 * Web Application 기동시 초기화 되어야 함
	 */
	public Util(ServletContext sc) {
		Util.code = new CodeUtility();
		Util.date = new DateUtility();
	}
}