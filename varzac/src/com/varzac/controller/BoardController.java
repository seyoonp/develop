package com.varzac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varzac.service.BoardService;
import com.varzac.vo.HelloVo;
import com.varzac.vo.NoticeVo;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
		
	@Autowired
	private BoardService boardService;
	
	@Value("#{config['system.boolean.local']}")
	private String local;
	
	@Value("#{config['file.upload.path']}")
	private String fileUploadPath;

	@RequestMapping("/board/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/form");
		return mv;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<HelloVo> list = boardService.searchBoard();
		mv.addObject("boarList", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping("/board/json")
	public ModelAndView json(Model model) {
		ModelAndView mv = new ModelAndView();
		List<HelloVo> list = boardService.searchBoard();
		mv.addObject("list", list);
		mv.addObject("fileUploadPath", fileUploadPath);
		mv.setViewName("jsonView");
		return mv;
	}
	
	@RequestMapping("/board/registBoard")
	public String registHello(@ModelAttribute("helloVO") HelloVo helloVO, @ModelAttribute("noticeVO") NoticeVo noticeVO, Model model,  HttpServletRequest request) {
		//helloService.insertBoard(helloVO);
		boardService.insertBoard(helloVO);
		return "redirect:list";
	}
}