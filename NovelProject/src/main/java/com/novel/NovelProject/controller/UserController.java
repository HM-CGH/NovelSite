package com.novel.NovelProject.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novel.NovelProject.dto.UserDto;
import com.novel.NovelProject.service.UserService;
import com.novel.NovelProject.util.CookieManager;

@Controller
public class UserController {
	
	
	@Autowired
	UserService ser;
	
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	
	@GetMapping(value="/login")
	public String login(Model model,  @CookieValue(name="saveId", required = false) String saveCookieId ) {
			model.addAttribute("saveId", saveCookieId);
			return "/login/login";
		}


	
	@PostMapping(value="/loginAction")
	public String loginAction(UserDto userDto, Model model, HttpSession session, RedirectAttributes rttr
							, @RequestParam(value ="saveId", required=false) String saveId
							, HttpServletResponse response, HttpServletRequest request) {
		UserDto user = ser.getUser(userDto);
		if("Y".equals(saveId)) {
			CookieManager.makeCookie(response, "saveId", userDto.getUser_id(), 60*60*24*7);
		}else {
			CookieManager.deleteCookie(response, "saveId");
		}
		
		if(user != null) {
			session.setAttribute("userDto", user);
			rttr.addFlashAttribute("msg", "");
			return "redirect:/main";
		}else {
			rttr.addFlashAttribute("msg", "로그인 정보가 일치하지 않습니다. ");
			rttr.addFlashAttribute("saveId", userDto.getUser_id());
			return "redirect:/login";
		}
	}
	
	
	
	
	
	@GetMapping(value="/signup")
	public String signup() {
		return "/login/signup";
		
	}
	
	
	
	
	
	
	@GetMapping(value="/signupAction")
	public String insertUser(UserDto userDto, Model model) {
		int res = ser.insertUser(userDto);
		if(res>0) {
			model.addAttribute("msg", userDto.getUser_id()+"님, 가입이 완료되었습니다.");
			model.addAttribute("url", "/login");
		}else {
			model.addAttribute("msg", "회원가입에 실패했습니다. 다시 시도해주세요. ");
		}
		return "/common/msgBox";
	}
	
	
	
	@GetMapping(value="/writeEpi")
	public String writeEpi() {
		
		return "/story/writeStory";
	}
	
	
	
	@GetMapping(value="/NewFile")
	public String newfile() {
		
		return "/common/NewFile";
	}
	
	
	
}
