<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 수정 화면 </title>
<link href="/resources/css/report/d-form.css" rel="stylesheet">
<link href="/resources/css/menubar-style.css" rel="stylesheet">
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
					<td id="t-title">제목</td>
					<td id="t-inTitle"><input type="text" name="drTitle" value="${daily.drTitle }" style="width:400px;height: 40px; font-size: 14pt; border :0;"></td>
					<td id="t-div">부서명</td>
					<td id="t-inDiv">${loginUser.division }</td>
				</tr>
					<tr> 
					<td id="t-date">작성일</td>
					<td id="t-inDate">${daily.drDate }</td>
					<td id="t-writer">작성자</td>
					<td id="t-inWriter">${daily.drWriter }</td>
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
			<div class="div-btn">
				<input type="button" onclick="location.href='/report/dailyModifyView.sw?drNo=${daily.drNo}'" value="취소">
				<input type="submit" value="등록">
			</div>
		</form>
		</div>
</body>
<script>
	//일일업무일지 내용	
	CKEDITOR.replace( 'drContent', {
	    height: 800
	 } );
	if($("#file-val").text() == "") {
		$("#btn-delete").css("display","none");
	}
	function deleteFileBtn(filePath, drNo){
		location.href="/report/dailyFileDelete.sw?filePath="+filePath+"&drNo="+drNo;
	}
</script>
</html>