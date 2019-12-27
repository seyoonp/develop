package com.varzac.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varzac.service.HelloService;
import com.varzac.service.NoticeService;
import com.varzac.vo.HelloVo;
import com.varzac.vo.NoticeVo;

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
		List<HelloVo> list = helloService.searchBoard();
		mv.addObject("list", list);
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping("/helloTiles")
	public ModelAndView helloTiles() {
		ModelAndView mv = new ModelAndView();
		List<HelloVo> list = helloService.searchBoard();
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
	 * @param helloVO
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/registHello")
	public String registHello(@ModelAttribute("helloVO") HelloVo helloVO, @ModelAttribute("noticeVO") NoticeVo noticeVO, Model model,  HttpServletRequest request) {
		//helloService.insertBoard(helloVO);
		noticeService.insertHelloNotice(helloVO, noticeVO);
		return "redirect:hello";
	}
	
	@RequestMapping("/registHello1")
	public String registHello1(HttpServletRequest request) {
		HelloVo helloVO = new HelloVo();
		helloVO.setTitle(request.getParameter("title"));
		helloVO.setContent(request.getParameter("content"));
		helloService.insertBoard(helloVO);
		return "redirect:hello";
	}
	
	@RequestMapping("/registHello2")
	public String registHello2(@RequestParam String title, String content) {
		HelloVo helloVO = new HelloVo();
		helloVO.setTitle(title);
		helloVO.setContent(content);
		helloService.insertBoard(helloVO);
		return "redirect:hello";
	}
}
