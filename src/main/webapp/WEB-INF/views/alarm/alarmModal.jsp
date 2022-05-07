<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>
<link href="/resources/css/alarm/alarm-style.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="alarm" id="alarm-modal">
	<div class="al-header">
		<span>알림</span>
		<span class="material-icons">
			done_all
		</span>
	</div>
	<div class="al-body" id="alarmBody">
		<a href="home.sw" class="al-list" id="al-read">
			<span class="al-kind app">[결재 완료]</span> <span class="al-content"><strong>박부장</strong>님이 올린 <strong>'휴가 신청서'</strong> 문서가 결재 완료되었습니다.</span><br>
			<span class="al-date">2022-04-08 15:33:13</span>
		</a>
	</div>
</div>
<script>
	var memNum = "${loginUser.memberNum}";
	$.ajax({ // 알림 목록 조회
		url : "/alarm/listView.sw",
		type : "get",
		data : { "memNum" : memNum },
		success : function(aList) {
			alarmList(aList);
		},
		error : function() {
			alert("알림 목록 조회 실패");
		}
	})
	
	// 알림 목록 div에 넣기
	function alarmList(aList) {
		$("#alarmBody").html(""); // 목록 div 초기화
		var div = "";
		$.each(aList, function(i) {
			div += '<a href="' + aList[i].alarmUrl + '" class="al-list" id="al-read">'
			+ aList[i].kind + ' ' + aList[i].alarmContent + '<br>'
			+ '<span class="al-date">' + aList[i].alarmDate + '</span></a>'
		});
		$("#alarmBody").append(div);
	}
</script>
</body>
</html>