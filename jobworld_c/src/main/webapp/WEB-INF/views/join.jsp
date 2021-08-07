<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

    <hr><br /><br><br><br><h1 align="center">구직자 가입</h1><br>
    <fieldset id="login">
        <form action="register" method="POST">
            <p>
                <input name="id" placeholder="ID입력" required>
            </p>
            <p>
                <input type="password" name="pw" placeholder="PW입력" required>
            </p>
            <p>
                <input name="name" placeholder="이름입력" required>
            </p>
            <p>
                <input name="age" placeholder="나이입력" required>
            </p>
            <p>
                <input name="address" placeholder="주소입력" required>
            </p>
            <p>
                <input name="gender" placeholder="성별입력" required>
            </p>
            <p>
                <input name="email" placeholder="이메일입력" required>
            </p>

            <p>
                <input class="button" type="submit" value="구직자 가입">
                <input class="button" type="reset" value="지우기">
            </p>

        </form>
    </fieldset>

		<br><br><br><h1 align="center">구인회사 가입</h1>

    <fieldset id="login">
        <form action="register2" method="POST">
            <p>
                <input name="id" placeholder="ID입력" required>
            </p>
            <p>
                <input type="password" name="pw" placeholder="PW입력" required>
            </p>
            <p>
                <input name="name" placeholder="회사이름" required>
            </p>
            <p>
                <input name="address" placeholder="회사위치" required>
            </p>
            <p>
                <input name="tel" placeholder="연락처" required>
            </p>
            <p>
                <input name="email" placeholder="이메일입력" required>
            </p>

            <p>
                <input class="button" type="submit" value="구인회사 가입">
                <input class="button" type="reset" value="지우기">
            </p>

        </form>
    </fieldset>

<%@ include file="footer.jsp" %>