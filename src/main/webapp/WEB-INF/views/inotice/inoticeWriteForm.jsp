<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중요공지 작성 페이지</title>
</head>
<body>
<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
		<div class="s-container">
			<form action="">
				<table>
					<tr>
						<td>제목</td>
						<td><input type="text" name="" placeholder="제목을 입력해주세요"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="hidden" value="${project.projectMade }">
						${project.projectMade }</td>
					</tr>
					<tr>
						<td>파일첨부</td>
						<td><input type="file" name="uploadFile"></td>
					</tr>
					<tr>
						<td  colspan="2"><textarea name="" placeholder="내용을 입력해주세요"></textarea></td>
						<td><input type="hidden" name="inoticeDate"></td>
					</tr>
				</table>
			</form>
		</div>
		
</body>
</html>