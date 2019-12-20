package com.varzac.util;

/** 웹 어플리케이션의 보안과 관련된 내용을 구현한 클래스
 *  @author 방영호
 * */
public class SecurityUtility
{
	/** 해당 문자열에 대해서 보안상 위험을 내포하는 문자열을 필터링 처리
	 *  @param str XSS 필터링 처리할 문자열
	 *  @return 필터링 처리된 문자열, 파라미터가 NULL인 경우 반환되는 값은 NULL이다.
	 * */
	public String filteringBadString(String str)
	{
		if(str != null && str.isEmpty() == false)
		{
			str = str.replaceAll("(?i)&#|&|<|>|\"|\'|'|/|document|script|iframe|object|embed|onload|expression|onmouse|select|union", "");
		}
		
		return str;
	}
	
	/** 해당 문자열이 정수 형태인지 확인
	 *  @param str 정수 형태인지 여부를 확인할 문자열
	 *  @return true 정수 형태의 문자열, false 정수 형태가 아닌 문자열, NULL 또는 빈 문자열인 경우 false를 반환한다. 
	 * */
	public boolean isNumberFormat(String str)
	{
		boolean result = false;
		
		try
		{
			Integer.parseInt(str);
			result = true;
		}
		catch(Exception e) {}
		
		return result;
	}
	
	/** 해당 문자열이 정수 형태인지 확인
	 *  @param str 정수 형태인지 여부를 확인할 문자열
	 *  @return true 정수 형태의 문자열, false 정수 형태가 아닌 문자열, NULL 또는 빈 문자열인 경우 false를 반환한다. 
	 * */
	public boolean isNumberFormat(String str, boolean allowNullOrEmpty)
	{
		boolean result = false;
		
		try
		{
			if(allowNullOrEmpty == true && (str == null || str.isEmpty() == true))
			{
				result = true;
			}
			
			Integer.parseInt(str);
			result = true;
		}
		catch(Exception e) {}
		
		return result;
	}
}