package com.novel.NovelProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.novel.NovelProject.dto.FileDto;

@Mapper
public interface FileMapper {

	
	public int regFile(FileDto file);

	public List<FileDto> getFile(@Param("type") String type, @Param("type_id") String type_id);

	public int delFile(@Param("type") String type, @Param("type_id") String type_id);
	
	// 메인페이지에 띄울 top6 에피소드의 썸네일 가져오기 
	public List<FileDto> getMainFile();

	
	
	
}
