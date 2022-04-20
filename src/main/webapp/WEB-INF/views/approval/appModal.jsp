<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재자 선택</title>
<link href="/resources/css/appModal-style.css" rel="stylesheet">
</head>
<body>
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