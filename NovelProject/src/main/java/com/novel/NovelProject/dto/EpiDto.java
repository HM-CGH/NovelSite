package com.novel.NovelProject.dto;

import org.springframework.stereotype.Component;

import lombok.Data;




@Component
@Data
public class EpiDto {

	private int rn;
	private String episode_id;
	private String series_id; // 한글로 변환한 시리즈 아이디 
	private String user_id;
	private String title;
	private int episode_num;
	private String content;
	private String created_date;
	private int counts;
	private String ser_title;
	
}
