<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 상세</title>
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
</head>
<style>
	.m-body div {
		margin-bottom: 20px;
	}
	.body-left {
		display: inline-flex;
		width: 60px;
	}
	.m-body div span:not(.body-left) {
		display: inline-flex;
		width: 128px;
	}
</style>
<body>
	<!-- 일정 상세 모달 -->
	<div class="m-appSel-wrap" id="appSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="header"></span>
			</div>
			<div class="m-body">
				<div>
					<span class="body-left">캘린더</span>
					<span id="m-cal-Name"></span>
				</div>
				<div>
					<span class="body-left">시작</span>
					<span id="m-sch-start"></span>
				</div>
				<div>
					<span class="body-left">종료</span>
					<span id="m-sch-end"></span>
				</div>
				<div>
					<span class="body-left">내용</span>
					<span id="m-sch-content"></span>
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn cancel" id="cancel" style="margin: 10px 0 0;">닫기</span>
			</div>
		</div>
	</div>
</body>
<script>
	// 일정 상세
	function calDetail(schNo) {
		$.ajax({
			url : "/calendar/homeDetailView.sw",
			type : "get",
			data : { "schNo" : schNo },
			success : function(calSch) {
				calModalView(calSch);
			},
			error : function() {
				alert("일정 상세 조회 실패");
			}
		})
	}
	
	// 모달 닫고 열기
	function calModalView(calSch) {
		$("#header").text(calSch.schName); // 일정 제목
		if(calSch.memNum == "admin") { // 캘린더 이름
			$("#m-cal-Name").text("전사 일정");
		}else {
			$("#m-cal-Name").text("내 캘린더");
		}
		$("#m-sch-start").text(calSch.schStartDate + " " + calSch.schStartTime); // 시작
		$("#m-sch-end").text(calSch.schEndDate + " " + calSch.schEndTime); // 종료
		$("#m-sch-content").text(calSch.schContent); // 내용
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
	};
	$("#cancel").click(function(){
	    modalClose();
    });
	function modalClose(){
	    $("#appSelModal").fadeOut();
	}
</script>
</html>