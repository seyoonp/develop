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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.varzac.service.BoardService;
import com.varzac.vo.LoginVo;
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
	
	@RequestMapping("/login/proc")
	public void proc(LoginVo loginVo, HttpSession httpSession, ModelAndView mv) {
		
		String hashedPwd = BCrypt.hashpw(loginVo.getLoginPwd(), BCrypt.gensalt());
		loginVo.setLoginPwd(hashedPwd);
		
		// MemberVo memberVo = memberService.loginProc();
		MemberVo memberVo = null;
		if(memberVo == null || !BCrypt.checkpw(loginVo.getLoginPwd(), memberVo.getLoginPwd())) {
			mv.addObject("result", "FAIL");
		} else {
			mv.addObject("memberVo", memberVo);
			mv.addObject("result", "SUCCESS");
		}
		
		mv.setViewName("jsonView");
	}
}