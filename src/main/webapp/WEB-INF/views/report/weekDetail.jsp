<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 업무 상세</title>
<link href="/resources/css/report/w-form.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h2 id="h-title"> 주 간 업 무 일 지</h2>
		<table class="w-table">
		<tr> 
			<td id="t-title" rowspan="2">제목</td>
			<td id="t-inTitle" rowspan="2">${week.wrTitle }</td>
			<td id="t-div">부서명</td>
			<td id="t-inDiv">${loginUser.division }</td>
		</tr>
		<tr> 
			<td id="t-writer">작성자</td>
			<td id="t-inWriter">${week.wrWriter }
			<input type="hidden" value="${nowTime }"></td>
		</tr>
			<tr>
                  <td colspan="4">
                 		${week.wrContent }
				</td>
			</tr>
		</table>
		<p>첨부파일 </p>
		<a href="../../../resources/wuploadFiles/${week.fileReName }" download>
		 		${week.fileName }
				</a>
		<div class="div-btn">
		<input type="button" onclick="location.href='/report/weekModifyView.sw?wrNo=${week.wrNo}'" value="수정">
		<input type="button" onclick="delPop();" value="삭제">
		<input type="button" onclick="location.href='/report/weekList.sw'" value="목록">
		</div>
	</div>
	<script>
		CKEDITOR.replace( 'wrContent', {
			height: 850,
			removePlugins: "exportpdf"
		 } );
		function delPop(){
			var truefalse = confirm("삭제하시겠습니까?");
			if(truefalse) {
			location.href='/report/weekDelete.sw?wrNo=${week.wrNo}';
			}
		}
	</script>
</body>
</html>