package com.novel.NovelProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.novel.NovelProject.dto.CriteriaDto;
import com.novel.NovelProject.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService ser;
	
	@GetMapping(value="/main")
	public String getMainPage(Model model) {
		Map<String, Object> map = ser.getMainPage();
		model.addAttribute("map", map);
		return "/main";
		
	}
	
	@GetMapping(value="/myPage")
	public String myPage() {
		
		return "/user/myPage";
	}
	
}
