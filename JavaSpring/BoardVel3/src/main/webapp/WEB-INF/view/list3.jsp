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
	<div>
		<a href="/write3">글쓰기</a>
	</div>
	<div>

		<table>
			<tr>
				<td><input type="button" name="abc" onclick="moveToDESC()">no</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>

			<c:forEach items="${list}" var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard});">
					<!-- a태그로 한번에 안보내져서 하나하나 줘야되기떄문에 모든 정보를 한번에 보낼려고 onclick을 썼다 -->
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<script>
		var num = 0;
		function moveToDetail(iboard) {
			//console.log('iboard : %d', iboard);
			location.href='/detail3?iboard=' + iboard;
			}
		/*
		function moveToDESC(){
			if(num == 0){
			 num++;
			 location.href='/list3';	
			}			
			else{
			var val= ${param.num};
			}			
			
			if(val ==1){
				val = 0;
			}else{
				val = 1;
			}
			
			location.href='/list3?num=' + val;			
		}
		*/
		
	</script>

</body>
</html>