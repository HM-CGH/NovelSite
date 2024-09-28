<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/login.css">
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="/resources/js/login.js"></script>
</head>
 <body class="d-flex align-items-center py-4 bg-body-tertiary">
 	<div class="container">
	<main class="form-signin w-100 m-auto">
	
	
	  <!-- ------------------------로그인 폼------------------------ -->
	  <form action="/loginAction" method="post" id="loginForm">
	    
	    <h1 class="h3 mb-3 fw-normal">로그인</h1>
		${msg}
	    <div class="form-floating">
	      <input name="user_id" value="${saveId}" type="text" class="form-control" id="floatingInput" >
	      <label for="floatingInput">Id</label>
	    </div>
	    <div class="form-floating">
	      <input name="password" value="" type="password" class="form-control" id="floatingPassword" >
	      <label for="floatingPassword">Password</label>
	    </div>
	
	    <div class="form-check text-start my-3">
	      <input name="saveId" ${not empty saveId ? 'checked' : '' } value="Y" class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
	      <label class="form-check-label" for="flexCheckDefault">
	        Remember me
	      </label>
	    </div>
	    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
	    <p></p>
	    <p class="text-center">
	    	<a href="javascript:findId()">아이디 찾기</a>
	    	<a href="javascript:findPw()">비밀번호 찾기</a>
	    	<a href="/signup">회원가입</a>
	    </p>
	    <hr>
	    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
	  </form>
	  
	  
	  <!-- ------------------------아이디찾기 폼------------------------ -->
	   <form action="/findId" method="post" id="findIdForm" class="none">
	    <h1 class="h3 mb-3 fw-normal">아이디 찾기</h1>
		<div id="findIdMsgBox"></div>
	    <div class="form-floating">
	      <input name="user_name"  type="text" class="form-control" id="setId_name" >
	      <label for="setId_name">이름</label>
	    </div>
	    <div class="form-floating">
	      <input name="email" value="" type="email" class="form-control" id="setId_email" >
	      <label for="setId_email">Email</label>
	    </div>
	   <p></p>
	    <p class="text-center">
	    <button class="btn btn-primary w-100 py-2" type="button" onClick="fn_findIdAction()">아이디 찾기</button>
	    	<a href="javascript:login()">로그인 하기</a>
	    	<a href="javascript:findPw()">비밀번호 찾기</a>
	    	<a href="/signup">회원가입</a>
	    </p>
	    <hr>
	    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
	  </form>
	  
	  
	  <!-- ------------------------비밀번호 찾기 폼------------------------ -->
	   <form action="/findPw" method="post" id="findPwForm" class="none">
	   <h1 class="h3 mb-3 fw-normal">비밀번호 찾기</h1>
			<div id="findPwMsgBox"></div>
			<div class="form-floating">
		      <input name="user_id" type="text" class="form-control" id="setPw_id" >
		      <label for="setPw_id">Id</label>
		    </div>
		    <div class="form-floating">
		      <input name="user_name"  type="text" class="form-control" id="setPw_name" >
		      <label for="setPw_name">이름</label>
		    </div>
		    <div class="form-floating">
		      <input name="email" type="email" class="form-control" id="setPw_email" >
		      <label for="setPw_email">Email</label>
		    </div>
		<p></p>
	    <p class="text-center">
	    <button class="btn btn-primary w-100 py-2" type="button" onClick="fn_findPwAction()">비밀번호 찾기</button>
	    	<a href="javascript:login()">로그인 하기</a>
	    	<a href="javascript:findId()">아이디 찾기</a>
	    	<a href="/signup">회원가입</a>
	    </p>
	    <hr>
	    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
	  </form>
	  
	  
	  
	</main>
<%@include file="../common/footer.jsp" %>
</div>	
</body>
</html>