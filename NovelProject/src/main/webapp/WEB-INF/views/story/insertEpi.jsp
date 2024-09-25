<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록하기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="resources/css/insert.css"  rel="stylesheet">
<script type="text/javascript" src="/resources/js/insertEpi.js"></script>
</head>
<body>
<div id="signEpi">
	<h1>글 등록하기</h1>
	<hr class="my-4">
		<form class="row g-3" action="/insertEpiAction" name="insertEpiForm" enctype="multipart/form-data" method="post">
			<div id="msg"></div>
			  <div class="col-6">
				  <select name="series_id" class="form-select" id="series_id" aria-label="Example select with button addon">
					  	<option value="" selected>시리즈 이름을 선택해주세요</option>
					  	<c:forEach items="${list }" var="ser">
					  		<option value="${ser.series_id }">${ser.title }</option>
					  	</c:forEach>
				  </select>
				</div>
			    <div class="col-sm-3" >
			    	<button type="button" class="btn btn-secondary" id="insertNewSer">새 이야기 만들기</button>
			  	</div>
			  	<div class="col-sm-3">
			  	</div>
			    <div class="col-sm-2">
			  		<input name="episode_num" type="text" class="form-control" id="episode_num" placeholder="회차" readonly>
			  	</div>
				<div class="col-sm-7">
			   		<input name="title" type="text" class="form-control" id="title" value="" placeholder="제목" required>
			  	</div>
			   	<div class="col-sm-12">
			   		<textarea name="content" id="content" rows="40" cols="100" wrap="hard" placeholder="내용을 입력해주세요. " required></textarea>
			  	</div>
			 	<hr>
				<div class="col-6">
				 <h4>썸네일을 등록해주세요. </h4> 
			  		<h6>**썸네일 미등록시, 기본이미지가 적용됩니다. </h6>
				    <input  type="file" class="form-control" id="uploadFile" name="uploadFile">
				</div>
			  <div class="col-12">
			    <button id="insertEpiBtn" class="btn btn-secondary">등록하기</button>
			  </div>
		</form>
	</div>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>