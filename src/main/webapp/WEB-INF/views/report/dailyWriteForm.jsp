<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 작성 </title>
<link href="/resources/css/report/form.css" rel="stylesheet">
<link href="/resources/css/menubar-style.css" rel="stylesheet">
<script src="https://cdn.ckeditor.com/4.18.0/full-all/ckeditor.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h2 id="h-title"> 일 일 업 무 일 지</h2>
		<form action="/report/dailyRegister.sw" method="post" enctype="multipart/form-data">
		<table class="d-table">
			<tr> 
				<td id="t-title">제목</td>
				<td id="t-inTitle"><input type="text" name="drTitle" style="width:400px;height: 40px; font-size: 14pt; border :0;"></td>
				<td id="t-div">부서명</td>
				<td id="t-inDiv">${loginUser.division }</td>
			</tr>
			<tr> 
				<td id="t-date">작성일</td>
				<td id="t-inDate"><input value="${nowTime }" name="drDate" style="width:400px;height: 40px; font-size: 14pt; border :0; "></td>
				<td id="t-writer">작성자</td>
				<td id="t-inWriter"><input type="hidden" value="${loginUser.memberName} " name="drWriter">${loginUser.memberName}</td>
				<input type="hidden" value="${loginUser.memberNum}" name="memNum">
			</tr>
			<tr>
			<td colspan="4" id="trCont" >
				<textarea name="drContent" id="trCont">
				<table align="center" border="1" cellpadding="1" cellspacing="1" style="height:900px; width:800px; ">
					<tbody>
						<tr>
							<td style="text-align:center"><strong>업 무 내 용&nbsp;</strong></td>
							<td style="text-align:center"><strong>처 리 내 용</strong></td>
						</tr>
						<tr>
							<td style="height:700px; width:70%">&nbsp;</td>
							<td style="height:700px">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align:center"><strong>비 고</strong></td>
						</tr>
						<tr>
							<td colspan="2" style="height:120px">&nbsp;</td>
						</tr>
					</tbody>
				</table>
				<p>&nbsp;</p>
				</textarea>
			</td>
			</tr>
		</table>
		<br>
			<span>파일첨부 <input type="file" name="uploadFile"></span> 
		<div class="div-btn">
			<input type="reset" value="취소">
			<input type="submit" value="등록">
		</div>
	</form>
	</div>
	<br><br>
	<script>
	// 일일업무일지 내용	
	CKEDITOR.replace( 'drContent', {
        height: 800
     } );
	</script>
</body>
</html>