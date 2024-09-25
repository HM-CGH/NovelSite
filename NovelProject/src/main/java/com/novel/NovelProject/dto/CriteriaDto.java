package com.novel.NovelProject.dto;

import org.springframework.stereotype.Component;

@Component
public class CriteriaDto {

	private int pageNo=1; // 요청 페이지 번호
	private int amount=10; // 페이지당 보여줄 게시물의 수
	
	private String searchField =""; // 검색필드
	private String searchWord ="";  // 검색어
	
	
	
	public CriteriaDto() {}
	
	public CriteriaDto(String parmPageNo) {
		try {
			if(parmPageNo != null && !"".equals(parmPageNo)) {
				this.pageNo = Integer.parseInt(parmPageNo);
			}
		} catch (Exception e) {
			System.out.println("parmPageNo를 숫자로 변경하던 도중 예외가 발생하였습니다.");		
		}
	}

	
	public CriteriaDto(String parmPageNo, String parmAmount) {
		try {
			if(parmPageNo != null && !"".equals(parmPageNo)
					&& parmAmount!=null && !"".equals(parmAmount)) {
				this.pageNo = Integer.parseInt(parmPageNo);
				this.amount = Integer.parseInt(parmAmount);
				
				System.out.println(this.amount);
			}
		} catch (Exception e) {
			System.out.println("parmPageNo를 숫자로 변경하던 도중 예외가 발생하였습니다.");		}
		

	}


	public CriteriaDto(String parmPageNo, String parmAmount, String searchField, String searchWord) {
		//생성자 호출
		this(parmPageNo, parmAmount);
		this.searchField = searchField;
		this.searchWord = searchWord;
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
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	
}
