<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>수정하세요</h1>
	<div>
		<a href="/detail?aaa=${param.ccc}">돌아가기</a>
							<!-- Mod서블릿의 request.getParameter("ccc");의 값이 들어간거 -->
	</div>

	<form action="/mod" method="post">
	<input type="hidden" name="fff" value="${param.ccc}">
								<!-- Mod서블릿의 request.getParameter("ccc");의 값이 들어간거 -->
		<div>
			<input type="text" name="title" value="${data.title}">
		</div>
		<div>
			<textarea name="ctnt" rows="10" cols="10">${data.ctnt}</textarea>
		</div>

		<div>
			<input type="submit" value="수정"> 
			<input type="reset" value="초기화">
		</div>
	</form>

</body>
</html>