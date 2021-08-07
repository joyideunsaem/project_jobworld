<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gu In List</title>

<style>
	td{
	 text-align : center;
	}
</style>

</head>
<body>
	<h1>회사 소개</h1>
	<form action="" onsubmit="return false">
		<table border="1" width="500" align="center">
			<tr><td></td>
			<td>회사이름</td>
			<td>회사위치</td>
			<td>경력</td>
			<td>전공</td>
			<td>모집인원</td></tr>
		
			<c:forEach var="imsi" items="${guinAll}">
			<c:set var="i" value="${i+1}"/>
			
			<tr><td>${i}</td>
				<td><a href=/guin?id=${imsi.id}>${imsi.name}</a></td>
				<td>${imsi.address}</td>
				<td>${imsi.career}</td>
				<td>${imsi.major}</td>
				<td>${imsi.people}</td></tr>	
			
			</c:forEach>
		
		</table>
	</form>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>