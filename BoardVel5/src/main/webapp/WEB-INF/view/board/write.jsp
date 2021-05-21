<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글쓰기 </title>
</head>
<body>
	<h1> 글 쓰기 </h1>
	
	<div>
		<form action="write" method="post">			
			<div>
				제목 : 
				<div><input type="text" name="title" placeholder="TITLE"></div>
			</div>
			<br>
			<div>
				내용 : 
				<div><textarea name="ctnt" placeholder="CONTENT_TEXT"></textarea></div>			
			</div> 
			
			<div>
				<input type="submit" value="WRITE">
				<input type="reset" value="RESET">			
			</div>		
		</form>	
	</div>
	
</body>
</html>