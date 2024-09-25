<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style type="text/css">
	#sign{
		width: 700px;
		height: 900px;
		margin: 0px auto;
		margin-top: 100px;
	
	}
</style>
</head>
<script type="text/javascript" src="/resources/js/signup.js"></script>
<body>
<div id="sign">
	
	<h1>회원가입</h1>
	 <hr class="my-4">
		<form class="row g-3" action="/signupAction" name="checksignForm">
			  <div id="msg">
			  </div>
			  
			  <div class="col-sm-5">
				  <label for="inputId" class="form-label">아이디</label>
				  <input name="user_id" value="" type="text" class="form-control" id="inputId" required>
			  </div>
			  
			  <div class="col-sm-2" >
				  <label for="inputIdBtn" class="form-label" style="visibility: hidden">ddd</label>
				  <button type="button" class="form-control" id="inputIdBtn">중복확인</button>
			    <!-- <input type="button" class="form-control" id="inputIdBtn" value="중복확인"> -->
			  </div>
			   
				<!-- style="visibility: hidden;" -->
			  <div class="col-sm-5" style="visibility: hidden" >
				  <label for="checkIdTxt" class="form-label">아이디 중복 체크 : 1</label>
				  <input type="text" class="form-control" id="checkIdTxt" value="">
			  </div>
			  <div class="col-sm-5">
				  <label for="inputPassword" class="form-label" >비밀번호</label>
				  <input name="password" type="password" class="form-control" id="inputPassword" required>
			  </div>
			   <div class="col-sm-5">
				  <label for="inputPasswordCheck" class="form-label">비밀번호 확인</label>
				  <input type="password" class="form-control" id="inputPasswordCheck">
			  </div>
			  <div class="col-8">
				  <label for="inputEmail" class="form-label" required>이메일</label>
				  <input name="email"type="email" class="form-control" id="inputEmail" >
			  </div>
			  <div class="col-5">
				  <label for="inputName" class="form-label" required>이름</label>
				  <input name="user_name" type="text" class="form-control" id="inputName" >
			  </div>
			
			  <div class="col-12">
			    <div class="form-check">
			      <input class="form-check-input" type="checkbox" id="gridCheck">
			      <label class="form-check-label" for="gridCheck">
			        Check me out
			      </label>
			    </div>
			  </div>
			  <div class="col-12">
			    <button id="signupBtn" class="btn btn-primary">Sign up</button>
			  </div>
		</form>
	</div>
	
<%@include file="/WEB-INF/views/common/footer.jsp" %>	

</body>
</html>