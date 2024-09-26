<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인화면</title>
	<link href="resources/css/main.css"  rel="stylesheet">
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
</head>

<%@include file="/WEB-INF/views/common/header.jsp" %>
<body>
   <div id="mainBox">
   		<c:forEach var="i" begin="0" end="${fn:length(map.Elist)-1 }" >
		  	<div class="card" style="width: 350px;">
	  		<c:choose>
	  			<c:when test="${not empty map.Flist[i].ofile_name}">
					<img src="/downLoad?ofile_name=${map.Flist[i].ofile_name }&sfile_name=${map.Flist[i].sfile_name} " class="card-img-top" id="img_${i}"alt="..." style="width: 340px; height: 150px;">
				</c:when>
				<c:otherwise>
					<img src="/resources/img/기본이미지.PNG " class="card-img-top" id="img_${i}"alt="..." style="width: 340px; height: 150px;">
				</c:otherwise>
			</c:choose>
			 	<div class="card-body">
			   		<p class="card-text">${map.Elist[i].ser_title}</p>
			   		<p class="card-text">${map.Elist[i].title }</p>
			   		
			 	</div>
			</div>
		</c:forEach>
		
   </div>
   
</body>

<%@include file="/WEB-INF/views/common/footer.jsp" %>
</html>