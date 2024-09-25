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

	
	
	
}
