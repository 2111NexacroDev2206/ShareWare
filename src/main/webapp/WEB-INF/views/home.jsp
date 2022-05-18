<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShareWare</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="/resources/css/home-style.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.js"></script>
</head>
<body>
	<jsp:include page="./common/menuBar.jsp"></jsp:include>
	<div class="container">
		<div class="c-left">
			<div class="myInfo box">
				<span class="c-title">내 정보</span>
				<img src="../resources/profile/kwonjihye.png" onclick="location.href='/member/myInfo.sw'">
				<div style="font-size:18px;">${loginUser.memberName } ${loginUser.rank }</div>
				<div style="color: rgba(90, 90, 90); font-size:16px">${loginUser.division }</div>
				<div class="info-list">
					<a href="/approval/appListView.sw?docStatus=대기">결재 대기 문서<span>${appCount }건</span></a>	
					<a href="/approval/draftListView.sw?docStatus=진행">결재 진행 문서<span>${draftCount }건</span></a>				
					<a href="/approval/appListView.sw?docStatus=예정">결재 예정 문서<span>${expCount }건</span></a>				
				</div>
			</div>
			<div class="attendance box">
				<span class="c-title">근태 관리</span>
				<div class="att-time">
					<div>
						출근 시간<span id="att-str"></span>
					</div>
					<div>
						퇴근 시간<span id="att-fin"></span>
					</div>
				</div>
				<div class="att-btn">
					<button id="attStr-btn">출근</button>
					<button id="attFin-btn">퇴근</button>
				</div>
			</div>
		</div>
		<div class="c-center">
			<div class="calendar" id="calendar">
			</div>
			<div class="calendar-detail box-t">
				<header id="cal-header"></header>
				<div class="cal-area">
					<table id="cal-table"></table>
				</div>
			</div>
		</div>
		<div class="c-right">
			<div class="notice box">
				<span class="c-title">공지사항</span>
				<ul>
					<c:forEach items="${nList }" var="notice">
						<c:url var="nDetail" value="/notice/detail.sw">
							<c:param name="noticeNo" value="${notice.noticeNo }"/>
						</c:url>
						<li><a href="${nDetail }"><span>${notice.noticeTitle }</span></a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="project box">
				<span class="c-title">프로젝트 관리</span>
				<div class="p-area">
					<c:forEach items="${pList }" var="project">
						<c:url var="pDetail" value="/project/main.sw">
							<c:param name="projectNo" value="${project.projectNo }"/>
						</c:url>
						<button class="p-btn" onclick="location.href='${pDetail}'">
							<div class="p-title">${project.projectTitle }</div>
							<div class="p-made">담당자 ${project.projectMade }</div>
							<div class="p-date">${project.pStartDate } ~ ${project.pEndDate }</div>
						</button>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		attTime(); // 근태 관리 시간 조회
	})
	
	// 근태 관리 시간 조회
	function attTime() {
		$.ajax({
			url : "/attendance/workTime.sw",
			type : "get",
			data : { "memberNum" : "${loginUser.memberNum}"},
			success : function(attendance) {
				if(attendance.attStrTime != null){
					$("#att-str").text(attendance.attStrTime);
				}else {
					$("#att-str").text("00:00:00");
				}
				if(attendance.attFinTime != null){
					$("#att-fin").text(attendance.attFinTime);
				}else {
					$("#att-fin").text("00:00:00");
				}
			},
			error : function() {
				alert("출근 등록 실패");
			}
		})
	}
	
	// 출근
	$("#attStr-btn").click(function(){
		$.ajax({
			url : "/attendance/workStart.sw",
			type : "get",
			data : { "memberNum" : "${loginUser.memberNum}"},
			success : function(result) {
				attTime();
			},
			error : function() {
				alert("출근 등록 실패");
			}
		})
	});
	
	// 퇴근
	$("#attFin-btn").click(function(){
		$.ajax({
			url : "/attendance/workEnd.sw",
			type : "get",
			data : { "memberNum" : "${loginUser.memberNum}" },
			success : function(result) {
				attTime();
			},
			error : function() {
				alert("퇴근 등록 실패");
			}
		})
	});
	
	// 캘린더
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar: {
	            left: 'prev,next',
	            center: 'title',
	            right: 'today'
	        },
			initialView: 'dayGridMonth',
			selectable: true,
			dateClick: function(info) {
				calList(info.dateStr);
			}
		});
		calendar.render();
		var date = calendar.getDate(); // 현재 날짜
		calList(date.toISOString().substr(0, 10)); // 일정 목록 조회
	});
	
	// 일정 목록 조회
	function calList(selDate) {
		$.ajax({
			url : "/calendar/homeListView.sw",
			type : "get",
			data : { "selectDay" : selDate, "memberNum" : "${loginUser.memberNum}" },
			success : function(cList) {
				$("#cal-header").html(""); // 헤더 초기화
				$("#cal-table").html(""); // 테이블 값 비우기
				var header;
				var tr;
				header = '<span class="s-calHeader">' + selDate + '</span><span class="s-moreBtn"><button onclick="calViewMove();">+</button></span>'
				$.each(cList, function(i) {
					tr += '<tr class="tr-cal"><td class="td-color"><span class="circle-color" style="background:' + cList[i].schColor + ';"></span></td>';
					if(cList[i].alStatus == 'y'){
						tr += '<td class="td-time">종일</td>';
					}else if(cList[i].schStartTime != null && cList[i].schStartDate == selDate){
						tr += '<td class="td-time">' + cList[i].schStartTime + '</td>';
					}else if(cList[i].schStartTime != null && cList[i].schStartDate != selDate){
						tr += '<td class="td-time">종일</td>';
					}else {
						tr += '<td class="td-time"></td>';
					}
					tr += '<td class="td-name" colspan="2" onclick="calDetail(' + cList[i].schNo + ');">' + cList[i].schName + '</td></tr>';
				});
				$("#cal-header").append(header);
				$("#cal-table").append(tr);
			},
			error : function() {
				alert("일정 조회 실패");
			}
		})
	}
	
	// 더보기 버튼 클릭
	function calViewMove() {
		location.href="/calendar/schWriteView.sw";
	}
	
	// 일정 상세
	function calDetail(schNo) {
		$.ajax({
			url : "/calendar/homeDetailView.sw",
			type : "get",
			data : { "schNo" : schNo },
			success : function(calSch) {
				console.log(calSch);
			},
			error : function() {
				alert("일정 상세 조회 실패");
			}
		})
	}
</script>
</html>
