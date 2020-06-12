<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
		
</head>


<body>
		<form action = "/board/boardinsert" method = "get">
			 <div class = "form-inline" style="margin:5px">
				<label style ="width : 100px;"></label>
				<a href="/board/boardinsert" class = "btn btn-secondary">여러글쓰기</a> 
				
		 	
		 	</div>
		 </form>
<form action = "/board/insert" method = "post" enctype="multipart/form-data">
		<input type="text" name="brd_title" placeholder="글제목" />
		<textarea id="content" name="brd_content" placeholder="글내용"></textarea>
		<input type="text" name="brd_id" value = "${userid}" readonly />
		<input type="file" name="imgs" />
		<input type="submit" value="글쓰기 " />

	</form>
	

</body>
</html>