<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gu Jic Info</title>
</head>
<body>
	<h1>구직자 이력</h1>

		<table border="0">
			<tr><td>이름 :&nbsp;</td><td>&nbsp;${gujic.name}</td>	<td>전공 :&nbsp;</td><td>&nbsp;${gujic.major}</td>	</tr>
			<tr><td>나이 :</td><td>&nbsp;${gujic.age}</td>		<td>경력 :</td><td>&nbsp;${gujic.career}</td>		</tr>	
			<tr><td>성별 :</td><td>&nbsp;${gujic.gender}</td>		<td>최종학력 :</td><td>&nbsp;${gujic.edu}</td>		</tr>
			<tr><td>주소 :</td><td>&nbsp;${gujic.address}</td>		<td>자격증 :</td><td>&nbsp;${gujic.cert}</td>		</tr>
			<tr><td>연락처 :</td><td>&nbsp;${gujic.tel}</td></tr>
			<tr><td>이메일 :</td><td>&nbsp;${gujic.email}</td></tr>		
			<tr><td>자기소개 :</td></tr>
			<td></td><td><textarea disabled type="text" name="intro" cols="50" rows="10">${gujic.intro}</textarea></td></tr>
			
			<tr><td colspan="2" style="text-align: center;"> <a href=/gujicAll>목록으로</a></tr>

		</table>
	<%@ include file="../footer.jsp" %>
</body>
</html>