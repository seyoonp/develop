package com.varzac.controller;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.groovy.tools.shell.util.MessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.varzac.vo.HelloVo;
import com.varzac.vo.NoticeVo;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired 
	private SessionLocaleResolver localeResolver; 
	
	@Autowired 
	private MessageSource messageSource; //message-context.xml 에 선언되어있는 bean id 값
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	
}