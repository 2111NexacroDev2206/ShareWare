<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 상세 </title>
<link href="/resources/css/report/form.css" rel="stylesheet">
<script src="https://cdn.ckeditor.com/4.18.0/full-all/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h2 id="h-title"> 일 일 업 무 일 지</h2>
		<table class="d-table">
			<tr> 
				<td id="t-title">제목</td>
				<td id="t-inTitle">${daily.drTitle }</td>
				<td id="t-div" >부서명</td>
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
                 	${daily.drContent }
				</td>
			</tr>
		</table>
		<p >첨부파일</p>
		<a href="../../../resources/duploadFiles/${daily.fileReName }" download>
		 		${daily.fileName }
				</a>
		<div class="div-btn">
			<input type="button" onclick="location.href='/report/dailyModifyView.sw?drNo=${daily.drNo}'" value="수정">
			<input type="button" onclick="delPop();" value="삭제">
			<input type="button" onclick="location.href='/report/dailyList.sw'" value="목록">
		</div>
	</div>
</body>
<script>
//선택한 파일 없으면 버튼 숨기기

//일일업무일지 내용	
	CKEDITOR.replace( 'drContent', {
		height: 800,
		removePlugins: "exportpdf"
	 } );
	function delPop(){
		var truefalse = confirm("삭제하시겠습니까?");
		if(truefalse) {
		location.href='/report/dailyDelete.sw?drNo=${daily.drNo}';
		}
	}
</script>
</html>