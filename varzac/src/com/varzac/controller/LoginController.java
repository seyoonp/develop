package com.varzac.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.varzac.service.BoardService;
import com.varzac.vo.LoginDto;
import com.varzac.vo.MemberVo;

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
	
	@RequestMapping(value = "/login/proc", method = RequestMethod.POST)
	public void proc(LoginDto loginVo, HttpSession httpSession, Model model) {
		/*
		String hashedPwd = BCrypt.hashpw(loginVo.getLoginPwd(), BCrypt.gensalt());
		loginVo.setLoginPwd(hashedPwd);
		MemberVo memberVo = memberService.loginProc();		
		if(memberVo == null || !BCrypt.checkpw(loginVo.getLoginPwd(), memberVo.getLoginPwd())) {
			mv.addObject("result", "FAIL");
		} else {
			mv.addObject("memberVo", memberVo);
			mv.addObject("result", "SUCCESS");
		}
		*/
		
		/*
		String loginPwd = loginVo.getLoginPwd();
		if(loginPwd == null || loginPwd.equals("1234")) {
			MemberVo memberVo = new MemberVo();
			memberVo.setLoginId("sampleId");
			memberVo.setUserName("sample name");
			model.addAttribute("memberVo", memberVo);
			model.addAttribute("result", "00");
			model.addAttribute("message", "메인 화면으로 이동합니다.");
		} else {
			model.addAttribute("result", "01");
			model.addAttribute("message", "ID 또는 비밀번호가 일치하지 않습니다.");
		}
		return "jsonView";
		*/
		
		String loginPwd = loginVo.getLoginPwd();
		if(loginPwd == null || loginPwd.equals("1234")) {
			MemberVo memberVo = new MemberVo();
			memberVo.setLoginId("sampleId");
			memberVo.setUserName("sample name");
			model.addAttribute("memberVo", memberVo);
		}
	}
	
	@RequestMapping("/login/securityForm") 
	public ModelAndView securityForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login/securityForm");
		return mv;
	}
}