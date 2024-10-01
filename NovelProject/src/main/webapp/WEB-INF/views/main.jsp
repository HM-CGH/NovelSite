<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인화면</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="resources/css/main.css"  rel="stylesheet">
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
</head>
<script type="text/javascript">
window.addEventListener('load', function(){
	let cardList = document.querySelectorAll('.card');
	cardList.forEach(function(item){
		item.addEventListener('click', function(){
			let no = item.dataset.no;
			location.href='/detailEpi?episode_id='+no+'&pageNo=1';
		})
	})	
})
</script>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<body>
<h1 id="mainHeader">인기 에피소드</h1>
   <div id="mainBox">
   		<c:forEach var="i" begin="0" end="${fn:length(map.Elist)-1 }" >
		  	<div class="card" data-no="${map.Elist[i].episode_id}">
	  		<c:choose>
	  			<c:when test="${not empty map.Flist[i].ofile_name}">
					<img src="/downLoad?ofile_name=${map.Flist[i].ofile_name }&sfile_name=${map.Flist[i].sfile_name} " class="card-img-top" id="img_${i}"alt="썸네일이미지">
				</c:when>
				<c:otherwise>
					<img src="/resources/img/기본이미지.PNG " class="card-img-top" id="img_${i}"alt="기본이미지" >
				</c:otherwise>
			</c:choose>
			 	<div class="card-body">
			   		<p class="card-text">${map.Elist[i].ser_title}</p>
			   		<p class="epiNumFont">제 ${map.Elist[i].episode_num } 화</p>
			   		<p class="card-text">${map.Elist[i].title }</p>
			 	</div>
			</div>
		</c:forEach>
   </div>
   
</body>

<%@include file="/WEB-INF/views/common/footer.jsp" %>
</html>