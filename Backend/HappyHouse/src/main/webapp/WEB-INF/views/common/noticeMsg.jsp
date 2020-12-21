<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="root" value="${pageContext.request.contextPath }" />
<%
	String msg=(String)request.getAttribute("msg");
%>
<!--Request attribute에 있는 msg와 loc을 가져올수 있다. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert('<%=msg%>');
		
		location.replace("${root}/notice?action=list&pg=1&key=&word=");
	</script>
</body>
</html>





