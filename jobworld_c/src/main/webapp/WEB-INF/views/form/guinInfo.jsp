<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gu In Info</title>

</head>
<body>
	<h1>모집공고</h1>
		
		<table border="0">

			<tr><td>회사이름 : &nbsp;</td><td>&nbsp;${guin.name}</td>	<td>우대사항 :&nbsp;</td><td>&nbsp;${guin.prefer}</td>	</tr>
			<tr><td>회사위치 :</td><td>&nbsp;${guin.address}</td>	<td>최종학력 :</td><td>&nbsp;${guin.edu}</td></tr>	
			<tr><td>연락처 :</td><td>&nbsp;${guin.tel}</td>		<td>자격증 :</td><td>&nbsp;${guin.cert}</td></tr>
			<tr><td>이메일 :</td><td>&nbsp;${guin.email}</td>	<td>전공 :</td><td>&nbsp;${guin.major}</td>	</tr>
			<tr><td>직무소개 :</td><td>&nbsp;${guin.job}</td>	<td>경력 :</td><td>&nbsp;${guin.career}</td></tr>
			<tr><td>모집인원 :</td><td>&nbsp;${guin.people}</td></tr>
			<tr><td>모집기간 :</td><td>&nbsp;${guin.period}</td></tr>	
			<tr><td>회사소개 :</td></tr>
			<td></td><td><textarea disabled type="text" name="intro" cols="50" rows="10">${guin.intro}</textarea></td></tr>
			
			<tr><td colspan="2" style="text-align: center;"><a href="/guinAll">목록으로</a>

		</table>

	<%@ include file="../footer.jsp" %>
</body>
</html>