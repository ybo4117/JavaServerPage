<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>Login</h1>
<div>${requestScope.errMsg}</div>
<form action="login" method="post">
	<div>
		<input type="text" name="uid" placeholder="id">
	</div>

	<div>
		<input type="password" name="upw" placeholder="password">
	</div>

	<div>
		<input type="submit" value="login">
	</div>
</form>

<div>
	<a href="join"> join </a>
</div>