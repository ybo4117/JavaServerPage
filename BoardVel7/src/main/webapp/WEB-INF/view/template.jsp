<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/common.css">
<script defer src="/res/js/common.js"></script>
<title>${requestScope.title}</title>
<!-- request에다가 title이라는 값으로 페이지 이름을 넣는다 -->
</head>
<body>
	<header>
		<nav>
			<ul>
				<c:if test="${empty sessionScope.loginUser}">
					<li><a href="/user/login">로그인</a></li>
				</c:if>
				
				<c:if test="${not empty sessionScope.loginUser}">
					<li><a href="/user/logout">로그아웃</a></li>
					<li><a href="/board/write">글쓰기</a></li>					
					<li><a href="/user/mypage">마이페이지</a></li>
				</c:if>
				
				<li><a href="/board/list">리스트</a></li>
			</ul>
		</nav>
	</header>

	<section>
		<jsp:include page="/WEB-INF/view/${requestScope.jsp}.jsp"></jsp:include>
	</section>
</body>
</html>