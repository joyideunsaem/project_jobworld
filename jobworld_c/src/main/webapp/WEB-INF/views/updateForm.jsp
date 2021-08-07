<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원수정</h1>
	<form action="sawonUpdate">
		<table>
			<tr><td>이름</td><td>${name }</td></tr>
			<tr><td>전화번호</td><td><input type="text" value="${tel }" name="tel"/>
			<input type="hidden" value="${name }" name="name" /></td></tr>
			<tr><td colspan="2"><input type="submit" value="수정하기" /></td></tr>
		</table>
	</form>
	<a href="sawonDelete?name=${name }">회원탈퇴</a>
</body>
</html>