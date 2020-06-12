<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 일괄등록</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"	rel="stylesheet"/>
</head>

<body>
	<div class="container">
	<form action="/board/boardinsert" method="post">
		<table class = "table table-sm">
			<c:forEach var = "i" begin="1" end ="3" step ="1">
			<tr>
				<td><input type="text" name="title[]" placeholder = "제목 " value = "토마토"/></td>
				<td><textarea id="content" name="content[]" placeholder="글내용"></textarea></td>
				<td><input type="text" name="id[]" placeholder = "아이디" value = "${userid}" readonly/></td>
			</tr>
			</c:forEach>
				
		</table>	
		<input type = "submit" class = "btn btn-success" value = "일괄추가" />
		</form>
	</div>

</body>
</html>