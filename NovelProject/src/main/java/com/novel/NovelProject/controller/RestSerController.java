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
import org.springframework.web.bind.annotation.RestController;

import com.novel.NovelProject.dto.CriteriaDto;
import com.novel.NovelProject.dto.SerDto;
import com.novel.NovelProject.service.SerService;

@RestController
public class RestSerController {

	
	@Autowired
	SerService ser;
	
	
	// 시리즈 아이디로 에피소드 목록 가져오기. 단 페이지 등등은 필요없음 
	@PostMapping(value="/findEpiNum")
	public  ResponseEntity<String> findEpiNum(@RequestBody SerDto serDto) {
		// series_id 정보 가져가서 해당되는 epi list 조회해서 map에 담기. 회차검색위해 검색어 필요.
		
		int msg = ser.findEpiNum(serDto);
		System.out.println("restcon-msg"+msg);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "applcation/json; charset=UTF-8");
		String jsonMsg = "{\"msg\":\""+msg+"\"}";
		
		return new ResponseEntity<String>(jsonMsg, header, HttpStatus.OK ); 
	}
	
	
	@GetMapping(value="/resEpiList")
	public  ResponseEntity<Map<String, Object>> resEpiList(@RequestBody CriteriaDto cri, Model model) {
		// series_id 정보 가져가서 해당되는 epi list 조회해서 map에 담기. 회차검색위해 검색어 필요.
		
		Map<String, Object> map = ser.getEpiList(cri);
		model.addAttribute("map", map);
		
		
		return ResponseEntity.ok(map); 
	}
}
