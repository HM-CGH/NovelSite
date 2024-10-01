<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${map.epiDto.episode_num}화 / ${map.epiDto.title}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="resources/css/detailEpi.css"  rel="stylesheet">
<script type="text/javascript" src="/resources/js/detailEpi.js"></script>
</head>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<body>
<div id="container">
	<table class="table">
		<thead class="text-center align-middle">
		   	<tr class="text-center">
		   		<td colspan="2" rowspan="5" style="width: 100px">
		   			<c:choose>
		   				<c:when test="${empty map.fileList }">
		   					<img alt="썸네일" src="../resources/img/기본이미지.PNG"  class="imgBox">
		   				</c:when>
		   				<c:otherwise>
		   					<c:forEach items="${map.fileList }" var="file">
				   				<img alt="썸네일" src="/downLoad?ofile_name=${file.ofile_name }&sfile_name=${file.sfile_name} " class="imgBox">
				   			</c:forEach>
		   				</c:otherwise>
		   			</c:choose>
		   		</td>
		   		<th scope="col">시리즈명</th>
		     	<td scope="col">${map.epiDto.ser_title}</td>
		   	</tr>
		   	<tr>
				<th scope="col">작성자</th>
				<td scope="col">${map.epiDto.user_id}</td>
		   	</tr>
		   	<tr>
			     <th scope="col">제목</th>
			     <td scope="col">${map.epiDto.title}</td>
		   	</tr>
		    <tr>
		    	<th scope="col">작성일</th>
		    	<td scope="col">${map.epiDto.created_date}</td>
		   	</tr>
		    <tr>
		    	<th scope="col">조회수</th>
		    	<td scope="col">${map.epiDto.counts}</td>
		   </tr>
		</thead>
		<tbody >
		    <tr >
		      <td colspan="4" ><div id="contentBox">${map.epiDto.content}</div></td>
		    </tr>
			    <tr>
			    	<td></td>
			    	<td></td>
			    	<td></td>
			    	<td style="text-align: right;">
						<c:if test="${sessionScope.userDto.user_id eq map.epiDto.user_id}">
				    		<a href="/updateEpi?episode_id=${map.epiDto.episode_id}">수정</a> 
				    		<form action="/delEpi" id="delform" name="delform" enctype="multipart/form-data" method="post">
				    			<input type="hidden" name="episode_id" value="${map.epiDto.episode_id}">
				    			<button class="btn btn-secondary" id="delEpi" type="button">삭제</button> 
				    		</form>
						</c:if>
			    		<a href="/epiList?pageNo=${param.pageNo}">목록으로</a>
			    	</td>
			    </tr>
		    <tr>
			    <c:choose>
			    	<c:when test="${map.epiDto.episode_num - 1 < 1}">
			    		<td>
			    			<button class="btn btn-secondary disabled" type="button">이전화</button>
			    		</td>	
			    	</c:when>
			    	<c:otherwise>
			    		<td>
				    		<button id="prevEpi" class="btn btn-secondary" type="button" data-page="${param.pageNo }" data-num="${map.epiDto.episode_num}" data-eid="${map.epiDto.episode_id}">이전화</button>
				    	</td>
			    	</c:otherwise>
			    </c:choose>
		    	<td></td>
		    	<td></td>
			    <c:choose>
			    	<c:when test="${map.epiDto.episode_num + 1 > map.lastNum}"> 
			    		<td>
			    			<button class="btn btn-secondary disabled" type="button" style="float: right">다음화</button>
			    		</td>	
			    	</c:when>
			    	<c:otherwise>
			    		<td>
				    		<button id="nextEpi" class="btn btn-secondary" type="button" style="float: right" data-page="${param.pageNo }" data-num="${map.epiDto.episode_num}" data-eid="${map.epiDto.episode_id}">다음화</button>
				    	</td>
			    	</c:otherwise>
			    </c:choose>	
		    </tr>
	 	</tbody>
	</table>
</div>	

<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>