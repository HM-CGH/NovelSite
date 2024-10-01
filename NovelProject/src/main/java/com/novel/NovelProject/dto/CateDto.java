package com.novel.NovelProject.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CateDto {

	private String category_id;
	private String category_name;
	
}
