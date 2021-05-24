<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>리스트</h1>
<div>ID : ${loginUser.uid} / ${loginUser.unm}님 환영합니다.</div>

<div>
	<a href="/user/userLogout">로그아웃(LOGOUT)</a>
</div>
<div>
	<a href="write"> 글 쓰기 </a>
</div>
<div>
	<table>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>작성일</th>
			<th>글쓴이</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr class="record" onclick="moveToDetail(${list.iboard})">
				<td>${pageScope.list.iboard}</td>
				<!--  여기서는 굳이 쓸필요는 없다 왜? why? 이유는 forEach에서 list라는 값으로 받은 녀석은 pageConText이기 때문 -->
				<td>${list.title}</td>
				<td>${list.regdt}</td>
				<td>${list.unm}</td>
			</tr>
		</c:forEach>
	</table>
</div>
