<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
<link rel = "stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	.hidden{
		display: none;
	}
	.fa-heart{
		color : red ;
	}
</style>
<script defer src="/res/js/cmtDel.js"></script>
</head>
<body>
	<div>글의 pk(iboard) 값 : ${param.iboard}</div>

	<c:if test="${loginUser.iuser == data.iuser}">
		<div>
			<a href="del?iboard=${param.iboard}">삭제</a> <a
				href="mod?iboard=${param.iboard}">수정</a>
		</div>
	</c:if>
	
	<div><a href="list">리스트로 돌아가기</a></div>
	
	<h1>${data.title}
		<c:if test="${data.isFav eq 0}">
		<!-- eq 적어도 되고 == 적어도됨 -->
		<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
		</c:if>
		<c:if test="${data.isFav == 1}">
		<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>
		</c:if>
	</h1>
	<div>글번호 : ${data.iboard}</div>
	<div>글쓴이 : ${data.unm} | 작성일 : ${data.regdt}</div>
	<div>${data.ctnt}</div>
	
	
	<h3>댓글</h3>
	<div>
		<form id="insForm" action="cmt" method="post" class="">
		<input type="hidden" name="icmt" value="0">
		<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
		
		<form id="updForm" action="cmt" method="post" class="hidden">
		<input type="hidden" name="icmt" value="0">
		<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="수정취소" onclick="showInsForm();">
			</div>
		</form>
	</div>


	<div>
		<table>
			<tr>
				<th>no</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			 
			<c:forEach items="${requestScope.Cmtlist}" var="item">
			<!-- requestScope를 쓰는이유는 pagecontext를 뛰어넘고 request에 저장되어 있는 값을 먼저 확인하려고 쓴다 -->
			<!-- 미묘한 차이지만 쌓이게 된다면 큰 차이를 발생 시킬수도 있다. 여기서 Cmtlist가 저장되어 있는 공간은 request이기 떄문에
			 pagecontext를 뛰어 넘고 확인을 한다 ( ex) 2번 돌것을 1번 돈다 이말임) -->
			<tr>
				<td>${item.icmt}</td>
				<td>${item.cmt}</td>
				<td>${item.unm}</td>
				<td>${item.regdate}</td>
				<td>
				<c:if test="${sessionScope.loginUser.iuser == item.iuser}">
					<input type="button" value="수정" onclick="updCmt(${item.icmt}, '${item.cmt.trim()}');">
					<!-- 맨뒤쪽에 item.cmt.trim()의 trim()은 양쪽 공백을 없애는 과정이다 이게 없으면 댓글에 Enter를 치게되면 오류가난다 -->
					<button onclick="delCmt(${item.icmt}, ${requestScope.data.iboard});">삭제</button>
					<!-- <a href="cmt?icmt=${item.icmt}&iboard=${requestScope.data.iboard}"></a> -->
				</c:if>
				</td>			
			</tr>
		</c:forEach>
		</table>
	</div>



</body>
</html>