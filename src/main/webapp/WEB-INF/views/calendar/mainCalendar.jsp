<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    
    <title>calendar</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	
	
    <jsp:include page="../common/menuBar.jsp"></jsp:include>
   
	<script>
	
	 
	

	
	var calendar;
	document.addEventListener("DOMContentLoaded", function() {
	    var calendarDiv = document.querySelector("#calendarBox");

	    calendar = new FullCalendar.Calendar(calendarDiv, {
	        initialView : "dayGridMonth",
	        headerToolbar: {
	        	left:'prev,next,addEventButton',
	        	center:'title',
               	right: 'today,dayGridMonth,timeGridWeek,timeGridDay,listWeek' // headerToolbar에 버튼을 추가
               
	        },   
	        buttonText : {
	        	today : "오늘",
	        	month : "월간",
	        	week : "주간",
	        	day : "일간",
	        	list : "목록"
	        	
	        },
	     // 이벤트명 : function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용.. 
	     select: function(arg) {  var title = ('입력할 일정:'); 
	     // title 값이 있을때, 화면에 calendar.addEvent() json형식으로 일정을 추가
	     if (title) { calendar.addEvent({ 
	    	 title: title, start: arg.start,
	    	 end: arg.end, 
	    	 allDay: arg.allDay, 
	    	 backgroundColor:"yellow", textColor:"blue" }) }
	     	calendar.unselect() 
	     				},
	     	eventClick: function(arg) { // 있는 일정 클릭시, console.log("#등록된 일정 클릭#"); 
	     				console.log(arg.event); if (confirm('Are you sure you want to delete this event?')) { 
	     					arg.event.remove() } },
	     						
	       
	       		 editable : true, //수정가능
	        	selectable: true, // 달력일자 선택 가능, 드래그
	        	nowIndicator: true, // 현재 시간 마크
	        	locale: 'ko', //한국어 설정
	        eventAdd:function() {
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
                  $("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
						var schNo = $("schNo").val();
						var memNum = 'admin';
                      var schName = $("#schName").val();
                      var schContent = $("#schContent").val();
                      var schStartDate = $("#schStartDate").val();
                      var schStartTime = $("#schStartTime").val();
                      var schEndDate = $("#schEndDate").val();
                      var schEndTime = $("#schEndTime").val();
                      var alStatus;
                      if($("alStatus").attr("checked")) {
                      	alStatus = "y";
                      }else{
                      	alStatus = "n";
                      }
                      $.ajax({
                		  url: "/calendar/schRegister.sw",
                		  type: "post",
                		  data: { 
                			  "schNo" : schNo,
                			  "memNum" : 'admin',
                			  "schName" : schName,
                            "schContent" : schContent,
                            "schStartDate" : schStartDate,
                            "schStartTime" : schStartTime,
                            "schEndDate" : schEndDate,
                            "schEndTime" : schEndTime,
                            "alStatus" : alStatus
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
                              "alStatus" : alStatus
                              

                          }//전송할 객체 생성

                          console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                      }
                  });
	        },
	        customButtons: {
                    addEventButton: { // 추가한 버튼 설정
                        text : "일정 추가",  // 버튼 내용
                        click : function(){ // 버튼 클릭 시 이벤트 추가
                        	
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
								var memNum = 'admin';
                                var schName = $("#schName").val();
                                var schContent = $("#schContent").val();
                                var schStartDate = $("#schStartDate").val();
                                var schStartTime = $("#schStartTime").val();
                                var schEndDate = $("#schEndDate").val();
                                var schEndTime = $("#schEndTime").val();
                                var alStatus;
                                if($("alStatus").attr("checked")) {
                                	alStatus = "y";
                                }else{
                                	alStatus = "n";
                                }
                                $.ajax({
                          		  url: "/calendar/schRegister.sw",
                          		  type: "post",
                          		  data: { 
                          			  "schNo" : schNo,
                          			  "memNum" : 'admin',
                          			  "schName" : schName,
                                      "schContent" : schContent,
                                      "schStartDate" : schStartDate,
                                      "schStartTime" : schStartTime,
                                      "schEndDate" : schEndDate,
                                      "schEndTime" : schEndTime,
                                      "alStatus" : alStatus
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
                                        "alStatus" : alStatus
                                        

                                    }//전송할 객체 생성

                                    console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                                }
                            });
						 
                        }	
                    }
	        },
	    // 데이터를 불러오는 곳(json 형태이며 여러 개면 json array)
	       events: function(info, successCallback, failureCallback) {
	    	   $.ajax({
	    		   url : "/calendar/schListView.sw",
	    	   	   type : 'GET',
	    	   		dataType : 'json',
	    	   		data : {
	    	   			"schStartDate" : moment(info.schStartDateStr).format('YYYY-MM-DD'),
	    	   			"schEndDate" : moment(info.schEndDateStr).format('YYYY-MM-DD')
	    	   		},
	    	   success : function(data) {
	    		   successCallback(data);
	    	   }
	    	   	   
	    	   })
	    	   
	    	   
	       }
	   /*  function successCallback(data){
	    	
	    } */

	    });
	    calendar.render();
	    
	});
	
	
    </script>
			     <style>
			       #calendarBox{
			            width: 96%;
			            height: 95%;
			            padding-top: 10%;
			        	padding-left: 32%;
			            
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
			        
			        .bootstrap-timepicker-widget.dropdown-menu {
			        	z-index: 1050!important;
			        }
			        
			        #schStartDate {
			        	width: 30%;
			        	float : left;
			        	
			        	
			        }
			        #schStartTime {
			        	width : 30%;
			        	
			        	   	
			        }
			        #schEndDate {
			        width : 30%;
			        float: left;
			        
			        }
					#schEndTime {
					width : 30%;
					}
			    </style>
		</head>
    <body>
	<div class="s-menu">
      <div class="s-menu-title">
         <p>일정관리
        <i class="fa-solid fa-calendar-check"></i>
         
      </div>
      <div class="s-list-item ${listCondition eq 'calMy' ? 'active' : ''}"><p>&nbsp;&nbsp;&nbsp;내 캘린더&nbsp;&nbsp;<i class="fa-solid fa-user-check"></i></div>&nbsp;
      <div class="s-list-item ${listCondition eq 'calBmk' ? 'active' : ''}"><p>&nbsp;&nbsp;&nbsp;관심 캘린더&nbsp;&nbsp;<i class="fa-solid fa-bookmark"></i></div>&nbsp;
      <div class="s-list-item ${listCondition eq 'calGroup' ? 'active' : ''}"><p>&nbsp;&nbsp;&nbsp;공유 캘린더&nbsp;&nbsp;<i class="fa-solid fa-user-group"></i></div><i class="fa-solid fa-users-medical"></i>
   
   </div>
    <div id="calendarBox"></div>
    <div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">일정 제목</label>
                        <input type="text" class="form-control" id="schName" name="schName">
                   </div> 
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">시작일</label>
                        <div>
                        <input type="date" class="form-control" id="schStartDate" name="schStartDate">
                        <select class="form-control" id="schStartTime"name="schStartTime">
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
                        <label for="taskId" class="col-form-label">종료일</label>
                       <div>
                        <input type="date" class="form-control" id="schEndDate" name="schEndDate">
                        <select class="form-control" id="schEndTime" name="schEndTime">
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
						  <label for="allDay">종일</label>
						  <div class="form-check">
								<input type="checkbox" class="form-check-input" value="true" name="allDay">

						  </div>
					</div>
                   <div class="form-group">     
                        <label for="taskId" class="col-form-label">일정 내용</label>
                        <textarea rows="10" cols="50" id="schContent" name="schContent"></textarea>
                         <label for="taskId" class="col-form-label">알림
                         <input type="checkbox" class="form-control" id= "input_check" name="alStatus">
                         </label>
                        <label id="aType" style="display:none;">
	                        <select class="form-control" id="aType" name="aType">
								<option value="1">15분전</option>
								<option value="2">30분전</option>
								<option value="3">45분전</option>
								<option value="4">1시간전</option>
								<option value="5">3시간전</option>
								<option value="6">5시간전</option>
							</select>
						</label>
                   </div>
                   
            </div> <!-- body 끝-->
	                <div class="modal-footer">
	                    <button type="submit" class="btn-register" id="addCalendar">저장</button>
	                    <button type="button" class="btn-cancel" data-dismiss="modal" id="sprintSettingModalClose">취소</button>
	                </div>
    			
            </div>
        </div>
    </div>




     <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/main.min.js"></script> 
	<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/locales-all.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
	
    
	</body>
</html>