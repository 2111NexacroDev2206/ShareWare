<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회의실 예약 확인</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/meetingRoom/meetingRoomCheck.css">
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>회의실
				<i class="fa-solid fa-pen-to-square fa-lg"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'meetingRoom' ? 'active' : ''}"><a href="/meetionRoom/meetingRoomReservationView.sw">회의실 예약</a></div>
		<div class="s-list-item ${listCondition eq 'roomCheck' ? 'active' : ''}"><a href="/meetionRoom/roomResevationList.sw">회의실 예약 확인</a></div>
	</div>

	<div id="coreDiv">
			<div id="modal">
				<div id="modal-content">
					날짜 :
					시간 : 
					회의실 : 
					<div id="img">
					</div>
					<div id="detail">
					</div>
					<div id="buttonDiv">
						<button type="button" id="returnBtn">확인</button>
						<button type="button" id="resetBtn">예약취소</button>
					</div>
				</div>
		</div>
			<div id="marging">
			</div>
				<div id="position">
					<div id="contents">
						<table class="type04">
								<tr>
									<th>예약 날짜</th>
									<th>시간</th>
									<th>회의실</th>
									<th></th>
								</tr>
										<c:if test ="${fn:length(mList) eq 0}"> <!-- list의 길이를 구해서 길이가 0이면 해당 문구를 출력 -->
											<tr>
												<td colspan = "5">예약 정보가 없습니다.</td>
											</tr>
										</c:if>
										<c:forEach items="${mList }" var="meetingRoom">
											
												<tr>
													<td>${meetingRoom.meetingDate} </td>
													<c:if test = "${meetingRoom.meetingTime  == 1}">
													<td>10:00~12:00</td>
													</c:if>
													<c:if test = "${meetingRoom.meetingTime  == 2}">
													<td>13:00~15:00</td>
													</c:if>
													<c:if test = "${meetingRoom.meetingTime  == 3}">
													<td>15:00~17:00</td>
													</c:if>
													<c:if test = "${meetingRoom.meetingTime  == 4}">
													<td>17:00~19:00</td>
													</c:if>
													<c:if test = "${meetingRoom.meetingTime  == 5}">
													<td>19:00~21:00</td>
													</c:if>
													<td>${meetingRoom.meetingNo }</td>
													<td><button type="button" id="popup_open_btn" onclick="datailRoom('${meetingRoom.meetingTime}','${meetingRoom.meetingNo }','${meetingRoom.meetingDate}');">확인</button></td>		
												</tr>
										</c:forEach>
								</table>
								<jsp:include page="meetingRoomPaging.jsp"></jsp:include>
							</div>
						</div>
					</div>
<script>
	modalDisplayNone()

	function modalDisplayNone(){
		document.getElementById("modal").style.display = "none";
	};
	
	function datailRoom(meetingTime,meetingNo,meetingDate){
		var reTime = meetingTime;
		if(meetingTime == 1){
			reTime = "10:00~12:00";
		}
		if(meetingTime == 2){
			reTime = "13:00~15:00";
		}
		if(meetingTime == 3){
			reTime = "15:00~17:00";
		}
		if(meetingTime == 4){
			reTime = "17:00~19:00";
		}
		if(meetingTime == 5){
			reTime = "19:00~21:00";
		}
		document.getElementById("modal").style.display = "block";
		var $modalDiv = $("#modal");
		$modalDiv.html("");
		var $informationDiv = $("<div id=\"inDiv\">");
		var $informationList = $("<ul>").append("<li>날짜 : "+meetingDate+"</li>")
		  								.append("<li>시간 : "+reTime+"</li>")
		  								.append("<li>회의실 : "+meetingNo+"</li>");
		
		if(meetingNo == "1 회의실"){
			var $imgDiv = $("<div>");
			var $imgTag = $("<img src=\"../../../resources/img/meetingRoom1.png\" id=\"roomImg\">");
			var $detailDiv = $("<div class=\"detailDiv\">");
			var $detailList = $("<ul>").append("<li>적정인원  5인</li>")
										.append("<li>빔프로젝트</li>")
										.append("<li>노트북</li>")
										.append("<li>화이트보드</li>");
		}
		if(meetingNo == "2 회의실"){
			var $imgDiv = $("<div>");
			var $imgTag = $("<img src=\"../../../resources/img/meetingRoom1.png\" id=\"roomImg\">");
			var $detailDiv = $("<div class=\"detailDiv\">");
			var $detailList = $("<ul>").append("<li>적정인원  5~6인</li>")
										.append("<li>빔프로젝트</li>")
										.append("<li>노트북</li>")
										.append("<li>화이트보드</li>");
		}
		if(meetingNo == "3 회의실"){
			var $imgDiv = $("<div>");
			var $imgTag = $("<img src=\"../../../resources/img/meetingRoom1.png\" id=\"roomImg\">");
			var $detailDiv = $("<div class=\"detailDiv\">");
			var $detailList = $("<ul>").append("<li>적정인원 15인</li>")
										.append("<li>빔프로젝트</li>")
										.append("<li>노트북</li>")
										.append("<li>스피커</li>")
										.append("<li>화이트보드</li>");
		}
		if(meetingNo == "4 회의실"){
			var $imgDiv = $("<div>");
			var $imgTag = $("<img src=\"../../../resources/img/meetingRoom1.png\" id=\"roomImg\">");
			var $detailDiv = $("<div class=\"detailDiv\">");
			var $detailList = $("<ul>").append("<li>적정인원  5~6인</li>")
										.append("<li>빔프로젝트</li>")
										.append("<li>스피커</li>")
										.append("<li>화이트보드</li>");
		}
		if(meetingNo == "5 회의실"){
			var $imgDiv = $("<div>");
			var $imgTag = $("<img src=\"../../../resources/img/meetingRoom1.png\" id=\"roomImg\">");
			var $detailDiv = $("<div class=\"detailDiv\">");
			var $detailList = $("<ul>").append("<li>적정인원  5~6인</li>")
										.append("<li>빔프로젝트</li>")
										.append("<li>정수기</li>")
										.append("<li>화이트보드</li>");
		}
		
		var $buttonDiv = $("<div id=\"buttonDiv\">")
										.append("<button type=\"button\" id=\"return\" onclick='modalDisplayNone();'>확인</button>")
										.append("<button id=\"cancle\" onclick='cancleRoom(\""+meetingTime+"\",\""+meetingNo+"\",\""+meetingDate+"\");'>예약취소</button>");
		
	$informationDiv.append($informationList);
	$imgDiv.append($imgTag);
	$detailDiv.append($detailList);
	$modalDiv.append($informationDiv);
	$modalDiv.append($imgDiv);
	$modalDiv.append($detailDiv);
	$modalDiv.append($buttonDiv);
	}
	

	function cancleRoom(meetingTime,meetingNo,meetingDate){
		var memberNum = "${loginUser.memberNum}";
		alert(memberNum);
		alert(meetingTime);
		
		$.ajax({
			url  : "/meetingRoom/roomReset.sw",
			type : "get",
			data : { "meetingDate" : meetingDate
					,"meetingTime" : meetingTime
					,"meetingNo" : meetingNo
					,"memberNum" : memberNum}, //받은 파라미터 값은 사용하기
			success : function(data) {//컨트롤러에서 데이터를 받아옴
				if(data == "success") {//데이터 값이 success면 성공
					alert("성공");
				}else{
					// 실패시 실패메시지
					alert("확인 실패!");//result값이 0이여서 뜨는 에러->where 조건절에 맞는 데이터가 없다.
				}
			},
			error 	: function() {
				alert("Ajax 통신 실패!!");
				//ajax 자체가 돌아가지 않았다.
			}
		})
	};
			
</script>
</body>
</html>