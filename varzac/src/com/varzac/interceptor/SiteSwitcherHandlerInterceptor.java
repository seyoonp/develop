package com.varzac.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SiteSwitcherHandlerInterceptor extends HandlerInterceptorAdapter
{
	@Value("#{config['system.mobile.url']}")
	private String SYSTEM_MOBILE_URL;
	
	@Value("#{config['system.mobile.exclusiveRedirectUrl']}")
	private String SYSTEM_MOBILE_EXCLUSIVEREDIRECTURL;
	
	/** Controller/Handler가 실행되기 전에 모바일 접속 유무를 체크하여 리다이렉션을 처리하는 메소드 
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		Device device = DeviceUtils.getCurrentDevice(RequestContextHolder.currentRequestAttributes());
		String redirectUrl = null;
		String exclusiveRedirectUrl = null;
		
		if(device != null)
		{
			if(device.isMobile() || device.isTablet())
			{
				exclusiveRedirectUrl = this.SYSTEM_MOBILE_EXCLUSIVEREDIRECTURL;				
				redirectUrl = this.SYSTEM_MOBILE_URL;
				
				redirectUrl += request.getRequestURI();
				
				if(request.getQueryString() != null)
				{
					redirectUrl += "?" + request.getQueryString();
				}
				
				//System.out.println("=======================================================");
				//System.out.println("redirectUrl : " + redirectUrl);
				//System.out.println("=======================================================");
				
				if(exclusiveRedirectUrl == null || exclusiveRedirectUrl.toUpperCase().indexOf(request.getRequestURI().toUpperCase()) == -1 || request.getRequestURI().equals("/") || request.getRequestURI().isEmpty())
				{
					response.sendRedirect(redirectUrl);
					return false;
				}
			}
		}
		
		return super.preHandle(request, response, handler);
	}
}