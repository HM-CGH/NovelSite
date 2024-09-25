package com.novel.NovelProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.novel.NovelProject.dto.EpiDto;
import com.novel.NovelProject.dto.UserDto;

@Mapper
public interface UserMapper {

	
	
	
	public UserDto getUser(UserDto userDto);

	
	@Select("select * from users where user_id = #{user_id}")
	public UserDto checkId(UserDto userDto);


	public int insertUser(UserDto userDto);

	@Select("select * from users where user_name=#{user_name} and email = #{email}")
	public UserDto findId(UserDto user);

	@Select("select * from users where user_name=#{user_name} and email = #{email} and user_id=#{user_id}")
	public UserDto findPw(UserDto user);

	
	
	
}
