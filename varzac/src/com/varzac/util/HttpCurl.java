package com.varzac.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

/** API 통신을 하기 위한 클래스, HttpURLConnection 클래스를 이용한다. (nb_bo의 HttpCurl 클래스를 이용하여 생성)
 * @author 방영호
 */
public class HttpCurl 
{
	/** HTTP 통신을 수행하는 메소드
	 *  @param targetUrl 통신하고자 하는 대상의 URL
	 *  @param method HTTP 통신에 사용될 메소드
	 *  @param header Request의 Header에 삽입될 항목, KEY/VALUE 형식의 Hashtable 객체
	 *  @param body Request의 Body에 삽입될 항목
	 *  @return HTTP 통신의 결과의 HttpResponse 객체로 반환
	 *  @exception IOException HTTP 통신 실패 시 해당 예외가 발생
	 * */
	public HttpResponse httpConnection(String targetUrl, String method, Hashtable<String, String> header, String body) throws IOException 
	{
		URL url = null;
		HttpURLConnection conn = null;
	    BufferedReader bufferedReader = null;
	    OutputStreamWriter streamWriter = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    String charset = "UTF-8";
	    
	    if(targetUrl == null || targetUrl.isEmpty() == true)
	    {
	    	throw new IllegalArgumentException("Parameter targetUrl is null.");
	    }
	    
	    try 
	    {
	    	url = new URL(targetUrl);
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);	// POST, PUT
	        conn.setDoInput(true);	// GET
	        
	        // header 설정
	        if(header != null)
	        {
	        	Enumeration<String> headerKeys = header.keys();
		        while (headerKeys.hasMoreElements())
		        {
		        	String key = headerKeys.nextElement();
		        	conn.setRequestProperty(key, header.get(key));
		        }
	        }
	        
	        if (header == null || header.get("Content-Type") == null) 
	        {
	        	 conn.setRequestProperty("Content-Type", "application/json");
	        }
	        
	        if (header == null || header.get("Accept") == null) 
	        {
	        	conn.setRequestProperty("Accept", "application/json");
	        }
	        
	        if (header == null || header.get("Cache-Control") == null) 
	        {
	        	conn.setRequestProperty("Cache-Control", "no-cache");
	        }
	        
	        if(method == null || method.isEmpty() == true)
	        {
	        	method = "GET";
	        }
	        
	        conn.setRequestMethod(method);
	        
	        // method가 POST인 경우에만 실행
	        // POST인 경우에 대해서만  Request Body에 전송하고자 하는 데이터를 실어서 보낼 수 있음 (HTTP 규약)
        	if (method.equalsIgnoreCase("POST") && body != null && body.isEmpty() == false)
        	{
        		streamWriter = new OutputStreamWriter(conn.getOutputStream(), charset);
        		streamWriter.write(body);
        		streamWriter.flush();
        	}
	        
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
                String tempString = null;
                while ((tempString = bufferedReader.readLine()) != null) 
                {
                    stringBuilder.append(tempString + "\n");
                }
            }
            
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setResponseCode(conn.getResponseCode());
            httpResponse.setResponseMessage(conn.getResponseMessage());
            httpResponse.setResponseBody(StringUtils.defaultString(stringBuilder.toString()));
            
            return httpResponse;
	    }
	    finally
	    {
	    	if(bufferedReader != null)
	    	{
	    		bufferedReader.close();
	    	}
            
	    	if(streamWriter != null)
	    	{
	    		streamWriter.close();
	    	}
	    	
            if (conn != null) 
            {
            	conn.disconnect();
            }
	    }
	}
}
