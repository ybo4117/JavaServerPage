<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
	
</head>
<body>
	<h1>글 수정</h1>
	<div><a href="/detail3?iboard=${param.iboard}">뒤로가기</a></div>
	
	<form action="/mod3" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
		<div> 제목 : <input type="text" name="write_title" value="${data.title}"> </div>
		<div> 내용 : <textarea name="write_content">${data.ctnt }</textarea></div>
		<div>
			<input type="submit" value="등록"> 
			<input type="reset" value="리셋">
		</div>
	</form>
	
</body>
</html>