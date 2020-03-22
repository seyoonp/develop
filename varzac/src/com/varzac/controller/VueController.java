package com.varzac.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VueController {
	
	private static final Logger logger = LoggerFactory.getLogger(VueController.class);
		
//	@Autowired
//	private BoardService boardService;
	
	@Value("#{config['system.boolean.local']}")
	private String local;
	
	@Value("#{config['file.upload.path']}")
	private String fileUploadPath;

	@RequestMapping("/vue/Lifecycle")
	public ModelAndView Lifecycle() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/vue/Lifecycle");
		return mv;
	}
	
	@RequestMapping("/vue/Component")
	public ModelAndView Component() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/vue/Component");
		return mv;
	}
}