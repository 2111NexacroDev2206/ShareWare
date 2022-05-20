<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
<style type="text/css">
	#appSel {
		max-width: 400px;
	}
	.s-input {
		width: 89%;
		float: left;
	}
	.s-text {
		width: 100%;
	}
	.m-list {
		height: 35%;
		 width: 100%;
		 
	}
	.g-text {
		display: inline-flex;
		height: 30px;
		width: 249px;
		border-radius: 4px;
		border: solid 1px rgb(190, 190, 190);
	}
</style>
</head>
<body>
   <div class="m-appSel-wrap" id="appSelModal">
		<div class="m-appSel" id="appSel">
			<div class="m-header">
				<span class="m-header-title" id="header"></span>
			</div>
			<div class="m-body" style="width: 300px;">
				<div class="m-tit" >
					<strong id="g-text"></strong> &nbsp;&nbsp;<input type="text" id="bmkSubject" name="bmkSubject" class="g-text">
				</div>
				<br>
				<div class="m-search">
					<select class="s-select" id="s-condition" name="searchCondition">
						<option value="all">전체</option>
						<option value="division">부서</option>
						<option value="memberName">이름</option>
					</select>
					<div class="s-input">
						<input type="text" id="s-value" name="searchValue" class="s-text">
						<input type="button" id="btn-search" class="i-search" value="&#xf002;">
					</div>
				</div>
				<div class="m-list">
					<table id="m-list-table" style="width: 280px;">
					</table>
				</div>
				<div class="m-select">
					<strong id="s-text"></strong><br>
					<p id="s-list">
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="register-bmk">확인</span>
				<span class="m-btn cancel" id="cancel">취소</span>
			</div>
		</div>
	</div>
</body>
</html>