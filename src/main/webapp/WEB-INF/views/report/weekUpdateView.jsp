<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 업무 수정 화면</title>
<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 주 간 업 무 일 지</h3>
		<form id="form" action="/report/weekUpdate.sw" method="post" enctype="multipart/form-data">
			<input type="hidden" name="wrNo" value="${week.wrNo }">
			<input type="hidden" name="fileName" value="${week.fileName }">
			<input type="hidden" name="filePath" value="${week.filePath }">
			<input type="hidden" name="fileReName" value="${week.fileReName }">
			<input type="hidden" name="wrDate" value="${week.wrDate }">
		<table border="1">
		<tr> 
			<td rowspan="2">제목</td>
			<td rowspan="2"><input type="text" name="wrTitle" value="${week.wrTitle}" ></td>
			<td>부서명</td>
			<td>${loginUser.division }</td>
		</tr>
		<tr> 
			<td>작성자</td>
			<td>${week.wrWriter }	</td>
		</tr>
			<tr>
                  <td colspan="4">
                     <textarea name="wrContent" id="t-content" >
                   		  ${week.wrContent }
                     </textarea>
				</td>
			</tr>
	 	</table>
		<p>첨부파일</p>
		<input type="file" name="reloadFile"> 
			<span id="file-val">${week.fileName }</span> <button id="btn-delete" type="button" onclick="deleteFileBtn('${week.filePath}',${week.wrNo} );">X</button>
			<input type="button" onclick="location.href='/report/weekModifyView.sw?wrNo=${week.wrNo}'" value="취소">
			<input type="submit" value="등록">
	</form>
	</div>
	<script>
	// 주간업무일지 내용
	if($("#file-val").text() == "") {
		$("#btn-delete").css("display","none");
	}
	CKEDITOR.replace( 'wrContent', {
        height: 500
     } );
	function deleteFileBtn(filePath, wrNo){
		location.href="/report/weekFileDelete.sw?filePath="+filePath+"&wrNo="+wrNo;
	}
	</script>
</body>
</html>