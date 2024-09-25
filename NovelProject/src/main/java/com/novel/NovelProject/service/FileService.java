package com.novel.NovelProject.service;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.novel.NovelProject.dto.FileDto;
import com.novel.NovelProject.mapper.FileMapper;

@Service
public class FileService {

	public static final String FILEPATH = "c:\\upload";
	
	@Autowired
	FileMapper mapper;
	
	
	public int regFile(MultipartRequest mr, FileDto file) {
		int res=0;
		Enumeration<String> e = mr.getFileNames();
		int idx = 0;
		while(e.hasMoreElements()) {
			String elname = (String)e.nextElement();
			String oname = mr.getFilesystemName(elname);
			if(oname == null) {
				continue;
			}
			String sname = rename(oname);
			file.setIdx(idx);
			file.setOfile_name(oname);
			file.setSfile_name(sname);
			
			// file 테이블에 등록
			res = mapper.regFile(file);
			idx++;
		}
		//있는파일 모두 받아와서 이름바꿔주는 처리 후 파일테이블에 인서트
		return res;
	}

	
	
	
	
	public String rename(String fileName) {
		String frontName = fileName.substring(0, fileName.lastIndexOf('.'));
		String endName = fileName.substring(fileName.lastIndexOf('.'));
		String now = new SimpleDateFormat("_yyyyMMdd_HmsS").format(new Date());
		String NewFileName = frontName+now+endName;
		File oldFile = new File(FILEPATH+ File.separator+fileName);
		File newFile = new File(FILEPATH+ File.separator+NewFileName); 
		oldFile.renameTo(newFile);
		
		return NewFileName;
	}




	// detailEpi/Ser 이미지 가져오기
	public List<FileDto> getFile(@Param("type") String type, @Param("type_id") String type_id) {
		List<FileDto> list = mapper.getFile(type, type_id);
		
		return list;
	}

	
	



	public int delfile(@Param("episodes") String type, @Param("type_id") String type_id) {
		int res = 0;
		List<FileDto> list = getFile(type, type_id);
		for(FileDto file : list) {
			String filepath = FileService.FILEPATH + File.separator+ file.getSfile_name();
			File realfile = new File(filepath);
			realfile.delete();
			res = mapper.delFile(type, type_id);
		}
		return res;
	}
	
}
