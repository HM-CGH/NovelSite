<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style type="text/css">
	#sign{
		width: 700px;
		
		margin: 0px auto;
		margin-top: 100px;
	
	}
	
</style>
<!-- 이 페이지로 들어오려면 로그인이 되어있어야함. 세션에 저장된 로그인 정보의 아이디로 시리즈 목록 가져오기-->	
<script type="text/javascript">
window.addEventListener('load', function(){
	
	
	insertNewSer.addEventListener('click', function(){
		location.href='/insertSer';
	});
	insertEpiBtn.addEventListener('click', function(e){
		e.preventDefault();
		if(checkForm()){
			let result = confirm('게시물을 등록하시겠습니까? ');
			
            if (result) {
            	insertEpiForm.submit();
            } else {
                alert("등록이 취소되었습니다.");
               	
            }
		};
	});
});
	//무결성 검사
	function checkForm(){
	if(series_id.value =='' || series_id.value == null){
		
		alert('시리즈를 입력해주세요. ');
		return false;
	}
	if(episode_num == null){
		
		alert('회차를 입력해주세요. ');
		return false;
	}
	if(title == null || title ==''){
		
		alert('제목을 입력해주세요. ');
		return false;
	}if(content == null || content ==''){
		
		alert('내용을 입력해주세요. ');
		return false;
	}
	return true;
	}

</script>
</head>
<body>
<div id="sign">
	<h1>글 수정하기</h1>
	<hr class="my-4">
		<form class="row g-3" action="/updateEpiAction" name="insertEpiForm" enctype="multipart/form-data" method="post">
			<div id="msg"></div>
			  <div class="col-6">
				  <select name="series_id" class="form-select" id="series_id" aria-label="Example select with button addon">
					  	<option value="${map.epiDto.series_id }" selected>${map.epiDto.series_id }</option>
				  </select>
				</div>
			 
			    <div class="col-sm-3" >
			    	<button type="button" class="btn btn-secondary" id="insertNewSer">새 이야기 만들기</button>
			  	</div>
			  	<div class="col-sm-3">
			  		
			  	</div>
			    <div class="col-sm-2">
			  		<input name="episode_num" value="${map.epiDto.episode_num }" type="text" class="form-control" id="episode_num" placeholder="회차" readonly>
			  	</div>
				
				<div class="col-sm-7">
			   		<input name="title" type="text" class="form-control" id="title" value="${map.epiDto.title }" placeholder="제목" required>
			  	</div>
			  	<input name="episode_id" type="hidden" class="form-control" id="episode_id" value="${map.epiDto.episode_id }" placeholder="제목" required>
			   	<div class="col-sm-12">
			   		<textarea name="content" id="content" rows="40" cols="100" wrap="hard" placeholder="내용을 입력해주세요. " required style="overflow-y: auto" required><c:out value="${map.epiDto.content }" escapeXml = "true"/></textarea>
			  	</div>
			 	<hr>
				<div class="col-6">
				 <h4>새로운 썸네일을 등록해주세요. </h4> 
			  		<h6>**썸네일 미등록시, 기존 이미지가 적용됩니다. </h6>
				    <input  type="file" class="form-control" id="uploadFile" name="uploadFile">
				</div>
			<!-- 
			  <div class="col-12">
			    <div class="form-check">
			      <input class="form-check-input" type="checkbox" id="gridCheck">
			      <label class="form-check-label" for="gridCheck">
			        Check me out
			      </label>
			    </div>
			  </div>
			   -->
			  <div class="col-12">
			    <button id="insertEpiBtn" class="btn btn-secondary">등록하기</button>
			  </div>
		</form>
	</div>



<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>