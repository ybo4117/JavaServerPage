<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String name = "홍길동";
pageContext.setAttribute("name", "A");
request.setAttribute("name", "B");
session.setAttribute("name", "C");
application.setAttribute("name", "D");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>

	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>
	<form action="/del" method="post">
		<input type="submit" value="삭제"> 
		<input type="hidden" name="bbb" value="${param.aaa}">		 
												<!--detail서블릿에 있는 request.getParameter("aaa") 이녀석이 들어간거  -->
	</form>	
		<a href="/mod?ccc=${param.aaa}"><button>수정</button></a>
						<!--detail서블릿에 있는 request.getParameter("aaa") 이녀석이 들어간거  -->

	<!-- 
	<div>쿼리스트링 : ${param.no}, ${param.age}</div>
	<div>String name :nameame %></div>
	<div>내장객체 name : ${name}</div>
	<div>data : ${data}</div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt} / ${data.getCtnt()}</div>
	<div>1. : ${num}</div>
	<div>2. : ${babo}</div>
-->


</body>
</html>