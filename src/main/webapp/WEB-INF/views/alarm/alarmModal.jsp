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
		<button id="allRead" title="모두 읽음 처리">
			<span class="material-icons">
				done_all
			</span>
		</button>
	</div>
	<div class="al-body" id="alarmBody">
	</div>
</div>
<script>
	var memNum = "${loginUser.memberNum}";
	
	// 자동 실행 함수
	$(function(){
		alarmListView(); // 알림 목록 조회 실행
	});
	
	// 알림 목록 조회
	function alarmListView() {
		$.ajax({
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
	}
	
	// 알림 목록 div에 넣기
	function alarmList(aList) {
		$("#alarmBody").html(""); // 목록 div 초기화
		var div = "";
		$.each(aList, function(i) {
			div += '<a href="#" class="al-list" onclick="alarmClick(' + aList[i].alarmUrl + ', ' + aList[i].alarmNo + ');">'
			+ aList[i].kind + ' ' + aList[i].alarmContent + '<br>'
			+ '<span class="al-date">' + aList[i].alarmDate + '</span></a>'
		});
		$("#alarmBody").append(div);
	}
	
	// 알림 클릭 시 읽음 처리
	function alarmClick(url, no) {
		$.ajax({
			url : "/alarm/read.sw",
			type : "get",
			data : { "alarmNo" : no },
			success : function(result) {
				location.href = url;
			},
			error : function() {
				alert("알림 읽음 처리 실패");
			}
		})
	}
	
	// 알림 모두 읽음 처리
	$("#allRead").click(function() {
		$.ajax({
			url : "/alarm/allRead.sw",
			type : "get",
			data : { "memNum" : memNum },
			success : function(result) {
				alarmList();
				$("#alarm-count").hide();
			},
			error : function() {
				alert("알림 모두 읽음 처리 실패");
			}
		})
	})
	
	// 알림 카운트
	$.ajax({
		url : "/alarm/count.sw",
		type: "get",
		data : { "memNum" : memNum },
		success : function(count) {
			if(count > 0) {
				$("#alarm-count").text(count);
				$("#alarm-count").css("display", "inline-flex");
			}
		},
		error : function() {
			alert("알림 카운트 조회 실패");
		}
	})
</script>
</body>
</html>