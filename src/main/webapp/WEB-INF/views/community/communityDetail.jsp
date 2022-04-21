<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세보기</title>
</head>
<body>
	<h1>자유게시판 상세보기</h1>
	<c:if test="${sessionScope.memberNum == community.memberNum}">
		<button onclick="#">수정</button>
		<button onclick="#">삭제</button>
	</c:if>

	<span>글쓴이 : ${community.memberNum }</span>
	<span>작성일 : ${community.comDate}</span>
	<div dorder="1">${community.comTitle}</div>
	<div dorder="1">${community.comContent}</div>
	
</body>
</html>