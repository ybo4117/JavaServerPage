<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<a href="#" onclick="goBack();">돌아가기</a>
</div>

<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="del?iboard=${param.iboard}">삭제</a> <a
			href="mod?iboard=${param.iboard}">수정</a>
	</div>
</c:if>

<div>글번호 : ${requestScope.data.iboard}</div>
<div>글쓴이 : ${requestScope.data.writerNm} | 작성일 :
	${requestScope.data.regdt}</div>
<div>
	<c:out value="${requestScope.data.ctnt}" />
</div>


<c:if test="${loginUser.iuser != null}">
	<div>
		<form id="cmtFrm" onsubmit="return false;">
			<input type="text" id="cmt">
			<input type="button" value="댓글" onclick="regCmt();">
		</form>
	</div>
</c:if>

<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}"	data-iboard="${param.iboard}"></div>

<script src="/res/js/boardDetail.js"></script>




