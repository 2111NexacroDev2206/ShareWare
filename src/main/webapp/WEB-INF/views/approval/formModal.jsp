<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서 양식 선택</title>
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
</head>
<body>
	<!-- 문서 양식 선택 모달 -->
	<div class="m-appSel-wrap" id="appSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="header">문서양식 선택</span>
			</div>
			<div class="m-body">
				<div class="m-search">
					<select class="s-selForm" id="selectBox">
					</select>
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
	// 문서 양식 목록 조회
	$.ajax({
		url : "/modal/appForm/list.sw",
		type : "get",
		success : function(sList) {
			$.each(sList, function(index, item) {
				$("#selectBox").append("<option value=" + item.formNo + ">" + item.formName + "</option>")
			})
		},
		error : function() {
			alert("문서 양식 조회 실패");
		}
	});
	// 결재 상신 버튼 클릭
	$("#app-btn").click(function() {
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
	});
	$("#confirm").click(function(){
	    var formNo = $("#selectBox option:checked").val();
	    location.replace("/approval/docWriteView.sw?formNo=" + formNo);
	});
	$("#cancel").click(function(){
	    modalClose();
    });
	function modalClose(){
	    $("#appSelModal").fadeOut();
	}
</script>
</html>