<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<script type="text/javascript">

	window.onload=function(){
		let loginBtn = document.querySelector('#loginBtn');
		let signupBtn = document.querySelector('#signupBtn');
		
		if(loginBtn != null) {
			loginBtn.addEventListener('click', function(){
					location.href='/login';	
			
			});
		}
		if(signupBtn != null) {
			signupBtn.addEventListener('click', function(){
					location.href='/signup';	
			
			});
		}	
	}


</script>

<body>

<header class="p-3 mb-3 border-bottom">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
	        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 link-body-bg text-decoration-none">
	          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
	        </a>
	
	        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
	          <li><a href="/main" class="nav-link px-2 link-secondary">HOME</a></li>
	          <li><a href="/serList" class="nav-link px-2 link-body-emphasis">작품보기</a></li>
	          <li><a href="/epiList" class="nav-link px-2 link-body-emphasis">최신UP!</a></li>
	          <li><a href="#" class="nav-link px-2 link-body-emphasis">자유게시판</a></li>
	          <li><a href="#" class="nav-link px-2 link-body-emphasis">보관함</a></li>
	        </ul>
	
	        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
	          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
	        </form>
	
	
		<c:choose>
			<c:when test="${empty sessionScope.userDto }">
				<div class="text-end">
			        <button id="loginBtn" type="button" class="btn btn-info me-2" >Login</button>
			        <button id="signupBtn"type="button" class="btn btn-info">Sign-up</button>
			   	</div>
	        </c:when>
	        <c:otherwise>
		    	<div class="dropdown text-end">
		          <a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
		            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
		          </a>
		          <ul class="dropdown-menu text-small">
		            <li><a class="dropdown-item" href="/insertEpi">글쓰기</a></li>
		            <li><a class="dropdown-item" href="#">설정</a></li>
		            <li><a class="dropdown-item" href="/myPage">마이페이지</a></li>
		            <li><hr class="dropdown-divider"></li>
		            <li><a class="dropdown-item" href="/logout">로그아웃</a></li>
		          </ul>
		        </div>
		    </c:otherwise>
         </c:choose> 
       </div>
      
      
    </div>
  </header>


</body>
</html>