package com.novel.NovelProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novel.NovelProject.dto.CateDto;
import com.novel.NovelProject.dto.CriteriaDto;
import com.novel.NovelProject.dto.EpiDto;
import com.novel.NovelProject.dto.SerDto;
import com.novel.NovelProject.dto.UserDto;
import com.novel.NovelProject.mapper.SerMapper;
import com.novel.NovelProject.service.SerService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class SerController {

	@Autowired
	SerService ser;
	
	@Autowired
	SerMapper mapper;
	
	// 최신업데이트(에피소드) 목록으로 이동
	@GetMapping(value="/epiList")
	public String getEpiList(Model model, CriteriaDto cri) {
		Map<String, Object> map = ser.getEpiList(cri);
		model.addAttribute("map", map);
		return "/story/epiList";
	}
	
	
	// 시리즈 목록으로 이동
	@GetMapping(value="/serList")
	public String getSerList(Model model, CriteriaDto cri) {
		Map<String, Object> map = ser.getSerList(cri);
		model.addAttribute("map", map);
		return "/story/serList";
	}
	
	// 에피소드 등록페이지 이동
	@GetMapping(value="/insertEpi")
	public String insertEpi(Model model, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("userDto");
		if(user != null) {
			// 로그인한 사용자가 작성한 시리즈 리스트로 조회 후 출력 
			List<SerDto> list = ser.getUserSerList(user);
			model.addAttribute("list", list);
			return "/story/insertEpi";
		} else {
			model.addAttribute("msg", "로그인이 필요한 기능입니다. ");
			model.addAttribute("url", "/login");
			return "/common/msgBox";
		}
	}
	
	// 시리즈 등록페이지로 이동
	@GetMapping(value="/insertSer")
	public String insertSer(HttpSession session, Model model) {
		// 로그인한 사용자 정보가 있어야 시리즈 등록 페이지로 이동 가능
		UserDto user = (UserDto) session.getAttribute("userDto");
		if(user != null) {
			List<CateDto> list = ser.getCate();
			model.addAttribute("list", list);
			return "/story/insertSer";
		} else {
			model.addAttribute("msg", "로그인이 필요한 기능입니다. ");
			model.addAttribute("url", "/login");
			return "/common/msgBox";
		}
	}
	
	// 파일첨부된 에피소드 등록 후 메세지박스로 이동. 
	@PostMapping(value="/insertEpiAction")
	public String insertEpiAction(HttpServletRequest request, Model model) {
		Map<String, Object> map = ser.insertEpi(request);
		if(map != null) {
			model.addAttribute("msg", "등록이 완료되었습니다. ");
			model.addAttribute("url", "/epiList");
		}else {
			model.addAttribute("msg", "등록 실패. 다시 확인해주세요. ");
		}
		return "/common/msgBox";
		
	}
	
	// 파일첨부된 시리즈 등록 후 메세지 박스로 이동(사용자 정보 꺼내오기 위해 Session 매개변수 등록)
	@PostMapping(value="/insertSerAction")
	public String insertSerAction(HttpServletRequest request, HttpSession session, Model model) {
		Map<String, Object> map = ser.insertSer(request, session);
		if(map != null) {
			model.addAttribute("msg", "등록이 완료되었습니다. ");
			model.addAttribute("url", "/serList");
		}else {
			model.addAttribute("msg", "등록 실패. 다시 확인해주세요. ");
		}
		return "/common/msgBox";
	}
	
	
	// 시리즈 목록 클릭 > 시리즈회차목록으로 이동
	@GetMapping(value="/detailSer")
	public String detailSer(CriteriaDto cri, @RequestParam("series_id") String series_id, Model model) {
		// series_id 정보 가져가서 해당되는 epi list 조회해서 map에 담기. 회차검색위해 검색어 필요.
		//System.out.println("cri.getSearchField : "+ cri.getSearchField());
		Map<String, Object> map = ser.getSerEpiList(series_id, cri);
		model.addAttribute("map", map);
		return "/story/detailSer"; //이걸 redirect:/detailSer로 보내봐 
	}
	
	
	
	// 에피소드 상세보기 (에피소드 일련번호로 에피소드 DTO 조회해서 반환)
	@GetMapping(value="/detailEpi")
	public String detailEpi(@RequestParam("episode_id") String episode_id, Model model) {
		Map<String, Object> map = ser.getDetailEpi(episode_id);
		model.addAttribute("map", map);
		return "/story/detailEpi";
	}
	
	// 기존 에피소드 내용 화면에 출력
	@GetMapping(value="/updateEpi")
	public String updateEpi(@RequestParam("episode_id") String episode_id, Model model) {
		Map<String, Object> map = ser.getDetailEpi(episode_id);
		model.addAttribute("map", map);
		return "/story/updateEpi";
	}
	
	
	// 에피소드 업데이트 (파일 재첨부 가능, 기존 차일은 삭제처리)
	@PostMapping(value="/updateEpiAction")
	public String updateEpiAction(Model model, HttpServletRequest request) {
		Map<String, Object> map = ser.updateEpi(request);
		if(map != null) {
			model.addAttribute("msg", "수정이 완료되었습니다. ");
			model.addAttribute("url", "/epiList");
		}else {
			model.addAttribute("msg", "수정 실패. 다시 시도해주세요. ");
		}
		return "/common/msgBox";
	}
	
	
	// 에피소드 삭제
	@PostMapping(value="/delEpi")
	public String delEpi(Model model, HttpServletRequest request) {
		Map<String, Object> map = ser.delEpi(request);
		if(map != null) {
			model.addAttribute("msg", "삭제가 완료되었습니다. ");
			model.addAttribute("url", "/epiList");
		}else {
			model.addAttribute("msg", "수정 실패. 다시 시도해주세요. ");
		}
		return "/common/msgBox";
	}
	
	// 에피소드 이전화 보기 -- episode_id 이용해서 series_id 구하고 리스트 구해오기> 리스트에서 episode_num -1 한 것 찾기 
	@GetMapping(value="/detailPrev")
	public String dePrev(@RequestParam("episode_id") String episode_id, @RequestParam("episode_num") int episode_num, Model model) {
		String series_id = ser.getSeries(episode_id);
		System.out.println("sereis_id : "+series_id);
		EpiDto epi = ser.getPrevEpi(series_id, episode_num);
		System.out.println("epi : "+epi);
		int res = mapper.upCount(epi.getEpisode_id());
		Map<String, Object> map = new HashMap<String, Object>();
		int lastNum = 0;
		if(mapper.getSerEpiNum(series_id) ==0) {
			lastNum = 0;
		}else {
			lastNum = mapper.getSerEpiNum(series_id);
		}
		map.put("lastNum", lastNum);
		map.put("epiDto", epi);
		model.addAttribute("map", map);
		return "/story/detailEpi";
	}
	
	@GetMapping(value="/detailNext")
	public String deNext(@RequestParam("episode_id") String episode_id, @RequestParam("episode_num") int episode_num, Model model) {
		String series_id = ser.getSeries(episode_id);
		// System.out.println("sereis_id : "+series_id);
		EpiDto epi = ser.getNextEpi(series_id, episode_num);
		System.out.println("epi : "+epi);
		int res = mapper.upCount(epi.getEpisode_id());
		Map<String, Object> map = new HashMap<String, Object>();
		int lastNum = 0;
		if(mapper.getSerEpiNum(series_id) ==0) {
			lastNum = 0;
		}else {
			lastNum = mapper.getSerEpiNum(series_id);
		}
		map.put("lastNum", lastNum);
		map.put("epiDto", epi);
		model.addAttribute("map", map);
		
		return "/story/detailEpi";
	}
	
	
}
