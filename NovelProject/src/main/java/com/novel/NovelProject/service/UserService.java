package com.novel.NovelProject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.novel.NovelProject.dto.EpiDto;
import com.novel.NovelProject.dto.UserDto;
import com.novel.NovelProject.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;
	
	@Autowired
	BCryptPasswordEncoder encoder; 
	
	
	//로그인처리
	public UserDto getUser(UserDto userDto) {
		UserDto user = mapper.getUser(userDto);
		if(user == null) {
			return user;
		}
		//암호화된 비밀번호 확인
		if(encoder.matches(userDto.getPassword(), user.getPassword())) {
			return user;
		}else {
			return null;
		}
	}

	
	// 아이디 중복확인
	public UserDto checkId(UserDto userDto) {
		UserDto dto = mapper.checkId(userDto);
		return dto;
	}

	//회원가입처리
	public int insertUser(UserDto userDto) {
		String newPW = encoder.encode(userDto.getPassword()); 
		userDto.setPassword(newPW);	
		int num = mapper.insertUser(userDto);
		return num;
	}

	// 아이디 찾기
	public UserDto findId(UserDto user) {
		return mapper.findId(user);
	}


	public UserDto findPw(UserDto user) {
		return mapper.findPw(user);
	}


	


	
}
