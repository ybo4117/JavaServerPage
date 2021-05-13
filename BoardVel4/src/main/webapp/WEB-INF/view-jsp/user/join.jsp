<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
.errMsg{
	color : red;
}
</style>
</head>
<body>
	<div>
		<a href="login">로그인으로 돌아가기</a>
	</div>
	<div class="errMsg">${errMsg}</div>
	<div>
		<form action="join" method="post">
			<div>
				<input type="text" name="u_id" placeholder="아이디">				
			</div>
			<div>
				<input type="password" name="u_pw" placeholder="비밀번호">
			</div>
			<div>
				<input type="text" name="u_nm" placeholder="이름">
			</div>
			<div>
				성별 : 
				<label>여<input type="radio" name="gender" value="0" checked></label>
				<label>남<input type="radio" name="gender" value="1"></label>
			</div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>