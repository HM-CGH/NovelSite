<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작품 상세보기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="resources/css/detailSer.css"  rel="stylesheet">
</head>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<script type="text/javascript">
	window.addEventListener('load', function(){
		insertBtn.addEventListener('click', function(){
			location.href='/insertEpi';
		})
		let trList = document.querySelectorAll('tr'); 
		trList.forEach(function(item){
		    item.addEventListener('click', function(e){
		    	e.preventDefault();
	    		let num = item.dataset.no;
	    		if(num == null){
	    		}else{
	            	location.href='/detailEpi?episode_id='+num+'&pageNo=${param.pageNo}';
	    		}
		    })
		})
	})
	function go(pageNo){
		searchForm.pageNo.value = pageNo;
		searchForm.submit();
	}
</script>
<body>
<div id="container">
	<h1>작품 상세보기</h1>
	<table  class="table" >
		<tr>
			<td rowspan="5" id="table_thumb">
				<c:choose>
	   				<c:when test="${empty map.FList }">
	   					<img alt="썸네일" src="../resources/img/기본이미지.PNG"  class="imgBox">
	   				</c:when>
	   				<c:otherwise>
		   				<c:forEach items="${map.fileList }" var="file">
		   					<img alt="썸네일" src="/downLoad?ofile_name=${file.ofile_name }&sfile_name=${file.sfile_name} " class="imgBox">
		   				</c:forEach>
	   				</c:otherwise>
	   			</c:choose>	
			</td>
		</tr>
		<tr>
			<td class="text-start align-middle">${map.serDto.title }</td>
		</tr>
		<tr>
			<td class="text-start align-middle">${map.cateDto.category_name }</td>
		</tr>
		<tr>
			<td class="text-start align-middle">${map.serDto.user_id }</td>
		</tr>
		<tr>
			<td class="text-start align-middle">${map.serDto.description }</td>
		</tr>
	</table>
	<form action="/detailSer" name="searchForm" id="searchForm">
		<div class="input-group" id="searchList">
			<div class="col-2">
			  <select name="searchField" id="searchField" class="form-select"  aria-label="Example select with button addon">
				<option value="episode_num" ${param.searchField eq 'episode_num' ? 'selected':''}>회차</option>
				<option value="title" ${param.searchField eq 'title' ? 'selected':''}>제목</option>
			  </select>
			</div>
			<div class="col-5">
				<input name="searchWord" id="searchWord" value="${param.searchWord }" type="search" class="form-control" >
			</div>
			<div class="text-end">
				<button onclick='go(1)' class="btn btn-outline-secondary" type="submit">검색</button>
			</div>
			<div class="col-1">
				<input type="hidden" name="pageNo" id="pageNo" value="${param.pageNo }">
				<input type="hidden" name="series_id" id="series_id"value="${param.series_id }">
			</div>	
			<div id="numList" class="col-3">
				<select name="amount" class="form-select" id="amount">
					<option value="5" ${param.amount eq '5' ? 'selected':''}>5개씩 보기</option>
					<option value="10" ${param.amount eq '10' ? 'selected':''} selected>10개씩 보기</option>
					<option value="15" ${param.amount eq '15' ? 'selected':''}>15개씩 보기</option>
				</select>
			</div>
		</div>	
	</form>
	
	<table class="table table-striped">
	  <thead>
		  <tr>
			  <th scope="col">회차</th>
			  <th scope="col">제목</th>
			  <th scope="col">작성자</th>
			  <th scope="col">작성일</th>
			  <th scope="col">조회수</th>
		  </tr>
	  </thead>
		<tbody id="tbody">
			<c:forEach items="${map.list }" var="episodes">
				<tr data-no="${episodes.episode_id }" >
				    <th scope="row">${episodes.episode_num }</th>
				    <td>${episodes.title }</td>
				    <td>${episodes.user_id}</td>
				    <td>${episodes.created_date }</td>
				    <td>${episodes.counts }</td>
				</tr>
			</c:forEach>
	 	</tbody>
	</table>
<div class="text-end" id="regBtn">
	<button id="insertBtn" type="button" class="btn btn-secondary" >새 이야기 등록하기</button>		        
</div>
</div>
<hr> 
<%@include file="/WEB-INF/views/common/pageNavi.jsp" %>
</body>
<script type="text/javascript" src="resources/js/detailSer.js"></script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</html>