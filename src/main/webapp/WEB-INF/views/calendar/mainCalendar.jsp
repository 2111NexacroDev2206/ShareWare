<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>

<title>일정</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>

<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css"> -->




<script>
	  function schWrite(){ // 버튼 클릭 시 이벤트 추가
		  $('#exampleModalLabel').text('일정 작성');
			$('#addCalendar').text('등록');
			  $('input[name="scheduleNo"]').val('');
	            $('input[name="schName"]').val('');
	            $('input[name="schStartDate"]').val('');
	            $('input[name="schEndDate"]').val('');
	            $('textarea[name="schContent"]').val('');
	            $('select[name="schStartTime"]').val('');
	            $('select[name="schEndTime"]').val('');

          $("#calendarModal").modal("show"); // modal 나타내기
        
             $(function(){
          	   
              $('input[name=alStatus]').on('change', function(){  //알림여부 체크시 셀렉트 박스 보이게
                  var alStatus = this.checked;
                  
                    if(alStatus){
                       $('#aType').show(); 
                       
                    } else {
                    $('#aType').hide();
                    }
               })
            })
          
				//$("addCalendar").modal
				
				$("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
					var schNo = $("schNo").val();
					var memNum = $("memNum").val();
              var schName = $("#schName").val();
              var schContent = $("#schContent").val();
              var schStartDate = $("#schStartDate").val();
              var schStartTime = $("#schStartTime").val();
              var schEndDate = $("#schEndDate").val();
              var schEndTime = $("#schEndTime").val();
             /*  var alStatus;
              if($("alStatus").attr("checked")) {
              	alStatus = "y";
              }else{
              	alStatus = "n";
              } */
              var schColor = $(".selected").css("backgroundColor");
              $.ajax({
        		  url: "/calendar/schRegister.sw",
        		  type: "post",
        		  data: { 
        			  "schNo" : schNo,
        			  "memNum" : memNum,
        			  "schName" : schName,
                    "schContent" : schContent,
                    "schStartDate" : schStartDate,
                    "schStartTime" : schStartTime,
                    "schEndDate" : schEndDate,
                    "schEndTime" : schEndTime,
                   /*  "alStatus" : alStatus, */
                    "schColor" : schColor
                    }
           /*     success : function(data) {
              	if(data == "success") {
              		
              	}
              }  */
        		});
            //내용 입력 여부 확인
              if(schName == null || schName == ""){
                  alert("제목을 입력하세요.");
              }else if(schStartDate == "" || schEndDate ==""){
                  alert("날짜를 입력하세요.");
              }else if(new string(schEndDate)- new String(schStartTime) < 0){ // date 타입으로 변경 후 확인
                  alert("종료일이 시작일보다 먼저입니다.");
              }else{ // 정상적인 입력 시
                  var obj = {
                  	"schNo" : schNo,
                      "schName" : schName,
                      "schContent" : schContent,
                      "schStartDate" : schStartDate,
                      "schStartTime" : schStartTime,
                      "schEndDate" : schEndDate,
                      "schEndTime" : schEndTime,
                    /*   "alStatus" : alStatus, */
                      "schColor" : schColor
                      
                  }//전송할 객체 생성
                  console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                  
              }
          });
			 
      }
	  
	  
	  
	var calendar;
	document.addEventListener("DOMContentLoaded", function() {
	    var calendarDiv = document.querySelector("#calendarBox");
	    calendar = new FullCalendar.Calendar(calendarDiv, {
	        initialView : "dayGridMonth",
	        headerToolbar: {
	        	left:'title',
	        	center:'today,prev,next', 
               	right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek' // headerToolbar에 버튼을 추가
               
	        },   
	        buttonText : {
	        	today : "오늘",
	        	month : "월간",
	        	week : "주간",
	        	day : "일간",
	        	list : "목록"
	        },
	        droppable: false,
	        selectable: true,
	   		dayMaxEvents: true,
	     	select: function(arg) {  var title = (' '); 
	     // title 값이 있을때, 화면에 calendar.addEvent() json형식으로 일정을 추가
			     if (title) { 
			    	 calendar.addEvent({ 
			    	 title: title, start: arg.start,
			    	 end: arg.end+1, 
			    	 allDay: arg.allDay, 
			    	 backgroundColor:" ", textColor:" " }) 
			     }
		     	 calendar.unselect() 
	     	}, 
     		eventClick: function(arg) { // 있는 일정 클릭시, console.log("#등록된 일정 클릭#"); 
     		   $("#calendarModal").modal("show");
   				$('#exampleModalLabel').text('일정 상세');
     			$('#addCalendar').text('수정');
     			$('input[name="schNo"]').val(arg.event.extendedProps.schNo);
                $('input[name="schName"]').val(arg.event.title);
                $('input[name="schStartDate"]').val(arg.event.start.toISOString().substr(0, 10));
                $('input[name="schEndDate"]').val(arg.event.end.toISOString().substr(0, 10)); 
                $('textarea[name="schContent"]').val(arg.event.extendedProps.schContent);
                $('select[name="schStartTime"]').val(arg.event.extendedProps.schStartTime);
                $('select[name="schEndTime"]').val(arg.event.extendedProps.schEndTime);
                $("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
					var schNo = $('input[name="schNo"]').val();
					var memNum = $("memNum").val();
                  var schName = $("#schName").val();
                  var schContent = $("#schContent").val();
                  var schStartDate = $("#schStartDate").val();
                  var schStartTime = $("#schStartTime").val();
                  var schEndDate = $("#schEndDate").val();
                  var schEndTime = $("#schEndTime").val();
                  var schColor = $(".selected").css("backgroundColor");
                  $.ajax({
            		  url: "/calendar/schModifyView.sw",
            		  type: "post",
            		  data: { 
            			  "schNo" : schNo,
            			  "memNum" : memNum,
            			  "schName" : schName,
                        "schContent" : schContent,
                        "schStartDate" : schStartDate,
                        "schStartTime" : schStartTime,
                        "schEndDate" : schEndDate,
                        "schEndTime" : schEndTime,
                        "schColor" : schColor
                        }
                 /*  success : function(data) {
                  	if(data == "success") {
                  		
                  	}
                  } */
            		});
                //내용 입력 여부 확인
                  if(schName == null || schName == ""){
                      alert("제목을 입력하세요.");
                  }else if(schStartDate == "" || schEndDate ==""){
                      alert("날짜를 입력하세요.");
                  }else if(new Date(schEndDate)- new Date(schStartTime) < 0){ // date 타입으로 변경 후 확인
                      alert("종료일이 시작일보다 먼저입니다.");
                  }else{ // 정상적인 입력 시
                      var obj = {
                      	"schNo" : schNo,
                          "schName" : schName,
                          "schContent" : schContent,
                          "schStartDate" : schStartDate,
                          "schStartTime" : schStartTime,
                          "schEndDate" : schEndDate,
                          "schEndTime" : schEndTime,
                          "schColor" : schColor
                      }//전송할 객체 생성
                      console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                  }
              });
     		},
       		editable : true, //수정가능
        	selectable: true, // 달력일자 선택 가능, 드래그
        	nowIndicator: true, // 현재 시간 마크
        	/*  locale: 'ko', //한국어 설정  */
	        	events: [
	        		<c:forEach items="${sList}" var="sList">
	        		{
	        			title: '${sList.schName}',
	        			start: '${sList.schStartDate}',
	        			end:'${sList.schEndDate}',
	        			backgroundColor: '${sList.schColor}',
	        			borderColor: '${sList.schColor}',
	        			extendedProps: {
	        				'schNo' : '${sList.schNo}',
	        				'schContent' : '${sList.schContent}',
	        				'schStartTime' : '${sList.schStartTime}',
	        				'schEndTime' : '${sList.schEndTime}'
	        			}
	        		},
	        		</c:forEach>
	        	],			
	        /* 	eventRender:function(event, eventElement) {   //이미지 첨부
	                if(event.imageurl) {
	                    eventElement.find("span.fc-title").prepend("<center><img src='" + event.imageurl + "'><center>");
	                }
	            },
 */
	
	        eventAdd:function() {
	        	$('#exampleModalLabel').text('일정 작성');
     			$('#addCalendar').text('등록');
     			 $('input[name="scheduleNo"]').val('');
 	            $('input[name="schName"]').val('');
 	            $('input[name="schStartDate"]').val('');
 	            $('input[name="schEndDate"]').val('');
 	            $('textarea[name="schContent"]').val('');
 	            $('select[name="schStartTime"]').val('');
 	            $('select[name="schEndTime"]').val('');
	        	 $("#calendarModal").modal("show");
	        	
	        	/*  $("#schModal").css('display', 'flex').hide().fadeIn();   */
	        	
	        	$(function(){
             	   
                    $('input[name=alStatus]').on('change', function(){  //알림여부 체크시 셀렉트 박스 보이게
                        var alStatus = this.checked;
                        
                          if(alStatus){
                             $('#aType').show(); 
                             
                          } else {
                          $('#aType').hide();
                          }
                     })
                  });
                  $("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
						var schNo = $("schNo").val();
						var memNum =  $("memNum").val();
                      var schName = $("#schName").val();
                      var schContent = $("#schContent").val();
                      var schStartDate = $("#schStartDate").val();
                      var schStartTime = $("#schStartTime").val();
                      var schEndDate = $("#schEndDate").val();
                      var schEndTime = $("#schEndTime").val();
                     /*  var alStatus;
                      if($("alStatus").attr("checked")) {
                      	alStatus = "y";
                      }else{
                      	alStatus = "n";
                      } */
                      var schColor = $(".selected").css("backgroundColor");
                      $.ajax({
                		  url: "/calendar/schRegister.sw",
                		  type: "post",
                		  data: { 
                			  "schNo" : schNo,
                			  "memNum" : memNum,
                			  "schName" : schName,
                            "schContent" : schContent,
                            "schStartDate" : schStartDate,
                            "schStartTime" : schStartTime,
                            "schEndDate" : schEndDate,
                            "schEndTime" : schEndTime,
                           /*  "alStatus" : alStatus, */
                            "schColor" : schColor
                            }
                     /*  success : function(data) {
                      	if(data == "success") {
                      		
                      	}
                      } */
                		});
                    //내용 입력 여부 확인
                      if(schName == null || schName == ""){
                          alert("제목을 입력하세요.");
                      }else if(schStartDate == "" || schEndDate ==""){
                          alert("날짜를 입력하세요.");
                      }else if(new Date(schEndDate)- new Date(schStartTime) < 0){ // date 타입으로 변경 후 확인
                          alert("종료일이 시작일보다 먼저입니다.");
                      }else{ // 정상적인 입력 시
                          var obj = {
                          	"schNo" : schNo,
                              "schName" : schName,
                              "schContent" : schContent,
                              "schStartDate" : schStartDate,
                              "schStartTime" : schStartTime,
                              "schEndDate" : schEndDate,
                              "schEndTime" : schEndTime,
                            /*   "alStatus" : alStatus, */
                              "schColor" : schColor
                          }//전송할 객체 생성
                          console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                      }
                      refreshMemList();
                  });
	        }
	       
	    });
	    calendar.render();
	});

	function color(arg){
		 // 선택색상 세팅
		var backColor = $(arg).css("backgroundColor");
	    $('input[name="schColor"]').val(backColor);
	    $('.colors span').removeClass('selected');
	    for(let i=1; i <= $('.colors span').length; i++) {
	        if($('.colors span:nth-child('+i+')').css('background-color') == backColor) {
	            $('.colors span:nth-child('+i+')').addClass('selected');
	        }
	    }
		  }
		  
	function resetColor(arg){
	// 선택색상 첫 순서 색으로 리셋
	   $('.colors span').removeClass('selected');
	   $('.colors span:first-of-type').addClass('selected');
	
	   let defaultColor = $('.colors span:first-of-type').css('background-color');
	   $('input[name="scheduleColor"]').val('defaultColor');
	}
	function refreshList(){ //실행시 재로드
		location.reload();
	}
	
    function deleteBmk(calNo) {
    	$.ajax({
    		url : "/calendar/deleteCal.sw",
    		type : "get",
    		data : {
    			"calNo" : calNo
    		},
    		success : function(data) {
    			
    			refreshList();
    		},
    		error : function() {
    			alert("Ajax 통신 실패!");
    		}
    	});
    }
     
           
    </script>
<style>
#calendarBox {
	height: 900px;
	padding-top: 100px;
	padding-left: 500px;
}

input[type="checkbox"] {
	width: 15px;
	height: 15px;
	float: right;
	margin-left: 10px;
	margin-top: 5px;
}

.form-check-input {
	float: left;
	margin-left: 10px;
	margin-top: 5px;
}

/*  .bootstrap-timepicker-widget.dropdown-menu {
			        	z-index: 1050!important;
			        }
			         */
#schStartDate {
	width: 150px;
	float: left;
}

#schStartTime {
	width: 150px;
	float: left;
}

#schEndDate {
	width: 150px;
	float: left;
}

#schEndTime {
	width: 150px;
	
}

#calendarModal {
	display: none;
	
}
.modal-content {
width: 700px;
	height: 800px;
}
#btn-write {
	display: inline-block;
	width: 150px;
	height: 50px;
	background-color: white;
	border: 2.5px solid rgb(200, 200, 200);
	margin-left: 40px;
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}
#schName {
	width: 600px;
}
#calendarModal  .colors span.selected {
	border: 2px solid black;
}

#calendarModal .colors span {
	display: inline-block;
	width: 35px;
	height: 35px;
	margin-right: 4px;
	vertical-align: middle;
	cursor: pointer;
}

#calendarModal .colors {
	display: inline-block;
	vertical-align: middle;
	width: calc(90% - 90px);
	max-width: 360px;
	font-size: 0;
}
strong {
 color: rgb(140, 140, 140);
}

.btn-cal {
	display: inline-block;
	width: 100px;
	height: 40px;
	background-color: white;
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}
#subject {
	overflow:auto;
	height: 80px;
	
}

</style>
</head>
<body>


	<div class="s-menu">
		<div class="s-menu-title">
			<p>
				일정관리 <i class="fa-solid fa-calendar-check"></i>
		</div>
		<button id="btn-write" onclick="schWrite(); ">
			<strong>일정 추가</strong>
		</button>
		<br> <br> <br>
		<div class="s-list-item ${listCondition eq 'calMy' ? 'active' : ''}">
			
				<a href="javascript:myCalendar();"><strong>내 캘린더</strong></a>&nbsp;&nbsp;<i
					class="fa-solid fa-user-check"></i>
		</div>
		<div id="subject">
		<c:forEach items="${cList }" var="cal">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa-solid fa-circle-minus" style="color: grey;" onclick="deleteBmk('${cal.calNo}');"></i>&nbsp;&nbsp;${cal.calName }</div>
					</c:forEach> 
		</div>
				&nbsp;
		<div class="s-list-item ${listCondition eq 'calBmk' ? 'active' : ''}">
			
				&nbsp;&nbsp;&nbsp;<strong>관심 캘린더</strong>&nbsp;&nbsp;<i
					class="fa-solid fa-bookmark"></i>
		</div>
		&nbsp;
		

	</div>

	<div id="calendarBox"></div>
	<%-- <jsp:include page="schWrite.jsp"></jsp:include> --%>
	<div class="modal fade" id="calendarModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
					<input type="hidden" name="schNo">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				
					<div class="form-group">
						<label for="taskId" class="col-form-label"><strong>일정 제목</strong></label> 
						<input type="text" class="form-control" id="schName" name="schName">
							<br>
							<input type="hidden" name="schNo" >
							<input type="hidden" name="memNum" >
						<input type="hidden" name="schColor">
							<strong>색 선택</strong>
						<br>
								<div class="colors">
									<span class="selected" style="background-color: rgb(195, 96, 96);" onclick="color(this);"></span> 
										<span style="background-color: rgb(212, 137, 100);" onclick="color(this);"></span> 
										<span style="background-color: rgb(215, 195, 26);"  onclick="color(this);"></span> 
										<span style="background-color: rgb(137, 198, 77);" onclick="color(this);"></span> 
										<span style="background-color: rgb(85, 127, 79);"  onclick="color(this);"></span> 
										<span style="background-color: rgb(74, 133, 132);" onclick="color(this);"></span>
										<span style="background-color: rgb(25, 44, 106);" onclick="color(this);"></span> 
										<span style="background-color: rgb(82, 38, 109);"  onclick="color(this);"></span>

								</div>
						
					</div>
					<div class="form-group">
						<label for="taskId" class="col-form-label"><strong>기간</strong></label>
						<div>
							<input type="date" class="form-control" id="schStartDate"
								name="schStartDate"> <select class="form-control"
								id="schStartTime" name="schStartTime" > 
								<option value="09:00">09:00</option>
								<option value="09:30">09:30</option>
								<option value="10:00">10:00</option>
								<option value="10:30">10:30</option>
								<option value="11:00">11:00</option>
								<option value="11:30">11:30</option>
								<option value="12:00">12:00</option>
								<option value="12:30">12:30</option>
								<option value="13:00">13:00</option>
								<option value="13:30">13:30</option>
								<option value="14:00">14:00</option>
								<option value="14:30">14:30</option>
								<option value="15:00">15:00</option>
								<option value="15:30">15:30</option>
								<option value="16:00">16:00</option>
								<option value="16:30">16:30</option>
								<option value="17:00">17:00</option>
								<option value="17:30">17:30</option>
								<option value="18:00">18:00</option>
								<option value="18:30">18:30</option>
							</select>
							
							<input type="date" class="form-control" id="schEndDate"
								name="schEndDate"> <select class="form-control"
								id="schEndTime" name="schEndTime">
								<option value="09:00">09:00</option>
								<option value="09:30">09:30</option>
								<option value="10:00">10:00</option>
								<option value="10:30">10:30</option>
								<option value="11:00">11:00</option>
								<option value="11:30">11:30</option>
								<option value="12:00">12:00</option>
								<option value="12:30">12:30</option>
								<option value="13:00">13:00</option>
								<option value="13:30">13:30</option>
								<option value="14:00">14:00</option>
								<option value="14:30">14:30</option>
								<option value="15:00">15:00</option>
								<option value="15:30">15:30</option>
								<option value="16:00">16:00</option>
								<option value="16:30">16:30</option>
								<option value="17:00">17:00</option>
								<option value="17:30">17:30</option>
								<option value="18:00">18:00</option>
								<option value="18:30">18:30</option>
							</select>
						</div>
					</div>

					
						
							
						<div class="form-group">
						<label for="allDay"><strong>종일</strong></label>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" value="true"
								name="allDay">
						</div>
					</div>
					<div class="form-group">
						<label for="taskId" class="col-form-label"><strong>일정 내용</strong></label>
						<br>
						<textarea rows="8" cols="70" id="schContent" name="schContent"></textarea>
						<!-- <label for="taskId" class="col-form-label">알림 <input
							type="checkbox" class="form-control" id="input_check"
							name="alStatus">
						</label> <label id="aType" style="display: none;"> <select
							class="form-control" id="aType" name="aType">
								<option value="1">15분전</option>
								<option value="2">30분전</option>
								<option value="3">45분전</option>
								<option value="4">1시간전</option>
								<option value="5">3시간전</option>
								<option value="6">5시간전</option>
						</select>
						</label>
 -->
					</div>

				</div>
				<div class="modal-footer">
					<a href="">삭제하기</a>
					<button type="submit" class="btn-cal" id="addCalendar">저장</button>
					<button type="button" class="btn-cal" data-dismiss="modal"
						id="sprintSettingModalClose">취소</button>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="../calendar/calRegisterModal.jsp"></jsp:include>



	
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/locales-all.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
	<!-- <script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>


</body>
</html>
