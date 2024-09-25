package com.novel.NovelProject.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FileDto {

	private String attachment_id;
	private String type;
	private String type_id;
	private int idx;
	private String ofile_name;
	private String sfile_name;
	private String uploaded_date;
	
}
