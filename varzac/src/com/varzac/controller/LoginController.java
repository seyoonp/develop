package com.varzac.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varzac.service.BoardService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Value("#{config['app.session.attrName']}")
	private String sessionName;
	
	@Value("#{config['file.upload.path']}")
	private String fileUploadPath;

	@RequestMapping("/login/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login/form");
		return mv;
	}
	
	@RequestMapping("/login/proc")
	public String proc() {
		
		
		return "redirect:/board/list";
	}
}