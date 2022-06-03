<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
<style type="text/css">
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

	<div class="m-appSel-wrap" id="bmkSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="header4"></span>
			</div>
			<div class="m-body">
				<div class="m-list">
					<table id="b-list-table">
					</table>
				</div>
				<div class="m-select">
					<strong id="s-text4"></strong><br>
					<p id="bmk-list">
					
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm4">확인</span>
				<span class="m-btn cancel" id="cancel4">취소</span>
			</div>
		</div>
	</div>
	
	<div class="m-appSel-wrap" id="bmkRefSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="bmkHeader"></span>
			</div>
			<div class="m-body">
				<div class="m-list">
					<table id="bmk-list-table">
					</table>
				</div>
				<div class="m-select">
					<strong id="bmk-text"></strong><br>
					<p id="bmk-list2">
					
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="bmk-ref-confirm">확인</span>
				<span class="m-btn cancel" id="bmk-ref-cancel">취소</span>
			</div>
		</div>
	</div>
	
</body>
</html>