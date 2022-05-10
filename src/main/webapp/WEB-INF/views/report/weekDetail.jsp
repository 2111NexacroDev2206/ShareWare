<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업무현황 상세</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<table border="1">
			<tr>
				<td>제목</td>
				<td colspan="3">${work.workTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${work.workWriter }</td>
				<td>작성일</td>
				<td>${work.workDate }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><a href="../../../resources/wkuploadFiles/${work.fileReName }" download>
		 		${work.fileName }
				</a></td>
			</tr>
			<tr>
				<td colspan="4">${work.workContent }</td>
			</tr>
		</table>
		<c:if test="${loginUser.memberNum eq work.memNum}">
			<input type="button" id="btn-modify" onclick="location.href=" value="수정">
			<input type="button" id="btn-delete" onclick="delPop();" value="삭제">
		</c:if>
		<input type="button" onclick="location.href='/project/importantList.sw?projectNo=${work.projectNo}'" value="목록">
	</div>
</body>
<script>
	function delPop(){
		var truefalse = confirm("삭제하시겠습니까?");
		if(truefalse) {
		location.href="";
		}
	}
	// 글 작성자만 수정, 삭제 버튼 보이게 하기
	/* if("${loginUser.memberNum}" != "${important.memNum}") {
		$("#btn-modify").css("display", "none");
		$("#btn-delete").css("display", "none");
	} */
</script>
</html>