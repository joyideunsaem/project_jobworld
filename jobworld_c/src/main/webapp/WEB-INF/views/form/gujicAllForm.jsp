<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gu Jic List</title>

<style>
	td{
	 text-align : center;
	}
</style>
</head>

<body>
	<h1>구직자 소개</h1>
	<form action="" onsubmit="return false">
		<table border="1" width="500" align="center">
			<tr><td></td><td>이름</td><td>나이</td><td>최종학력</td><td>경력</td><td>거주지</td><td>이메일</td></tr>
		
			<c:forEach var="imsi" items="${gujicAll}">
				<c:set var="i" value="${i+1}"/>
			<tr><td>${i}</td><td><a href=/gujic?id=${imsi.id}>${imsi.name}</a></td><td>${imsi.age}</td><td>${imsi.edu}</td>
				<td>${imsi.career}</td><td>${imsi.address}</td><td>${imsi.email}</td></tr>	
			
			</c:forEach>
		
		</table>
	</form>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>