<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중요공지 상세 페이지</title>
</head>
<body>
	<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<table border="1">
			<tr>
				<td>제목</td>
				<td colspan="3">${important.importantTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${important.importantWriter }</td>
				<td>작성일</td>
				<td>${important.importantDate }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><a href="../../../resources/iuploadFiles/${important.fileReName }" download>
		 		${important.fileName }
				</a></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea name="" id="" >
                   		  ${important.importantContent }
                     </textarea>
				</td>
			</tr>
		</table>
		<input type="button" onclick="location.href='/project/importantList.sw?projectNo=${important.projectNo}'" value="목록">
	</div>
</body>
</html>