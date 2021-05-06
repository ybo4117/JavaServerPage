<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div>글쓰기</div>
	<div><a href="/write3">리스트로</a></div>
	
	<form action="/write3" method="post">
		<div> 제목 : <input type="text" name="write_title" value=""> </div>
		<div> 내용 : <textarea name="write_content"></textarea> </div>
		<div>
			<input type="submit" value="등록"> 
			<input type="reset" value="리셋">
		</div>
	</form>
	
</body>
</html>