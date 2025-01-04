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
	
	
	
	
	public String getAttachment_id() {
		return attachment_id;
	}
	public void setAttachment_id(String attachment_id) {
		this.attachment_id = attachment_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getOfile_name() {
		return ofile_name;
	}
	public void setOfile_name(String ofile_name) {
		this.ofile_name = ofile_name;
	}
	public String getSfile_name() {
		return sfile_name;
	}
	public void setSfile_name(String sfile_name) {
		this.sfile_name = sfile_name;
	}
	public String getUploaded_date() {
		return uploaded_date;
	}
	public void setUploaded_date(String uploaded_date) {
		this.uploaded_date = uploaded_date;
	}
	
	
	
	
	
	
	
}
