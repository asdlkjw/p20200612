<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 목록</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" 
		rel="stylesheet"/>
</head>

<body>
	<div class="container"> 
		<h4>상품 목록</h4>
		
		<form action = "/admin/inemupdate" method = "post">
		<table class="table table-sm">
			<thead>
				<tr>	
					<th>번호</th>
					<th>품명</th>
					<th>설명</th>
					<td>가격</td>
					<th>수량</th>
					<th>날짜</th>

				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="tmp" items="${list}">
				<tr>
					<td>${tmp.it_no}<input type="hidden" name="no[]" value = "${tmp.it_no }"></td>
					<td><input type="text" name="name[]" placeholder = "물품명 " value = "${tmp.it_na }" /></td>
					<td><input type="text" name="exp[]" placeholder = "설명 " value = "${tmp.it_exp}" /></td>
					<td><input type="text" name="price[]" placeholder = "가격 " value = "${tmp.it_price}"/></td>
					<td><input type="text" name="itno[]" placeholder = "수량 " value = "${tmp.it_itno}" /></td>
					<td>${tmp.it_date}</td>	

				</tr>
				</c:forEach>
			</tbody>
		</table>
				<input type = "submit" class = "btn btn-success" value = "수정" style = "float : right;" />
		</form>
	</div>
</body>
</html>