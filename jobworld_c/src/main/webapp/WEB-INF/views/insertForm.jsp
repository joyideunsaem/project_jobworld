<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원입력</h1>
	<form action="sawonInsert">
		<table border="1">
			<tr><td>이름입력</td><td><input type="text" name="name"/></td></tr>
			<tr><td>전화번호입력</td><td><input type="text" name="tel"/></td></tr>
			<tr><td colspan="2" style="text-align: center;"><input type="submit" value="저장" />
			<input type="reset" value="취소" /></td></tr>
		</table>
	</form>
</body>
</html>