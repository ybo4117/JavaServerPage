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
			<div><input type="text" name="title" placeholder="제목" value = "${data.title}"></div>
			<div><textarea name="ctnt" placeholder="내용" >${data.ctnt}</textarea></div>
			<div>
				<input type="submit" value="글쓰기">
				<input type="reset" value="초기화">			
			</div>
		</form>
	</div>
</body>
</html>