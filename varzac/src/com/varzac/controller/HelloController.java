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

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.varzac.dto.HelloDto;
import com.varzac.dto.NoticeDto;
import com.varzac.service.HelloService;
import com.varzac.service.NoticeService;

@Controller
@RequestMapping("/event")
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		List<HelloDto> list = helloService.searchBoard();
		mv.addObject("list", list);
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping("/helloTiles")
	public ModelAndView helloTiles() {
		ModelAndView mv = new ModelAndView();
		List<HelloDto> list = helloService.searchBoard();
		mv.addObject("list", list);
		mv.setViewName("helloTiles");
		return mv;
	}
	
	@RequestMapping("/helloForm")
	public ModelAndView helloForm() {
		ModelAndView mv = new ModelAndView();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.KOREA);
		String formattedDate = dateFormat.format(date);
		mv.addObject("serverTime", formattedDate);
		mv.setViewName("helloForm");
		return mv;
	}
	
	@RequestMapping("/noticeForm")
	public ModelAndView noticeForm() {
		ModelAndView mv = new ModelAndView();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.KOREA);
		String formattedDate = dateFormat.format(date);
		mv.addObject("serverTime", formattedDate);
		mv.setViewName("noticeForm");
		return mv;
	}
	
	/**
	 * @param helloDto
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/registHello")
	public String registHello(@ModelAttribute("helloDto") HelloDto helloDto, @ModelAttribute("noticeDto") NoticeDto noticeDto, Model model,  HttpServletRequest request) {
		//helloService.insertBoard(helloDto);
		noticeService.insertHelloNotice(helloDto, noticeDto);
		return "redirect:hello";
	}
	
	@RequestMapping("/registHello1")
	public String registHello1(HttpServletRequest request) {
		HelloDto helloDto = new HelloDto();
		helloDto.setTitle(request.getParameter("title"));
		helloDto.setContent(request.getParameter("content"));
		helloService.insertBoard(helloDto);
		return "redirect:hello";
	}
	
	@RequestMapping("/registHello2")
	public String registHello2(@RequestParam String title, String content) {
		HelloDto helloDto = new HelloDto();
		helloDto.setTitle(title);
		helloDto.setContent(content);
		helloService.insertBoard(helloDto);
		return "redirect:hello";
	}
}
