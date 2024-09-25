<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
		  <c:choose>
		  	<c:when test="${map.pageDto.startNo > 1 }">
			  	 <li class="page-item">
				   <a class="page-link" href="javascript:go(1)">◁</a>
				 </li>
			 </c:when>
			 <c:otherwise>
			 	 <li class="page-item disabled">
				   <a class="page-link">◁</a>
				 </li>
			 </c:otherwise>
		  </c:choose>
		  <c:choose>
			 <c:when test="${map.pageDto.prev }">
				 <li class="page-item ">
					 <a class="page-link" href="javascript:go(${map.pageDto.startNo-1})">◀</a>
				 </li>
			 </c:when>
			 <c:otherwise>
				 <li class="page-item disabled">
				     <a class="page-link">◀</a>
				 </li>  
			 </c:otherwise>
		  </c:choose>
		  <c:forEach begin="${map.pageDto.startNo }" end="${map.pageDto.endNo }" step="1" var="pageNo">
			  <c:choose>
			  	<c:when test="${map.pageDto.pageNo eq pageNo}">
			  		<li class="page-item active"><a class="page-link">${pageNo}</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li class="page-item"><a class="page-link" href="javascript:go(${pageNo})">${pageNo}</a></li>
			  	</c:otherwise>
			  </c:choose>
		  </c:forEach>  
		
		  <c:choose>
		  <c:when test="${map.pageDto.next}">
			  	<li class="page-item">
				    <a class="page-link" href="javascript:go(${map.pageDto.endNo+1})">▶</a>
				</li>
		  </c:when>
			 <c:otherwise>
			 	 <li class="page-item disabled">
			        <a class="page-link">▶<a>
			    </li>
			 </c:otherwise>
		  </c:choose> 
		  <c:choose>
		  	<c:when test="${map.pageDto.endNo >= map.pageDto.realEndNo }">
			  	 <li class="page-item disabled">
				   <a class="page-link">▷</a>
				 </li>	
			 </c:when>
			 <c:otherwise>
			 	 <li class="page-item">
				 	<a class="page-link" href="javascript:go(${map.pageDto.realEndNo })">▷</a>
				 </li>
			 </c:otherwise>
		  </c:choose>
	  </ul>
	</nav>
</body>
</html>