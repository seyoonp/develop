package com.varzac.interceptor;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ConfigHandlerInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private Properties config;
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigHandlerInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
					Object handler, 
						ModelAndView modelAndView) throws Exception {
		if(modelAndView != null) {
			logger.info("config", config);
			logger.info("modelAndView", modelAndView);
			modelAndView.addObject("config", config);
		}
	}
}