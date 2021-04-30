<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글쓰세요</h1>
	<div><a href="/list">돌아가기</a></div>
	
	<form action="/write" method="post">
		<div>
			<input type="text" name="title" value="">
		</div>
		<div>
			<textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>

		<div>
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
		</div>
	</form>

</body>
</html>