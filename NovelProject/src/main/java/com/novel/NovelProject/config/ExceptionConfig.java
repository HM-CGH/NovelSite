package com.novel.NovelProject.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("msg", "예외 사항이 발생했습니다. 관리자에게 확인해주세요. : " + e.getMessage());
		
		return "/common/msgBox";
	}
}
