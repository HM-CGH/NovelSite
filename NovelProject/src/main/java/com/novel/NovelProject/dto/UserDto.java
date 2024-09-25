package com.novel.NovelProject.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDto {

	private String user_id;
	private String user_name;
	private String email;
	private String password;
	private String admin;
	private String created_date;
	
	
	
}
