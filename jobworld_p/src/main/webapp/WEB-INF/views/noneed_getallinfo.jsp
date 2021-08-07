<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사원 전체 보기 in login</h1>
	<table border="2">
		<tr><th>이름</th><th>전화번호</th></tr>
		<c:forEach var="imsi" items="${getallinfo}">
			<tr>
				<th><a href="getinfo?name=${imsi.name}">${imsi.name}</a></th>
				<th>${imsi.tel}</th>
			</tr>
		</c:forEach>
	</table> <br />
	
	<a href="insertForm">[사원입력]</a>

</body>
</html>