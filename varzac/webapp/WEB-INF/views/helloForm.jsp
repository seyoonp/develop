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
	<form name="hellForm" action="/registHello" method="post">
		제목 : <input type="text" name="title" id="title" value=""/><br/>	
		내용 : <textarea name="content" id="content" value=""></textarea><br/>
		<input type="submit" value="등록" />
	</form>
</body>
</html>