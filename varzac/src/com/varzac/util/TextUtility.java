package com.varzac.util;

import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

public class TextUtility {

	public String nvl(Object obj, String defaultValue) {
		
		if (obj != null && !"".equals(obj)) {
			return (String)obj;
		} else {
			return defaultValue;
		}
	}
	
	/** 정수형태로 이루어진 문자열인지 검사하는 메소드
	 *  @param str 정수 형태인지 여부를 검사할 문자열
	 *  @return false : 정수 형태의 문자열, true : 정수 형태가 아닌 문자열*/
	public boolean isNaN(String str)
	{
		boolean result = false;
		
		try
		{
			Integer.parseInt(str);
		}
		catch(NumberFormatException e)
		{
			result = true;
		}
		
		return result;
	}
	
	/** 01012341234 형태의 핸드폰 번호를 {"010", "1234", "1234"} 형태의 문자배열로 나누는 메소드
	 *  @param cellNo 핸드폰 번호
	 *  @return 분할된 핸드폰번호 문자열 배열을 반환, 인자로 받은 cellNo가 null이거나 10자리 미만인 경우 null을 반환
	 * */
	public String[] divCellNo(String cellNo)
	{
		String[] result = null;
		
		if(cellNo != null && cellNo.isEmpty() == false && cellNo.length() >= 9)
		{
			result = new String [3];
			
			if(cellNo.length() == 10)
			{
				result[0] = cellNo.substring(0, 3);
				result[1] = cellNo.substring(3, 6);
				result[2] = cellNo.substring(6, 10);
			}
			else if(cellNo.length() == 9)
			{
				result[0] = cellNo.substring(0, 2);
				result[1] = cellNo.substring(2, 5);
				result[2] = cellNo.substring(5, 9);
			}
			else
			{
				result[0] = cellNo.substring(0, 3);
				result[1] = cellNo.substring(3, 7);
				result[2] = cellNo.substring(7, 11);
			}
		}
		
		return result;
	}
	
	/** 01012341234 형태의 핸드폰 번호를 010-1234-1234 형태로 변경하는 메소드<br/>
	 *  만약 seperator 인자값을 null이나 빈 문자열이 아닌 값으로 전달하면 핸드폰 번호 사이의 구분기호를 해당 문자열로 대체 가능
	 *  @param cellNo 형태를 변환할 핸드폰 번호
	 *  @param seperator 핸드폰 번호 사이에 들어갈 구분기호, null이거나 빈 문자열이면 '-'로 처리됨.
	 *  @return 형태가 변환된 핸드폰 번호 문자열을 반환, 인자로 받은 cellNo가 null이거나 10자리 미만인 경우 null을 반환
	 * */
	public String formatCellNo(String cellNo, String seperator)
	{
		String[] tempDivCellNo = this.divCellNo(cellNo);
		String result = null;
		
		if(seperator == null || seperator.equals(""))
		{
			seperator = "-";
		}
		
		if(tempDivCellNo != null && tempDivCellNo.length == 3)
		{
			result = tempDivCellNo[0];
			result += seperator + tempDivCellNo[1];
			result += seperator + tempDivCellNo[2];
		}
		
		return result;
	}
	
	/** test@ileadon.com 형식의 이메일 주소에서 아이디와 도메인을 나누는 메소드
	 *  @param email test@ileadon.com 형식의 이메일 주소 문자열
	 *  @return 아이디와 도메인 부분이 분리된 문자열 배열 반환 , email가 null이거나 빈 문자열, @ 기호가 없는 경우 null을 반환 
	 * */
	public String[] divEmail(String email)
	{
		String[] result = null;
		
		if(email != null && email.isEmpty() == false && email.indexOf("@") != -1)
		{
			result = new String [2];
			result[0] = email.substring(0, email.indexOf("@"));
			result[1] = email.substring(email.indexOf("@")+1, email.length());
		}
		
		return result;
	}
	
	/** URL의 쿼리스트링에서 특정 파라미터를 제거하는 메소드
	 *  @param url URL 문자열
	 *  @param parameterNames 쿼리스트링에서 제거할 파라미터명
	 *  @return 해당 파라미터명이 제거된 쿼리스트링 문자열 반환
	 * */
	public String removeQueryParameter(String url, String[] parameterNames)
	{
		String result = null;
		
		try
		{		
			if(url != null && parameterNames != null && parameterNames.length > 0)
			{
				if(url.indexOf("?") != 0)
				{
					url = "?" + url;
				}
				
			    URIBuilder uriBuilder = new URIBuilder(url);
			    List<NameValuePair> queryParameters = uriBuilder.getQueryParams();
			    for (Iterator<NameValuePair> queryParameterItr = queryParameters.iterator(); queryParameterItr.hasNext();) 
			    {
			        NameValuePair queryParameter = queryParameterItr.next();
			        
			        for (String parameterName : parameterNames)
			        {
			        	if (queryParameter.getName().equalsIgnoreCase(parameterName)) 
				        {
				            queryParameterItr.remove();
				        }
					}
			    }
			    uriBuilder.setParameters(queryParameters);
			    result = uriBuilder.build().toString();
			    
			    if(result != null && result.indexOf("?") != 0)
				{
			    	result = "?" + result;
				}
			}
		}
		catch(URISyntaxException e)
		{
			result = null;
		}
		
	    return result;
	}
}
