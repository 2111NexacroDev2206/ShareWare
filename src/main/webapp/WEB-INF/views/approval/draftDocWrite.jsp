<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서</title>
<link href="/resources/css/appModal-style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include>
	<div class="s-container">
		<h1>기안서</h1>
		<form action="/approval/draftDocWrite.sw" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td>문서번호</td>
					<td></td>
					<td rowspan="3">결재</td>
					<td>담당</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>기안일</td>
					<td>${nowTime }<input type="hidden" value="${nowTime }" name="docDate" readonly></td>
					<td></td>
					<td><button type="button" onclick="appBtn();">선택</button></td>
					<td><button type="button">선택</button></td>
					<td><button type="button">선택</button></td>
				</tr>
				<tr>
					<td>기안자</td>
					<td>${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="memNum" readonly></td>
					<td>${loginUser.memberName }</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="6">참조자</td>
					<td><button type="button">선택</button></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="6"><input type="text" name="docTitle"></td>
				</tr>
				<tr>
					<td colspan="7" align="center">내용</td>
				</tr>
				<tr>
					<td colspan="7" align="center"><textarea cols="50" rows="10" name="docContent"></textarea></td>
				</tr>
			</table>
			<p>파일 첨부
			<input type="file" name="uploadFile">
			<br>
			<input type="submit" value="결재 요청">
			<input type="button" value="임시 저장">
			<input type="reset" value="취소">
		</form>
	</div>
	<div class="m-appSel-wrap" id="appSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title">결재자 선택</span>
			</div>
			<div class="m-body">
				<div class="m-search">
					<form action="/approval/appSelsearch.kh" method="get" class="s-form">
						<select class="s-select" name="searchCondition">
							<option value="all">전체</option>
							<option value="division">부서</option>
							<option value="name">이름</option>
						</select>
						<div class="s-input">
							<input type="text" name="searchValue" class="s-text">
							<input type="submit" class="i-search" value="&#xf002;">
						</div>
					</form>
				</div>
				<div class="m-list">
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm">확인</span>
				<span class="m-btn cancel" id="cancel">취소</span>
			</div>
		</div>
	</div>
</body>
<script>
	function appBtn() {
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
	}
	$("#cancel").click(function(){
	      modalClose();
    });
	$("#confirm").click(function(){
	      modalClose();
	});
	function modalClose(){
	    $("#appSelModal").fadeOut();
	}
</script>
</html>