package com.novel.NovelProject.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.novel.NovelProject.dto.CateDto;
import com.novel.NovelProject.dto.CriteriaDto;
import com.novel.NovelProject.dto.EpiDto;
import com.novel.NovelProject.dto.FileDto;
import com.novel.NovelProject.dto.PageDto;
import com.novel.NovelProject.dto.SerDto;
import com.novel.NovelProject.dto.UserDto;
import com.novel.NovelProject.mapper.SerMapper;

@Service
public class SerService {
	
	@Autowired
	SerMapper mapper;
	
	@Autowired
	FileService fileService;
	
	
	// 시리즈 목록조회
	public Map<String, Object> getSerList(CriteriaDto cri) {
		Map<String, Object> map = new HashMap<String, Object>();
		int totalCnt = mapper.totalCnt(cri);
		PageDto pageDto = new PageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		map.put("pageDto", pageDto);
		map.put("list", mapper.getSerList(cri));
		return map;
	}
	
	// 에피소드 목록 조회
	public Map<String, Object> getEpiList(CriteriaDto cri) {
		Map<String, Object> map = new HashMap<String, Object>();
		int totalEpiCnt = mapper.totalEpiCnt(cri);
		PageDto pageDto = new PageDto(totalEpiCnt, cri.getPageNo(), cri.getAmount());
		List<EpiDto> list = mapper.getEpiList(cri);
		map.put("list", list);
		map.put("pageDto", pageDto);
		return map;
	}
	

	// 사용자가 작성한 시리즈 목록 조회
	public List<SerDto> getUserSerList(UserDto user) {
		List<SerDto> list = mapper.getUserSerList(user);
		return list;
	}

	
	// 에피소드 등록 with 파일
	public Map<String, Object> insertEpi(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String Direct = "c:\\upload";
		int maxSize = 1024*1000;
		String encoding = "UTF-8";
		try {
			MultipartRequest mr = new MultipartRequest(request, Direct, maxSize, encoding);
			EpiDto epiDto = new EpiDto();
			epiDto.setSeries_id(mr.getParameter("series_id"));
			epiDto.setEpisode_num(Integer.parseInt(mr.getParameter("episode_num")));
			epiDto.setTitle(mr.getParameter("title"));
			String content = mr.getParameter("content");
			epiDto.setContent(mr.getParameter("content"));
			int regEpires = mapper.regEpi(epiDto);
			
			System.out.println("SerService, epiDto : "+ epiDto);
			
			
			FileDto file = new FileDto();
			file.setType("episodes");
			file.setType_id(epiDto.getEpisode_id());
			int regFileres = fileService.regFile(mr, file);
			if(regEpires > 0 && regFileres>0) {
				map.put("msg", "처리성공");
			}
		} catch (IOException e) {
			
		}
		return map;
	}

	// 카테고리 조회
	public List<CateDto> getCate() {
		return mapper.getCate();
	}

	
	// 시리즈 등록 with 파일
	public Map<String, Object> insertSer(HttpServletRequest request, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		String Direct = "c:\\upload";
		int maxSize = 1024*1000;
		String encoding = "UTF-8";
		try {
			MultipartRequest mr = new MultipartRequest(request, Direct, maxSize, encoding);
			SerDto serDto = new SerDto();
			UserDto user = (UserDto) session.getAttribute("userDto"); // 세션에 등록된 로그인 정보
			
			serDto.setCategory_id(mr.getParameter("category_id"));
			serDto.setUser_id(user.getUser_id());
			serDto.setTitle(mr.getParameter("title"));
			serDto.setDescription(mr.getParameter("description"));
			
			// series 테이블 업데이트(selectKey 적용)
			int regEpires = mapper.regSer(serDto);
			System.out.println("SerService serDto : " + serDto);
			
			// file 테이블 업데이트
			FileDto file = new FileDto();
			file.setType("series");
			file.setType_id(serDto.getSeries_id());
			int regFileres = fileService.regFile(mr, file);
			if(regEpires > 0 && regFileres>0) {
				map.put("msg", "처리성공");
			}
		} catch (IOException e) {
			
		}
		return map;
	}
	
	
	// 시리즈별 에피소드 조회
	public Map<String, Object> getSerEpiList(String series_id, @Param("cri") CriteriaDto cri) {
		Map<String, Object> map = new HashMap<String, Object>();
		SerDto serDto = mapper.getSerDto(series_id); // 시리즈 정보 가져오기
		List<FileDto> Flist = fileService.getFile("series", serDto.getSeries_id()); // series 이미지 가져오기
		List<EpiDto> list =  mapper.getSerEpiList(series_id, cri);
		CateDto cateDto = mapper.getCateName(series_id);
		int lastNum = 0;
		if(mapper.getSerEpiNum(series_id) ==0) {
			lastNum = 0;
		}else {
			lastNum = mapper.getSerEpiNum(series_id);
		}
		int totalCnt = mapper.totalSerEpiCnt(series_id, cri);
		PageDto pageDto = new PageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		map.put("cateDto", cateDto);
		map.put("serDto", serDto);
		map.put("Flist", Flist);
		map.put("lastNum", lastNum);
		map.put("list", list);
		map.put("pageDto", pageDto);
		
		return map;
	}
	
	// 에피소드 상세조회
	public Map<String, Object> getDetailEpi(String episode_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		EpiDto epiDto = mapper.getDetailEpi(episode_id);
		int res = mapper.upCount(episode_id);
		List<FileDto> list = fileService.getFile("episodes", epiDto.getEpisode_id());
		int lastNum = 0;
		if((int)mapper.getSerEpiNum(epiDto.getSeries_id()) ==0) {
			lastNum = 0;
		}else {
			lastNum = mapper.getSerEpiNum(epiDto.getSeries_id());
		}
		map.put("lastNum", lastNum);
		map.put("epiDto", epiDto);
		map.put("fileList", list);
		return map;
	}

	// 에피소드 업데이트
	public Map<String, Object> updateEpi(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int resFile = 0;
		String Direct = "c:\\upload";
		int maxSize = 1024*1000;
		String encoding = "UTF-8";
		try {
			MultipartRequest mr = new MultipartRequest(request, Direct, maxSize, encoding);
			if(mr.getFile("uploadFile")== null || !mr.getFile("uploadFile").exists()) {
				resFile=1;
			}else {
				
				resFile = fileService.delfile("episodes", mr.getParameter("episode_id"));
				System.out.println("mr.getParameter(\"episode_id\") : " + mr.getParameter("episode_id"));
			}
			
			EpiDto epiDto = new EpiDto();
			epiDto.setEpisode_id(mr.getParameter("episode_id"));
			epiDto.setSeries_id(mr.getParameter("series_id"));
			epiDto.setTitle(mr.getParameter("title"));
			epiDto.setEpisode_num(Integer.parseInt(mr.getParameter("episode_num")));
			String content = mr.getParameter("content");
			epiDto.setContent(mr.getParameter("content"));
			
			
			// series 테이블 업데이트(selectKey 적용)
			int resEpi = mapper.updateEpi(epiDto);
			System.out.println("SerService serDto : " + epiDto);
			
			
			FileDto file = new FileDto();
			file.setType("episodes");
			file.setType_id(epiDto.getEpisode_id());
			
			// file 테이블 업데이트
			int regFileres = fileService.regFile(mr, file);
			if(resEpi > 0 && regFileres>0 && resFile >0) {
				map.put("msg", "처리성공");
			}
			
		} catch (IOException e) {
			
		}
		return map;
	}
	
	
	// 에피소드 삭제
	public Map<String, Object> delEpi(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int resFile = 0, resEpi = 0;
		String Direct = "c:\\upload";
		int maxSize = 1024*1000;
		String encoding = "UTF-8";
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(request, Direct, maxSize, encoding);
			System.out.printf("mr.getParameter(episode_id) : ", mr.getParameter("episode_id"));
			resFile = fileService.delfile("episodes", mr.getParameter("episode_id"));
			resEpi = mapper.delEpi(mr.getParameter("episode_id"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if( resFile == 1 && resEpi == 1) {
			map.put("comment", "삭제성공");
		}
		return map;
	}

	
	// 새 글 작성시 에피소드 회차 조회하기 위한 메서드
	public int findEpiNum(SerDto serDto) {
		System.out.println("serservice finedpinum seris_id"+serDto);
		int res = 1;
		if(mapper.findEpiNum(serDto)==null || mapper.findEpiNum(serDto)==0) {
			res=1;
		}else {
			res = mapper.findEpiNum(serDto)+1; // 회차만 담겨있음 
		}
		return res;
	}
	
	// 에피소드 아이디로 시리즈 아이디만 구하기
	public String getSeries(String episode_id) {
		String series = "";
		if(mapper.getSeries(episode_id) != null) {
			series= mapper.getSeries(episode_id);
		}
		return series;
	}
	
	// 시리즈 아이디와 회차로 이전회차 불러오기
	public EpiDto getPrevEpi(String series_id, int episode_num) {
		EpiDto epi = mapper.getPrevEpi(series_id, episode_num);
		return epi;
	}

	// 시리즈 아이디와 회차로 다음회차 불러오기
	public EpiDto getNextEpi(String series_id, int episode_num) {
		EpiDto epi = mapper.getNextEpi(series_id, episode_num);
		System.out.println("service-epi : "+epi);
		return epi;
	}

	
	
	
	
}
