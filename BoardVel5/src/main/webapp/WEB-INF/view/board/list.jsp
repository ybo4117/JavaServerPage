<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
.record {
	cursor: pointer;
}
.record:hover {
	background-color: #ecf0f1;
}
.desc {
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>리스트</h1>
	<div>ID : ${loginUser.uid} / ${loginUser.unm}님 환영합니다.</div>

	<div>LOGOUT</div>
	<div>
		<a href="write"> 글 쓰기 </a>
	</div>
	<table>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>작성일</th>
			<th>글쓴이</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr class="record" onclick="moveToDetail(${list.iboard})">
				<td>${list.iboard}</td>
				<td>${list.title}</td>
				<td>${list.regdt}</td>
				<td>${list.unm}</td>
			</tr>
		</c:forEach>
	</table>

<script>
	function moveToDetail(iboard) {
		location.href="detail?iboard=" + iboard;
	}
</script>


</body>
</html>