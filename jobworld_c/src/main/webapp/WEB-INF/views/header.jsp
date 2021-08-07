<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
 <header>
        <a href="main"><img src="images/logo.png" width="100" height="100"></a>

        <nav>
            <div>
                <a href="join">회원가입</a>
            </div>
            
            
            <%
            	pageContext.setAttribute("id",session.getAttribute("id"));
            %>
            <c:set var="ses" value="${id}" />
            
            <c:if test="${ses eq null}">
                <div>
              		<a href="login">로그인</a>
            	</div>
            </c:if>
            
            <c:if test="${ses ne null}">
	            <div>
	                <a href="logout">로그아웃</a>
	            </div>
            </c:if>              
            
            <div>
                <a href="gujicAll">구직자</a>
            </div>
            <div>
                <a href="guinAll">구인회사</a>
            </div>
            <div>
                <a href="gujicForm?id=<%=session.getAttribute("id")%> ">이력서</a>
            </div>
            <div>
                <a href="guinForm?id=<%=session.getAttribute("id")%> ">모집공고</a>
            </div>
        </nav>
    </header>

    <hr><br />
    <img src="images/slogan.png">
