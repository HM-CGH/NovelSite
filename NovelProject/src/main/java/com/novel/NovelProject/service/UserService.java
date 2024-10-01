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
import com.novel.NovelProject.dto.FileDto;
import com.novel.NovelProject.dto.UserDto;
import com.novel.NovelProject.mapper.FileMapper;
import com.novel.NovelProject.mapper.SerMapper;
import com.novel.NovelProject.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;
	
	@Autowired
	SerMapper Emapper;
	
	@Autowired
	FileMapper Fmapper;
	
	@Autowired
	BCryptPasswordEncoder encoder; 
	
	
	//회원가입처리
	public int insertUser(UserDto userDto) {
		String newPW = encoder.encode(userDto.getPassword()); // 비밀번호 암호화
		userDto.setPassword(newPW);	// 암호화한 비밀번호 적용
		int num = mapper.insertUser(userDto); // 적용한 회원정보 DB에 삽입
		return num;
	}
	
	
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

	

	// 아이디 찾기
	public UserDto findId(UserDto user) {
		return mapper.findId(user);
	}

	// 비밀번호 찾기
	public UserDto findPw(UserDto user) {
		return mapper.findPw(user);
	}

	// 메인페이지의 에피소드 조회수 top6 가져오기
	public Map<String, Object> getMainPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EpiDto> Elist = Emapper.getMainPage();
		List<FileDto> Flist = Fmapper.getMainFile(); 
		map.put("Elist", Elist);
		map.put("Flist", Flist);
		
		return map;
	}


	


	
}
