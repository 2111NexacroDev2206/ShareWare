<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회의실 예약</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/meetingRoom/meetingRoomReservation.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>

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
			<div id="marging">
			</div>
				<div id="position">
					<div id="contents">
					<form action="/meetionRoom/reservation.sw" method="GET" id="roomForm">
								<div id="rDiv">
										<div class="dateInputDiv">
											<div class="selectTextDiv">
												1. 날짜  
											</div>
											<div class="selectOptionDiv">
												<input type=date id="roomRDate">
											</div>
										</div>
										<div class="roomSelectDiv">
											<div class="selectTextDiv">
												2. 회의실 
											</div>
											<div class="selectOptionDiv">
												<select id="room">
												<option value="1 회의실"  selected>1 회의실</option>
												<option value="2 회의실" >2 회의실</option>
												<option value="3 회의실" >3 회의실</option>
												<option value="4 회의실" >4 회의실</option>
												<option value="5 회의실" >5 회의실</option>
											</select>
											</div>
										</div>
										<div class="timeSelectDiv">
											<div class="selectTextDiv">
												3. 시간 
											</div>
											<div class="selectOptionDiv">
												<select id="time">
												<option value="a">=== 선택 ===</option>
												<option value="1"  id="time1">10:00~12:00</option>
												<option value="2"  id="time2">13:00~15:00</option>
												<option value="3"  id="time3">15:00~17:00</option>
												<option value="4"  id="time4">17:00~19:00</option>
												<option value="5"  id="time5">19:00~21:00</option>
											</select>
											</div>
										</div>
										<div class="guide">
											<a>*회의실 이용안내 및 예약 방법*</a>	
											<div>
												<ul>
													<li>원하시는 날짜, 회의실, 시간을 선택해주세요.</li>
													<li>회의실 예약은 최대 3주 까지 가능합니다.</li>
													<li>원할한 이용을 위해 10분전 퇴실을 준비해주세요.</li>	
													<li>회의실 내 취식을 엄금합니다.</li>
													<li>회의실 내에서는 마스크를 착용해주세요.</li>	
												</ul>
											</div>
										</div>
										
								</div>
								<div class="detaileDiv">
									<div id = "calendar" class="calendarDiv">
									
									</div>
								</div>
								
							<div id = "buttonDiv">
								<button type="button" id="rButton">예약</button>
							</div>
					</form>
				</div>
			</div>
			
		</div>
	<script>
	
		var date = document.getElementById('roomRDate');
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0 so need to add 1 to make it 1!
		var yyyy = today.getFullYear();
		dateVaule();
		dateMax();
		roomChangeTime();
		
		document.addEventListener('DOMContentLoaded', function() {
		
				var calendarEl = document.getElementById("calendar");
				var calendar = new FullCalendar.Calendar(calendarEl, {
				initialView: 'dayGridMonth'
				});
				calendar.render();
	      }); 
		
		$("#roomRDate").on("click",function(){
			var $detaileDiv = $(".detaileDiv");
			$detaileDiv.html("");
			var $subContent = $("<div id = \"calendar\" class=\"calendarDiv\">");
			
			$detaileDiv.append($subContent);
			$('#calendar').css("background-color","white");

			var calendarEl = document.getElementById("calendar");
				var calendar = new FullCalendar.Calendar(calendarEl, {
				initialView: 'dayGridMonth'
				});
				calendar.render();
		});
		
	      $("#room").change(function(){
	    	  	var value = $("#room").val();
				var $detaileDiv = $(".detaileDiv");
				$detaileDiv.html("");
				var $subContent = $("<div id = \"calendar\" class=\"subContent\">");
				var $roomDetail1 = $("<div id=\"roomDetailDiv\">");
				if(value == "1 회의실"){
					var $roomImg =$("<img src=\"../../../resources/img/meetingRoom1.png\" id=\"roomImg\">");
					
					var $roomDetailList = $("<ul>").append("<li>적정인원 10인</li>")
													.append("<li>빔프로젝트</li>")
													.append("<li>노트북 대여</li>")
													.append("<li>화이트보드</li>");
					
					}
				if(value == "2 회의실"){
					var $roomImg =$("<img src=\"../../../resources/img/meetingRoom2.jpg\" id=\"roomImg\">");
					
						var $roomDetailList = $("<ul>").append("<li>적정인원 10인</li>")
													.append("<li>빔프로젝트</li>")
													.append("<li>노트북 대여</li>")
													.append("<li>화이트보드</li>");
					}
				if(value == "3 회의실"){
					var $roomImg =$("<img src=\"../../../resources/img/meetingRoom3.jpg\" id=\"roomImg\">");
					
					var $roomDetailList = $("<ul>").append("<li>적정인원 7인</li>")
													.append("<li>24인치 TV</li>")
													.append("<li>노트북 대여</li>")
													.append("<li>화이트보드</li>");
					}
				if(value == "4 회의실"){
					var $roomImg =$("<img src=\"../../../resources/img/meetingRoom4.jpg\" id=\"roomImg\">");
					
					var $roomDetailList = $("<ul>").append("<li>적정인원 15인</li>")
													.append("<li>빔프로젝트</li>")
													.append("<li>노트북 대여</li>")
													.append("<li>스피커</li>")
													.append("<li>화이트보드</li>");
					}
				if(value == "5 회의실"){
					var $roomImg =$("<img src=\"../../../resources/img/meetingRoom5.jpg\" id=\"roomImg\">");
					
					var $roomDetailList = $("<ul>").append("<li>적정인원 6인</li>")
													.append("<li>24인치 TV</li>")
													.append("<li>노트북 대여</li>")
													.append("<li>스피커</li>")
													.append("<li>화이트보드</li>");
				
					}
				
				$subContent.append($roomImg);
				$roomDetail1.append($roomDetailList);
				$detaileDiv.append($subContent);
				$detaileDiv.append($roomDetail1);
				
				
				
				
			});
		
		$("#time").on("click",function(){
			var $detaileDiv = $(".detaileDiv");
			$detaileDiv.html("");
			var $subContent = $("<div class=\"timeContent\">");
			var $timeImg = $("<img src=\"../../../resources/img/time.png\" id=\"timeImg\">");
			
			$subContent.append($timeImg);
			$detaileDiv.append($subContent);
		});
		
		
		function dateVaule(){
			today.setDate(today.getDate()+1);
			dayIf();
			var day = yyyy+'-'+mm+'-'+dd;
			date.setAttribute("value", day);
			date.setAttribute("min", day);
		}
		
		
		function dateMax(){
			today.setDate(today.getDate()+22);
			dayIf();
			var maxday = yyyy+'-'+mm+'-'+dd;
			date.setAttribute("max", maxday);
		}

		function dayIf(){
			dd = today.getDate();
			mm = today.getMonth()+1; //January is 0 so need to add 1 to make it 1!
			yyyy = today.getFullYear();
			if(dd<10){ //달이 10보다 작으면 앞에 0을 붙여줌 
				  dd='0'+dd
				} 
				if(mm<10){
				  mm='0'+mm
				}
		};
			
		//날짜가 바뀌면 room 선택 값 초기화
		$("#roomRDate").on("input",function(){
			$("#room").val("1 회의실").prop("selected", true);
			$("#time").val("a").prop("selected", true);
		});
		
		//예약
		$("#rButton").on("click",function(){
			var meetingDate = $("#roomRDate").val();
			var meetingNo = $("#room").val();
			var meetingTime = $("#time").val();
			if(meetingTime == 'a'){
				alert("예약시간을 정해주세요.");	
			}else{jQuery.ajax({
	             url : "/meetionRoom/reservation.sw"
	  	           , type : "GET"
	  	           , data : {"meetingDate" : meetingDate
	  	        	   		, "meetingNo" : meetingNo
	  	        	   		, "meetingTime" : meetingTime}
	  	           , success:function(data){
	  	        	   if(data == "success"){
	  	        		   location.href = '/meetionRoom/roomResevationList.sw';
	  	           }else{
	  	        	   alert("등록 실패!");
	  	        	   }
	  	        },error : function() {
	  				alert("ajax 통신 오류! 관리자에게 문의해주세요.");
	  			}
	  		})
				
			}
		});
		
		
		//예약 되어있는 회의실 조회
		$("#room").change(function(){
			roomChangeTime();
		});
		
		function roomChangeTime() {
			var meetingDate = $("#roomRDate").val();
			var meetingNo = $("#room").val();
			for(var i = 1; i<6; i++){
   				$("#time"+i).removeAttr("disabled"); 
   		  	}
			jQuery.ajax({
	             url : "/meetionRoom/checkTime.sw"
	           , type : "GET"
	           , data : {"meetingDate" : meetingDate
	        	   		 ,"meetingNo" : meetingNo}
			 	,dataType : "json"
	           , success:function(data){
        		   
	        	   //만약 예약 되어있으면 선택하지 못하게
	       		  for(var i = 0; i<data.length; i++){
	       			  for(var j = 1; j<6; j++){
	       				  if(data[i].meetingTime == j || data[i].meetingReservation == 0){
	       					$("#time"+j).attr("disabled", "disabled"); 
	       				  }
	       			  }
	       		  }
		        },error : function() {
		        	
				}
			});
		}

	</script>
</body>
</html>