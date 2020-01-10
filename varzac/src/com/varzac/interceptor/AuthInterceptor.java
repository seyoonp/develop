package com.varzac.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Value("#{config['app.session.attrName']}")
	private String SESSION_NAME;
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	private void saveDestination(HttpServletRequest request) {
		String uri= request.getRequestURI();
		String query = request.getQueryString();
		
		if(query.isEmpty() == true) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		if(request.getMethod().equals("GET")) {
			logger.info("desctination : " + (uri + query));
			request.getSession().setAttribute("desctination", (uri + query));
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession httpSession = request.getSession();
		
		if(httpSession.getAttribute(SESSION_NAME) != null) {
			logger.info("current user is not logged");
			saveDestination(request);
			response.sendRedirect("/login/form");
			return false;
		}
		return true;
	}
}