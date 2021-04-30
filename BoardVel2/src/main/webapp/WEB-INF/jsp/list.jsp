<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<a href="/write">글쓰기</a>

	<c:forEach var="i" begin="1" end="10">
		<span>${i}</span>
	</c:forEach>
	<div>글 ${abc.size()}개</div>
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
		</tr>
		<c:forEach var="item" items="${abc}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td><a href="/detail?aaa=${status.index}">${item.title}</a></td>
				<!--  aaa=${status.index} -> Detail서블릿으로 간다  -->
			</tr>
		</c:forEach>
	</table>


</body>
</html>