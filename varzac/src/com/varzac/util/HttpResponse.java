package com.varzac.util;

/** com.varzac.util.HttpCurl 클래스를 통해 생성되는 Response의 데이터를 담을 수 있는 VO 클래스이다.
 * 	@author 방영호
 * */
public class HttpResponse
{
	/** Response Code (200, 404, 500 등)
	 * */
	private int responseCode;
	
	/** Response Code에 따른 메시지
	 * */
	private String responseMessage;
	
	/** Response Body의 내용 
	 * */
	private String responseBody;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
}
