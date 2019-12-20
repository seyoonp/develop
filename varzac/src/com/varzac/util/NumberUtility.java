package com.varzac.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class NumberUtility {
	
    /**
     * 전화번호 해당 idx 자릿수를 리턴한다.
     * 
     * @param phoneNum , idx
     * @return idx 받은 해당 위치에 결과값을 리턴 ($1 , $2 , $3)
     */
	public String makePhoneNumber(String phoneNum,String idx) {
		 
		  String regEx = "(01[016789]{1}|02|0[3-9]{1}[0-9]{1})(\\d{3,4})(\\d{4})";
	      if(!Pattern.matches(regEx, phoneNum)) { 
	    	  return null;
	      }
	      
	      return phoneNum.replaceAll(regEx, idx);
	 
	}
	
    /**
     * 천단위 이하의 값을 000으로 변환하여 리턴.
     * 
     * @param num 
     * @return String
     */	
	public String getNumberFormat(String num) {
		
		BigDecimal bd = new BigDecimal (num); 
		bd = bd.setScale(-3, BigDecimal.ROUND_DOWN);
		String pattern = "#,###";
		
		if (num == null || num.trim().equals("")){
			
			return "";
		
		}else{

			return (new DecimalFormat(pattern)).format(Double.parseDouble(bd.toString()));
		}		
	}	
	
	/** 
     * 문자열 숫자 판단
     * 숫자이면 true, 숫자가 아니면 false 반환
     * 
     * @param String 
     * @return boolean
     */	
	public boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

}
