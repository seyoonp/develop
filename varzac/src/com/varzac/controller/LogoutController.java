package com.varzac.controller;

import javax.servlet.http.HttpServletRequest;
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
public class LogoutController {
	
	@Value("#{config['app.session.attrName']}")
	private String SESSION_NAME;
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	@RequestMapping(value="/logout/proc")
    public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(SESSION_NAME);
        return "redirect:/login/form"; // 로그아웃 후 로그인화면으로 이동
    }
}