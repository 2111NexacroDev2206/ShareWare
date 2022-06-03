<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중요공지 수정페이지</title>
<link href="/resources/css/important/important-form.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
	<h2 id="i-title">중요공지사항</h2>
		<form action="/project/importantUpdate.sw" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${projectNo }" name="projectNo">
			<input type="hidden" name="importantNo" value="${important.importantNo }">
			<input type="hidden" name="fileName" value="${important.fileName }">
			<input type="hidden" name="filePath" value="${important.filePath }">
			<input type="hidden" name="fileReName" value="${important.fileReName }">
			<table class="imp-tbl">
				<tr>
					<td id="tit">제목</td>
					<td><input type="text" name="importantTitle" value="${important.importantTitle }"></td>
				</tr>
				<tr>
					<td id="tit">작성자</td>
					<td><input type="hidden" value="${loginUser.memberName}" name="importantWriter">${loginUser.memberName}</td>
					<input type="hidden" value="${loginUser.memberNum}" name="memNum">
				</tr>
				<tr>
					<td id="tit">파일첨부</td>
					<td><input type="file" name="reloadFile"> 
					<span id="file-val">${important.fileName }</span> 
					<button id="btn-delete" type="button" onclick="deleteFileBtn'${important.filePath}',${important.importantNo},'${projectNo }' );">X</button>
					</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="importantContent">${important.importantContent }</textarea></td>
				</tr>
			</table>
				<input id="btn" type="button" onclick="location.href='/project/importantDetail.sw?projectNo=${projectNo}&importantNo=${important.importantNo }'"value="취소">
				<input id="btn" type="submit" value="등록">
		</form>
		
	</div>
</body>

<script>
	if($("#file-val").text() == "") {
		$("#btn-delete").css("display","none");
	}
	function deleteFileBtn(filePath, importantNo ,projectNo){
		location.href="/project/importantFileDelete.sw?filePath="+filePath+"&importantNo="+importantNo+"&projectNo="+projectNo;
	}
</script>
</html>