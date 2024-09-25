<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${msg }
${url}
<script type="text/javascript">
 let msg = '${msg}';
 let url = '${url}';
 
 
	
	if(msg != ''){
		 alert(msg);
	}
 	if(url != ''){
 		location.href=url;
 	}else{
 		history.back();
 	}
 
 

 
 



</script>

</body>
</html>