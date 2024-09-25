package com.novel.NovelProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value="/main")
	public String MainPage() {
		
		return "/main";
		
	}
	
	@GetMapping(value="/myPage")
	public String myPage() {
		
		return "/user/myPage";
	}
	
}
