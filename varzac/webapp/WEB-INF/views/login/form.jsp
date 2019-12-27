<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" 
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout/default">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="/login/login" method="post">
		아이디 : <input type="text" name="loginId" id="loginId" value="" /><br/>	
		비밀번호 : <input type="password" name="loginPwd" id="loginPwd" value="" /><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>