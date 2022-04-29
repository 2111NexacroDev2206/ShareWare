<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 수정 화면 </title>
<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 일 일 업 무 일 지</h3>
		<form action="/report/dailyUpdate.sw" method="post" enctype="multipart/form-data">
			<input type="hidden" name="drNo" value="${daily.drNo }">
			<input type="hidden" name="fileName" value="${daily.fileName }">
			<input type="hidden" name="filePath" value="${daily.filePath }">
			<input type="hidden" name="fileReName" value="${daily.fileReName }">
			<input type="hidden" name="drDate" value="${daily.drDate }">
			<table border="1">
				<tr> 
					<td>제목</td>
					<td><input type="text" name="drTitle" value="${daily.drTitle }"></td>
					<td>부서명</td>
					<td>${loginUser.division }</td>
				</tr>
					<tr> 
					<td>작성일</td>
					<td>${daily.drDate }</td>
					<td>작성자</td>
					<td>${daily.drWriter }</td>
				</tr>
					<tr>
	                  <td colspan="4">
	                     <textarea name="drContent" id="t-content" >
	                   		  ${daily.drContent }
	                     </textarea>
					</td>
			</tr>
			</table>
			<p>첨부파일</p> 
			<input type="file" name="reloadFile"> 
			<span id="file-val">${daily.fileName }</span> <button id="btn-delete" type="button" onclick="deleteFileBtn('${daily.filePath}',${daily.drNo} );">X</button>
			<input type="button" onclick="location.href='/report/dailyModifyView.sw?drNo=${daily.drNo}'" value="취소">
			<input type="submit" value="등록">
		</form>
		</div>
</body>
<script>
	//일일업무일지 내용	
	CKEDITOR.replace( 'drContent', {
	    height: 500
	 } );
	if($("#file-val").text() == "") {
		$("#btn-delete").css("display","none");
	}
	function deleteFileBtn(filePath, drNo){
		location.href="/report/dailyFileDelete.sw?filePath="+filePath+"&drNo="+drNo;
	}
			
		
	
</script>
</html>