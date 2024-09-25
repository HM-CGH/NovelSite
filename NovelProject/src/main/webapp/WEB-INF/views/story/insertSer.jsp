<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>새로운 이야기 만들기</title>
<script type="text/javascript" src="/resources/js/insert.js"></script>
<link href="resources/css/insert.css"  rel="stylesheet">
</head>
<body>
<div id="sign">
	<h1>새로운 시리즈 등록하기</h1>
	<hr class="my-4">
		<form class="row g-3" action="/insertSerAction" name="insertSerForm" enctype="multipart/form-data" method="post">
			<div id="msg"></div>
			<div class="col-4">
				<select name="category_id" id="category_id" class="form-select"  aria-label="Example select with button addon">
					<option value="" selected>장르를 선택해주세요</option>
						<c:forEach items="${list }" var="cate">
					  		<option value="${cate.category_id }">${cate.name }</option>
					  	</c:forEach>
				</select>
			</div>
		 	<div class="col-sm-6">
			</div>
		  	
		    <div class="col-sm-6">
		  		<input name="title" id="title" type="text" class="form-control"  placeholder="시리즈 제목" required>
		  	</div>			
			<div class="col-sm-10">
		   		<textarea name="description" id="description" rows="6"  class="form-control" id="description" value="" placeholder="줄거리를 입력해주세요. " required></textarea>
		  	</div>
		 	<hr>
			<div class="col-10">
				<h4>시리즈의 대표 썸네일을 등록해주세요. </h4> 
		  		<h6>*썸네일 미등록시, 기본이미지가 적용됩니다. </h6>
			    <input  type="file" class="form-control" id="uploadFile" name="uploadFile">
			</div>
			<div class="col-2">
			</div>
		    <div class="col-12">
		    	<button id="insertSerBtn" class="btn btn-secondary">등록하기</button>
		    </div>
		</form>
	</div>
</body>
<%@include file="../common/footer.jsp" %>
</html>