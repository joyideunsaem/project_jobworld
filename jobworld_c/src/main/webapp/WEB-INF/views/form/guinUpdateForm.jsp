<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gu In Update</title>
</head>
<body>
	<h1>모집공고 입력</h1>
	<form action="guinUpdate">
		<table border="0">
			<input type="hidden" name="id" value="${id}"> <%-- 아이디 --%>

			<tr><td>회사이름 :</td><td><input type="text" name="name" value=${name} ></td>	<td>우대사항 :</td><td><input type="text" name="prefer" value=${prefer} ></td>	</tr>
			<tr><td>회사위치 :</td><td><input type="text" name="address" value=${address} ></td>	<td>최종학력 :</td><td><input type="text" name="edu" value=${edu} ></td></tr>	
			<tr><td>연락처 :</td><td><input type="text" name="tel" value=${tel} ></td>		<td>자격증 :</td><td><input type="text" name="cert" value=${cert} ></td></tr>
			<tr><td>이메일 :</td><td><input type="text" name="email" value=${email} ></td>	<td>전공 :</td><td><input type="text" name="major" value=${major} ></td>	</tr>
			<tr><td>직무소개 :</td><td><input type="text" name="job" value=${job} ></td>		<td>경력 :</td><td><input type="text" name="career" value=${career} ></td></tr>
			<tr><td>모집인원 :</td><td><input type="text" name="people" value=${people} ></td></tr>
			<tr><td>모집기간 :</td><td><input type="text" name="period" value=${period} ></td></tr>	
			<tr><td>회사소개 :</td></tr>
			<td></td><td><textarea type="text" name="intro" cols="50" rows="10">${intro}</textarea></td></tr>
			
			<tr><td colspan="2" style="text-align: center;"><input type="submit" value="등록">

		</table>
	</form>
	<%@ include file="../footer.jsp" %>
</body>
</html>