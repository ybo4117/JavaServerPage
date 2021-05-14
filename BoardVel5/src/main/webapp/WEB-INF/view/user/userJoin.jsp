<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<div>회원가입</div>

	<div>
		<form action="userJoin" method="post">
			<div>
				<input type="text" name="u_id" placeholder="ID">
			</div>

			<div>
				<input type="password" name="u_pw" placeholder="PASSWORD">
			</div>

			<div>
				<input type="text" name="u_nm" placeholder="NAME">
			</div>
			<div>
				성별 : 
				<label>남<input type="radio" name="gender" value="1" checked></label>
				<label>여<input type="radio" name="gender" value="2"></label>
			</div>
			<div>
				<input type="submit" value="Sign up">
				<input type="reset" value="reset">
			</div>
		</form>
	</div>

</body>
</html>