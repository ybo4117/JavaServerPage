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
	<div>
		<form action="write" method="post">
			
			<!-- <div><input type="hidden" name ="iboard" value="${loginUser.uid}"></div> 
				이렇게 써서 보내면 안된다. <메모리의 값을 받아오는 것이 아닌 세션에 있는 값을 받아와야함.>
			-->
			<div><input type="text" name="title" placeholder="제목"></div>
			<div><textarea name="ctnt" placeholder="내용"></textarea></div>
			<div>
				<input type="submit" value="글쓰기">
				<input type="reset" value="초기화">			
			</div>
		</form>
	</div>

</body>
</html>