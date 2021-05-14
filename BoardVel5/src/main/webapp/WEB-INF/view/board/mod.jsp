<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<h1>글수정</h1>
	<div>
		<form action="mod" method="post">
			<input type="hidden" name = "iboard" value="${param.iboard}">
			<div><input type="text" name="title" placeholder="TITLE" value = "${data.title}"></div>
			<div><textarea name="ctnt" placeholder="CONTENT_TEXT" >${data.ctnt}</textarea></div>
			<div>
				<input type="submit" value="MOD">
				<input type="reset" value="RESET">			
			</div>
		</form>
	</div>
</body>
</html>