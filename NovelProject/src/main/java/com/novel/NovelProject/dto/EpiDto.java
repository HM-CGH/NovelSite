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
	
	
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getEpisode_id() {
		return episode_id;
	}
	public void setEpisode_id(String episode_id) {
		this.episode_id = episode_id;
	}
	public String getSeries_id() {
		return series_id;
	}
	public void setSeries_id(String series_id) {
		this.series_id = series_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEpisode_num() {
		return episode_num;
	}
	public void setEpisode_num(int episode_num) {
		this.episode_num = episode_num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getSer_title() {
		return ser_title;
	}
	public void setSer_title(String ser_title) {
		this.ser_title = ser_title;
	}
	
	
	
	
	
	
	
}
