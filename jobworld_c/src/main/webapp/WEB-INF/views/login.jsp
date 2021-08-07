<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


    <hr><br /><br><br><br><h1 align="center">구직자 로그인</h1><br>

    <fieldset id="login">
        <form action="loginProcess" method="POST">
            <p>
                <input name="id" placeholder="ID" required>
            </p>
            <p>
             <input type="password" name="pw" placeholder="PW" required>
            </p>
            <p>
                <input class="button" type="submit" value="구직자 로그인">
                <input class="button" type="reset" value="지우기">
            </p>
     
        </form>
    </fieldset>
    
     <hr><br /><br><br><br><h1 align="center">구인회사 로그인</h1><br>
   
     <fieldset id="login">
        <form action="loginProcess2" method="POST">
            <p>
                <input name="id" placeholder="ID" required>
            </p>
            <p>
             <input type="password" name="pw" placeholder="PW" required>
            </p>
            <p>
                <input class="button" type="submit" value="로그인">
                <input class="button" type="reset" value="구인회사 지우기">
            </p>
     
        </form>
    </fieldset>

<%@ include file="footer.jsp" %>