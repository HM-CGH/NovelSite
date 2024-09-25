<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에피소드 목록</title>
<link href="resources/css/main.css"  rel="stylesheet">
</head>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<script type="text/javascript">
window.addEventListener('load', function(){
	insertBtn.addEventListener('click', function(){
		location.href='/insertEpi';
	})
	let trList = document.querySelectorAll('tr');
	trList.forEach(function(item){
		item.addEventListener('click', function(){
			let no = item.dataset.no;
			location.href='/detailEpi?episode_id='+no+'&pageNo=${map.pageDto.pageNo}';
		})
	})	
})
function go(pageNo){
	searchForm.pageNo.value = pageNo;
	searchForm.submit();
}
</script>
<body>
<div id="containerEpi">
	<h1>최신글 목록</h1>
	<form action="/epiList" name="searchForm" id="searchForm">
		<div class="input-group" id="numList">
			<div class="col-2">
				<select name="searchField" class="form-select" id="searchField" aria-label="Example select with button addon">
					<option value="series_id" ${param.searchField eq 'series_id' ? 'selected':''}>시리즈명</option>
					<option value="title" ${param.searchField eq 'title' ? 'selected':''}>제목</option>
					<option value="all" ${param.searchField eq 'all' ? 'selected':''}>시리즈명&제목</option>
				</select>
			</div>
			<div class="col-5">
				<input name="searchWord" value="${param.searchWord }" type="search" class="form-control" >
			</div>
			<div class="text-end">
				<button onclick='go(1)' class="btn btn-outline-secondary" type="submit">검색</button>
			</div>
			<div class="col-1">
				<input type="hidden" name="pageNo" value="${param.pageNo }">
			</div>	
			<div style="float: right" class="col-3">
				<select name="amount" class="form-select" id="amountSelect">
					<option value="10" ${param.amount eq '10' ? 'selected':''}>10개씩 보기</option>
					<option value="15" ${param.amount eq '15' ? 'selected':''}>15개씩 보기</option>
				</select>
			</div>
		</div>	
	</form>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">시리즈명</th>
				<th scope="col">회차</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody >
		  <c:choose>
			<c:when test="${empty map.list }">
				<tr>
					<td colspan="7">조회된 게시물이 없습니다.</td>
				</tr>	
			</c:when>
			<c:otherwise>
				<c:forEach items="${map.list }" var="episodes">
					<tr data-no="${episodes.episode_id }">
						<th scope="row">${episodes.rn }</th>
						<td style="width: 200px">${episodes.series_id }</td>
						<td>${episodes.episode_num }</td>
						<td>${episodes.title }</td>
						<td>${episodes.user_id}</td>
						<td>${episodes.counts}</td>
						<td>${episodes.created_date }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		  </c:choose>
	 	</tbody>
	</table>
<div class="text-end" id="regSer">
	<button id="insertBtn" type="button" class="btn btn-secondary" >글 등록하기</button>		        
</div>
</div>
<hr>
<%@include file="/WEB-INF/views/common/pageNavi.jsp" %>
</body>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</html>

</body>
</html>