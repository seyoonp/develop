package com.varzac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varzac.dto.HelloDto;
import com.varzac.service.HelloService;

@Controller
public class BoardController {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<HelloDto> list = helloService.searchBoard();
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
}
