package com.varzac.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.varzac.dto.HelloDto;
import com.varzac.service.HelloService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
		
	@Autowired
	private HelloService helloService;
	
	@Value("#{config['system.boolean.local']}")
	private String local;

	@RequestMapping("/board/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/form");
		return mv;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<HelloDto> list = helloService.searchBoard();
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value="/board/multiUpload", method=RequestMethod.POST, produces="text/plain")
    public ModelAndView multiUpload(MultipartHttpServletRequest request) throws Exception {
		
        // 응답용 객체를 생성하고, jsonView 를 사용하도록 합니다.
		ModelAndView model = new ModelAndView("jsonView");
		Iterator<String> iter =  request.getFileNames();
		Map<String, Object> json = new HashMap<String, Object>();
		
        if(iter.hasNext()) {
        	// 단일 파일 업로드
        	// MultipartFile multi = request.getFile(iter.next());
        	
            // 멀티 파일 업로드
            for(MultipartFile multi : request.getFiles(iter.next())) {
            	// 파일 정보 출력
            	logger.info(":: Original :: " +  multi.getOriginalFilename());
            	logger.info(":: New :: " + multi.getName());
            	logger.info(":: Size :: " +  multi.getSize());
            	
            	// 특정결로에 파일 전송
                File file = new File("D:\\PROJECT\\STUDY_PROJECT\\upload\\" + multi.getOriginalFilename());
                multi.transferTo(file);
            }
            
            json.put("code", "true");
            model.addObject("result", json);
        } else {
            json.put("code", "false");
            model.addObject("result", json);
        }
        return model;
    }
	
	@RequestMapping("/board/json")
	public ModelAndView json(Model model) {
		ModelAndView mv = new ModelAndView();
		List<HelloDto> list = helloService.searchBoard();
		mv.addObject("list", list);
		mv.setViewName("jsonView");
		return mv;
	}
}