<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중요공지 상세 페이지</title>
<link href="/resources/css/important/important-form.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
	<h2 id="i-title">중요공지사항</h2>
		<table class="imp-tbl">
			<tr>
				<td id="tit">제목</td>
				<td colspan="3">${important.importantTitle }</td>
			</tr>
			<tr>
				<td id="tit">작성자</td>
				<td>${important.importantWriter }</td>
				<td id="tit">작성일</td>
				<td>${important.importantDate }</td>
			</tr>
			<tr>
				<td id="tit">첨부파일</td>
					<td colspan="3">
						<c:if test="${work.fileName == null}">
							<p>선택된 파일이 없습니다.
						</c:if>
					<a href="../../../resources/iuploadFiles/${important.fileReName }" download>
			 			${important.fileName }
					</a>
				</td>
			</tr>
			<tr>
				<td colspan="4" id="content">${important.importantContent }</td>
			</tr>
		</table>
		<c:if test="${loginUser.memberNum eq important.memNum}">
			<input type="button" id="btn" onclick="location.href='/project/importantModifyView.sw?importantNo=${important.importantNo}&projectNo=${projectNo }'" value="수정">
			<input type="button" id="btn" onclick="delPop();" value="삭제">
		</c:if>
		<input type="button" id="btn" onclick="location.href='/project/importantList.sw?projectNo=${important.projectNo}'" value="목록">
	</div>
</body>
<script>
	function delPop(){
		var truefalse = confirm("삭제하시겠습니까?");
		if(truefalse) {
		location.href="/project/importantDelete.sw?importantNo=${important.importantNo}&projectNo=${projectNo}";
		}
	}
	// 글 작성자만 수정, 삭제 버튼 보이게 하기
	/* if("${loginUser.memberNum}" != "${important.memNum}") {
		$("#btn-modify").css("display", "none");
		$("#btn-delete").css("display", "none");
	} */
</script>
</html>