<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시리즈 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="resources/css/main.css"  rel="stylesheet">

<!-- js파일로 따로 분리시 EL언어를 인식 못함. -->
<script type="text/javascript">
	window.addEventListener('load', function(){
		insertBtn.addEventListener('click', function(){
			location.href='/insertSer';
		});
		
		// 게시물 제목 클릭시 해당 게시물 회차 목록 페이지로 이동
		let trList = document.querySelectorAll('tr'); 
		trList.forEach(function(item){
		    item.addEventListener('click', function(){
	            let num = item.dataset.no;
	         	if('${param.pageNo}'== null){
	         		location.href='/detailSer?series_id='+num+'&pageNo=1';
	         	}else{
	            	location.href='/detailSer?series_id='+num+'&pageNo=${map.pageDto.pageNo}';
	         	}
		    });
		});
	});
	function go(pageNo){
		searchForm.pageNo.value = pageNo;
		searchForm.submit();
	}
</script>
</head>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<body>
<div id="container">
	<h1>시리즈 목록</h1>
	<form action="/serList" name="searchForm" id="searchForm">
		<div class="input-group" id="numList">
			<div class="col-2">
				<select name="searchField" class="form-select" id="inputGroupSelect04" aria-label="Example select with button addon">
					<option value="category_name" ${param.searchField eq 'category_name' ? 'selected':''}>장르</option>
					<option value="user_id" ${param.searchField eq 'user_id' ? 'selected':''}>작가</option>
					<option value="title" ${param.searchField eq 'title' ? 'selected':''}>제목</option>
				</select>
			</div>
			<div class="col-5">
				<input name="searchWord" id="searchWord"value="${param.searchWord }" type="search" class="form-control">
			</div>
			<div class="text-end">
				<button onclick='go(1)' class="btn btn-outline-secondary" type="submit">검색</button>
			</div>
			<div class="col-1">
				<input type="hidden" name="pageNo" id="pageNo" value="${param.pageNo }">
			</div>	
			<div style="float: right" class="col-3">
				<select name="amount" class="form-select" id="amountSelect">
					<option value="5" ${param.amount eq '5' ? 'selected':''}>5개씩 보기</option>
					<option value="10" ${param.amount eq '10' ? 'selected':''} selected>10개씩 보기</option>
					<option value="15" ${param.amount eq '15' ? 'selected':''}>15개씩 보기</option>
				</select>
			</div>
		</div>	
	</form>
		
	<table class="table table-striped table-hover" id="serTable">
		<thead>
		    <tr>
			    <th scope="col">목록</th>
			    <th scope="col">장르</th>
			    <th scope="col">제목</th>
			    <th scope="col">줄거리</th>
			    <th scope="col">작가</th>
		    </tr>
		</thead>
		<tbody>
			<c:forEach items="${map.list }" var="series">
				<tr data-no="${series.series_id }">
					<th scope="row">${series.rn }</th>
					<td>${series.category_name }</td>
					<td>${series.title }</td>
					<td>${series.description }</td>
					<td>${series["user_id"]}</td>
				</tr>
			</c:forEach>
	 	</tbody>
	</table>
<div class="text-end" id="regSer">
	<button id="insertBtn" type="button" class="btn btn-secondary" >시리즈 등록하기</button>		        
</div>
</div>
<hr>
<%@include file="/WEB-INF/views/common/pageNavi.jsp" %>
</body>
<script type="text/javascript" src="resources/js/serList.js"></script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</html>