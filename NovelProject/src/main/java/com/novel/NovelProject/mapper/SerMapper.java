package com.novel.NovelProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.novel.NovelProject.dto.CateDto;
import com.novel.NovelProject.dto.CriteriaDto;
import com.novel.NovelProject.dto.EpiDto;
import com.novel.NovelProject.dto.SerDto;
import com.novel.NovelProject.dto.UserDto;

@Mapper
public interface SerMapper {

	// 시리즈 조회 (최신 업데이트 순으로)
	public List<SerDto> getSerList(CriteriaDto cri);
	
	// 총 시리즈 조회
	public int totalSerListCnt(CriteriaDto cri);
	
	// 총 시리즈 조회
	public int totalCnt(CriteriaDto cri);

	// 유저가 작성한 시리즈 조회
	public List<SerDto> getUserSerList(UserDto user);

	// 에피소드 테이블에 인서트
	public int regEpi(EpiDto epiDto);

	// 카테고리 목록 조회
	@Select("select * from categories")
	public List<CateDto> getCate();
	
	// 시리즈 테이블에 인서트
	public int regSer(SerDto serDto);
	
	// 총 에피소드 조회
	public int totalEpiCnt(CriteriaDto cri);

	// 에피소드 리스트 조회
	public List<EpiDto> getEpiList(CriteriaDto cri);
	
	// 시리즈별 에피소드 조회
	public List<EpiDto> getSerEpiList(@Param("series_id")String series_id, @Param("cri") CriteriaDto cri);
	
	// 시리즈별 총 에피소드 수
	public int totalSerEpiCnt(@Param("series_id") String series_id, @Param("cri") CriteriaDto cri);

	// 에피소드 내용 조회
	public EpiDto getDetailEpi(String episode_id);
	
	// 에페소드 조회수 증가
	@Update("update episodes set counts = counts+1 where episode_id = #{episode_id}")
	public int upCount(String episode_id);

	// 에피소드 업데이트 
	public int updateEpi(EpiDto epiDto);
	
	// 에피소드 삭제
	public int delEpi(@Param("episode_id") String episode_id);

	// 시리즈 아이디로 에피소드 리스트 회차만 조회
	public Integer findEpiNum(SerDto serDto);

	// 에피소드 아이디로 시리즈 아이디만 조회
	public String getSeries(@Param("episode_id")String episode_id);
	
	// 시리즈 아이디와 에피소드 이전화 가져오기 
	public EpiDto getPrevEpi(@Param("series_id") String series_id, @Param("episode_num") int episode_num);
	
	// 다음화 가져오기
	public EpiDto getNextEpi(@Param("series_id") String series_id, @Param("episode_num") int episode_num);
	
	// 시리즈의 에피소드 갯수 가져오기 
	public int getSerEpiNum(@Param("series_id") String series_id);

	// detailSer의 시리즈정보 가져오기
	public SerDto getSerDto(String series_id);
	
	// 시리즈 아이디로 카테고리 찾아서 카테고리 이름 가져오기
	public CateDto getCateName(@Param("series_id") String series_id);

	// 메인페이지 에피소드 top6 가져오기
	public List<EpiDto> getMainPage();

	
	
	
}
