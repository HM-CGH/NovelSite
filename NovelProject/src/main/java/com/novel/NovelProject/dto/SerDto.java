package com.novel.NovelProject.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SerDto {

	private int rn;
	private String series_id;
	private String category_name;
	private String category_id;
	private String user_id;
	private String title;
	private String description;
	private String created_date;
	
}
