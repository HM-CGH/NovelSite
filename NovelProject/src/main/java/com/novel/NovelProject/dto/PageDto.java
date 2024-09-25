package com.novel.NovelProject.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {
	
	private int startNo;		//페이지 블럭의 시작번
	private int endNo;			//페이지 블럭의 끝번호
	private int realEndNo; 		//전체게시물 수로 구한 진짜 끝번호. endNo, next를 설정하는데 필요한 값.
	private boolean prev, next;	//페이지 블럭을 이동하기 위한 버튼
	
	//페이지 블럭을 그리기 위한 값을 설정하기 위해 필요한 값.
	int totalCnt; 		//전체 게시물수
	int pageNo;			//사용자가 요청한 페이지 번호
	int amount; 		//페이지 당 보여줄 게시물 수
	
	
	
	
	
	
	/**
	 * 생성자를 이용해서 페이지블럭을 초기화한다.
	 * 
	 */
	
	public PageDto(int totalCnt, int pageNo, int amount) {
		
		this.totalCnt = totalCnt;
		this.pageNo = pageNo;
		this.amount = amount;
		
	
		endNo = (int) (Math.ceil(pageNo/5.0)*5); 
		startNo = endNo - (5-1);
		realEndNo = (int) Math.ceil((totalCnt*1.0)/amount);
		
		endNo = endNo>realEndNo? realEndNo : endNo;
		
		prev = startNo > 1 ? true : false;
		next = endNo == realEndNo ? false : true;
		
	}

	
	public void setPageDto(int totalCnt, int pageNo, int amount) {
		
		this.totalCnt = totalCnt;
		this.pageNo = pageNo;
		this.amount = amount;
		
		
		endNo = (int) (Math.ceil(pageNo/5.0)*5); 
		startNo = endNo - (5-1);
		realEndNo = (int) Math.ceil((totalCnt*1.0)/amount);
		
		endNo = endNo>realEndNo? realEndNo : endNo;
		
		prev = startNo > 1 ? true : false;
		next = endNo == realEndNo ? false : true;
		
	}




	public int getStartNo() {
		return startNo;
	}


	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}





	public int getEndNo() {
		return endNo;
	}





	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}





	public int getRealEndNo() {
		return realEndNo;
	}





	public void setRealEndNo(int realEndNo) {
		this.realEndNo = realEndNo;
	}





	public boolean isPrev() {
		return prev;
	}





	public void setPrev(boolean prev) {
		this.prev = prev;
	}





	public boolean isNext() {
		return next;
	}





	public void setNext(boolean next) {
		this.next = next;
	}





	public int getTotalCnt() {
		return totalCnt;
	}





	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}





	public int getPageNo() {
		return pageNo;
	}





	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}





	public int getAmount() {
		return amount;
	}





	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
}
