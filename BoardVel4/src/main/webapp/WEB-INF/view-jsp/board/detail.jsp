<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
</head>
<body>
	<h1>디테일 페이지</h1>
	<div>글의 pk(iboard) 값 : ${param.iboard}</div>

	<div>글번호 : ${data.iboard}</div>
	<!-- 글번호는 param.iboard의 값으로 받아왔기에 굳이 안받아도 됨 -->
	<div>제목 : ${data.title}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>작성일 : ${data.regdt}</div>
	<div>${data.ctnt}</div>

	<c:if test = "${loginUser.iuser == data.iuser}">
		<div>
			<a href="del?iboard=${param.iboard}">삭제</a> 
			<a href="mod?iboard=${param.iboard}">수정</a>
		</div>
	</c:if>


</body>
</html>