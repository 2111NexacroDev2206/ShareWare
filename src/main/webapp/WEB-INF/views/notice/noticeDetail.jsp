<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
</head>
<body>
<h1>공지게시판 상세보기</h1>

	<span>글쓴이 : ${notice.member.memberName }</span>
	<span>작성일 : ${notice.noticeDate}</span>
	<div dorder="1">${notice.noticeTitle}</div>
	<div dorder="1">${notice.noticeContent}
				
		<c:if test="${notice.noticeImgName != null}">
			<img src = "../../../resources/loadFile/${notice.noticeImgRemane}" alt="${notice.noticeImgName}">
		</c:if>
	</div>
	
</body>
</html>