<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회의실 예약</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
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
			<form action="/meetionRoom/reservation.sw" method="GET" id="roomForm">
					<div id = "formDiv">
						<div id="rDiv">
								<div>
								날짜 : <input type=date id="roomRDate">
								</div>
								<div>
									회의실 : <select id="room">
										<option value="1 회의실" selected>1 회의실</option>
										<option value="2 회의실">2 회의실</option>
										<option value="3 회의실">3 회의실</option>
										<option value="4 회의실">4 회의실</option>
										<option value="5 회의실">5 회의실</option>
									</select>
								</div>
								<div>
									시간 : <select id="time">
										<option value="a">=== 선택 ===</option>
										<option value="1"  id="time1">10:00~12:00</option>
										<option value="2"  id="time2">13:00~15:00</option>
										<option value="3"  id="time3">15:00~17:00</option>
										<option value="4"  id="time4">17:00~19:00</option>
										<option value="5"  id="time5">19:00~21:00</option>
									</select>
								</div>
							</div>
						<div id = "bDiv">
							<button type="button" id="rButton">예약</button>
						</div>
						
					</div>
			</form>
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