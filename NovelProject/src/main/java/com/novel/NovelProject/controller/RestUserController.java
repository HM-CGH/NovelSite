package com.novel.NovelProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.novel.NovelProject.dto.CriteriaDto;
import com.novel.NovelProject.dto.EpiDto;
import com.novel.NovelProject.dto.UserDto;
import com.novel.NovelProject.service.UserService;

@RestController
public class RestUserController {

	@Autowired
	UserService ser;
	
	
	
	@PostMapping(value="/findId")
	public ResponseEntity<String> findId(@RequestBody UserDto user){
		String msg="";
		System.out.println("========="+user);
		if(user.getUser_name() == null || "".equals(user.getUser_name())
				|| user.getEmail() == null || "".equals(user.getEmail())) {
			msg="필요한 정보를 모두 입력해주세요. ";
		}else {
			UserDto res = ser.findId(user);
			if(res == null) {
				msg="조회되는 회원정보가 없습니다. ";
			}else {
				msg= "회원님의 아이디는 "+res.getUser_id() + "입니다. ";
			}
		}
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "applcation/json; charset=UTF-8");
		String jsonMsg = "{\"msg\":\""+msg+"\"}";
		
		return new ResponseEntity<String>(jsonMsg, header, HttpStatus.OK );
	}
	
	
	
	@PostMapping(value="/findPw")
	public ResponseEntity<String> findPw(@RequestBody UserDto user){
		String msg="";
		System.out.println("========="+user);
		if(user.getUser_name() == null || "".equals(user.getUser_name())
				|| user.getEmail() == null || "".equals(user.getEmail())
				|| user.getUser_id() == null || "".equals(user.getUser_id())) {
			msg="필요한 정보를 모두 입력해주세요. ";
		}else {
			UserDto res = ser.findPw(user);
			if(res == null) {
				msg="조회되는 회원정보가 없습니다. ";
			}else {
				msg= "회원님의 아이디는 "+res.getUser_id() + "입니다. ";
			}
		}
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "applcation/json; charset=UTF-8");
		String jsonMsg = "{\"msg\":\""+msg+"\"}";
		
		return new ResponseEntity<String>(jsonMsg, header, HttpStatus.OK );
	}
	
	
	
	@GetMapping("/checkId")
	public ResponseEntity<String> checkId(UserDto userDto) {
		System.out.println(userDto.getUser_id());
		String msg = "";
		UserDto user = ser.checkId(userDto);
		System.out.println("userDto : " + userDto.getUser_id());
		if(user == null) {
			msg = "";
			//model.addAttribute("msg", msg);
		}else {
			msg="중복되는 아이디 입니다. ";
			//model.addAttribute("msg", msg);
		}
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "applcation/json; charset=UTF-8");
		String jsonMsg = "{\"msg\":\""+msg+"\"}";
		
		return new ResponseEntity<String>(jsonMsg, header, HttpStatus.OK);
	}
	
	
	
	
	
}
