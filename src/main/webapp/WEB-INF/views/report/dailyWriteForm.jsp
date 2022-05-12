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
<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 id="h-title"> 일 일 업 무 일 지</h3>
		<form action="/report/dailyRegister.sw" method="post" enctype="multipart/form-data">
		<table id="d-table">
			<tr> 
				<td class="t-title">제목</td>
				<td colspan ="2" class="t-1"><input type="text" name="drTitle" ></td>
				<td></td>
				<td class="t-div">부서명</td>
				<td>${loginUser.division }</td>
			</tr>
			<tr> 
				<td class="t-date">작성일</td>
				<td colspan ="2"><input value="${nowTime }" name="drDate"></td>
				<td></td>
				<td class="t-writer">작성자</td>
				<td><input type="hidden" value="${loginUser.memberName} "name="drWriter">${loginUser.memberName}</td>
				<input type="hidden" value="${loginUser.memberNum}" name="memNum">
			</tr>
			<tr>
			<td colspan="6">
				<textarea name="drContent" class="t-content" >
				<table align="center"  border="1" cellpadding="1" cellspacing="1" style="width:500px">
						<tbody>
							<tr>
								<td style="text-align:center"><strong>업 무 내 용&nbsp;</strong></td>
								<td style="text-align:center"><strong>처 리 내 용</strong></td>
							</tr>
							<tr>
								<td style="height:350px; width:70%">&nbsp;</td>
								<td style="height:350px">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align:center"><strong>비 고</strong></td>
							</tr>
							<tr>
								<td colspan="2" style="height:70px">&nbsp;</td>
							</tr>
						</tbody>
					</table>
				<p>&nbsp;</p>
				</textarea>
			</td>
			</tr>
		</table>
		<div>
			<p>파일첨부 <input type="file" name="uploadFile"> 
			<input type="reset" value="취소">
			<input type="submit" value="등록">
		</div>
	</form>
	</div>
	<script>
	// 일일업무일지 내용	
	CKEDITOR.replace( 'drContent', {
        height: 500
     } );
	</script>
</body>
</html>