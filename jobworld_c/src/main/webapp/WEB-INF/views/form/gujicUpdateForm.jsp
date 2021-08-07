<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gu Jic Update</title>
</head>
<body>
	<h1>구직자 입력</h1>
	<form action="gujicUpdate">
		<table border="0">
			<input type="hidden" name="id" value="${id}"> <%-- 아이디 --%>

			<tr><td>이름 :</td><td><input type="text" name="name" value=${name}></td>	<td>전공 :</td><td><input type="text" name="major" value=${major}></td>	</tr>
			<tr><td>나이 :</td><td><input type="text" name="age" value=${age}></td>		<td>경력 :</td><td><input type="text" name="career" value=${career}></td>		</tr>	
			<tr><td>성별 :</td><td><input type="text" name="gender" value=${gender}></td>	<td>최종학력 :</td><td><input type="text" name="edu" value=${edu}></td>		</tr>
			<tr><td>주소 :</td><td><input type="text" name="address" value=${address}></td>		<td>자격증 :</td><td><input type="text" name="cert" value=${cert}></td>		</tr>
			<tr><td>연락처 :</td><td><input type="text" name="tel" value=${tel}></td></tr>
			<tr><td>이메일 :</td><td><input type="text" name="email" value=${email}></td></tr>		
			<tr><td>자기소개 :</td></tr>
			<td></td><td><textarea type="text" name="intro" cols="50" rows="10">${intro}</textarea></td></tr>
			
			<tr><td colspan="2" style="text-align: center;"><input type="submit" value="등록">
			

		</table>
	</form>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>