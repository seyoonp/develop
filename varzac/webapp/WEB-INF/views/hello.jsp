<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="data" varStatus="status">
		<div>제목 : ${data.title}, 내용 : ${data.content} 등록일 : ${data.insDate}</div> 
	</c:forEach>
</body>
</html>