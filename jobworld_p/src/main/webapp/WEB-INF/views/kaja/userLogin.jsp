<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>		
<form action="/loginHaja" method="post"><!-- 이름과 pw /loginHaja로 전달 -->
<table>
<tr><td>username</td><td><input type="text" name="username" placeholder="이름입력"></td></tr>
<tr><td>password</td><td><input type="text" name="password" placeholder="pw입력"></td></tr>
<tr><td colspan=2 align="right"><button type="submit">로그인</button></td></tr>
</table>
</form>
</body>
</html>