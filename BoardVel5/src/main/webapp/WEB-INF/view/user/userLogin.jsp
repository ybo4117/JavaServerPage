<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인하세연</h1>
	
	<div>${errMsg}</div>

	<div>
		<form action="userLogin" method="post">

			<div>
				<input type="text" name="u_id" placeholder="id">
			</div>

			<div>
				<input type="password" name="u_pw" placeholder="password">
			</div>

			<div>
				<input type="submit" value="login">
			</div>

		</form>
	</div>
	
	<div>
		<a href = "userJoin"> join </a>
	</div>

</body>
</html>