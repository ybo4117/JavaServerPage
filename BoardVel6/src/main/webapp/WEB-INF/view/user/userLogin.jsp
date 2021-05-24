<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

	<div>
		<a href="join"> join </a>
	</div>
</div>


