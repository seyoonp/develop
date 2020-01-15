package com.varzac.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.varzac.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Autowired 
	private EmailService emailService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@RequestMapping(value = "/sampleSend", method = RequestMethod.GET)
	public String send(HttpServletRequest request, Model model) {
		
		// RequestMapingHandler로 부터 받은 Locale 객체를 출력해 봅니다. 
		logger.info("sample mail send {}.");
		this.emailService.sampleSendEmail(
				"박세윤"
				, "seyoonp@gmail.com"
				, "seyoonp@gmail.com"
				, "환영합니다.");
		
		model.addAttribute("result", "SUCCESS");
		
		return "jsonView";
	}
}