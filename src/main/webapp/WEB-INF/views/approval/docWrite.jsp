<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<jsp:include page="docForm.jsp"></jsp:include> <!-- 문서 양식 -->
</body>
<script>
	// 문서 타이틀 이름 변경
	$(document).attr("title", "${form.formName}");
	$("#h-title").text("${form.formName}");
	
	// 문서 내용 저장
	var formContent = $("#t-content")[0].outerHTML.replace(/\n/g, "");
	$("#docContent").val(formContent);
	
	// 휴가신청서
	if("${form.formName}" === "휴가신청서"){
		var leaveStart = 0; // 휴가 시작일 변수 선언
	    var leaveEnd = 0;   // 휴가 종료일 변수 선언
	    var leaveDay = 0;            // 휴가 일수 변수 선언
	    function leaveStartDate(e) { // 휴가 시작일 값 날짜화
	        leaveStart = new Date(e.target.value);
	        calLeaveDate();
	    }
	    function leaveEndDate(e) { // 휴가 종료일 값 날짜화
	        leaveEnd = new Date(e.target.value);
	        calLeaveDate();
	    }
	    var totalLeave = 15; // 잔여 연차
	    $("#left-leave").text(totalLeave);
	    function calLeaveDate() { // 휴가 날짜 차이 계산(연차, 반차인 경우에만)
	        if($("#leaveType").val() == "반차") { // 반차인 경우
	            halfLeave();
	        }else {
	            if(leaveStart !== 0 && leaveEnd !== 0){
	                var dateDiff = leaveEnd.getTime() - leaveStart.getTime();
	                leaveDay = Math.abs(dateDiff / (1000 * 3600 * 24) + 1);
	            }
	        }
	        setLeaveDay(leaveDay);
	        viewLeaveDay(leaveDay);
	    }
	    $("#leaveType").change(function() { // 휴가 종류 선택에 따라 처리하는 함수
	        var leaveType = $("#leaveType").val();
			$("#docTitle").val(leaveType + " 신청합니다.");
	        if($(this).val() == "반차") {
	            halfLeave();
	            $("#leaveTime").css("display", "inline-flex"); // 오전/오후 보이기
	            $(":radio[name='leaveTime'][value='오전']").prop("checked", true); // 휴가 시간 라디오 버튼 오전 자동으로 체크
	            $("#endDate").val(""); // 휴가 종료일 값 초기화
	            $("#endDate").css("display", "none"); // 휴가 종료일 숨기기
	            $("#tilde").css("display", "none"); // 휴가 시작일과 종료일 사이 '~' 숨기기
	            setLeaveDay(leaveDay);
	        }else{
	            $("#leaveTime").css("display", "none"); // 오전 오후 숨기기
	            $(":radio[name='leaveTime']").prop("checked", false); // 휴가 시간 라디오 버튼 체크 해제
	            $("#endDate").css("display", "inline-flex"); // 휴가 종료일 보이기
	            $("#tilde").css("display", "inline-flex"); // 휴가 시작일과 종료일 사이 '~' 보이기
	        }
	        viewLeaveDay(leaveDay);
	    });
	    function viewLeaveDay(leaveDay) { // 휴가 종류에 따라 연차 일수 표시
	        if($("#leaveType").val() == "연차" || $("#leaveType").val() == "반차") { // 반차 또는 연차인 경우
	            $("#apply-leave").text(leaveDay);
	            $("#left-leave").text(totalLeave - leaveDay);
	        }else {
	            $("#apply-leave").text(0);      
	        }
	    }
	    function setLeaveDay(leaveDay) { // 휴가 일수 표시 및 value 값 넣기
	        $("#s-leaveDay").text(leaveDay);
	        $("#i-leaveDay").val(leaveDay);
	    }
	    function halfLeave() { // 반차
	        leaveDay = 0.5;
	    }
	};
</script>
</html>