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
			
			<!-- <div><input type="hidden" name ="iuser" value="${loginUser.uid}"></div> 
				이렇게 써서 보내면 안된다. <메모리의 값을 받아오는 것이 아닌 세션에 있는 값을 받아와야함.>
				why? => 문제점이 생기는 데 실제로 글쓰기를 할때 pk값이 보인다 단순하게 자바스크립트조금만 할줄아는사람이면
				공격 and 장난이 가능하다.
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