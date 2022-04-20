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

    
    <title>calendarPage</title>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
   
   
	<script>
	var calendar;
	document.addEventListener("DOMContentLoaded", function() {
	    var calendarDiv = document.querySelector("#calendarBox");

	    calendar = new FullCalendar.Calendar(calendarDiv, {
	        initialView : "dayGridMonth",
	        headerToolbar: {
                center: 'addEventButton' // headerToolbar에 버튼을 추가
	        },   customButtons: {
                    addEventButton: { // 추가한 버튼 설정
                        text : "일정 추가",  // 버튼 내용
                        click : function(){ // 버튼 클릭 시 이벤트 추가
                        	alert("y");
                            $("#calendarModal").modal("show"); // modal 나타내기
							$("addCalendar").modal
							$("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
                                var subject = $("#sch_name").val();
                                var content = $("#sch_content").val();
                                var start_date = $("#sch_start_date").val();
                                var start_time = $("#sch_start_time").val();
                                var end_date = $("#sch_end_date").val();
                                var end_time = $("#sch_end_time").val();
                              //내용 입력 여부 확인
                                if(content == null || content == ""){
                                    alert("내용을 입력하세요.");
                                }else if(start_date == "" || end_date ==""){
                                    alert("날짜를 입력하세요.");
                                }else if(new Date(end_date)- new Date(start_date) < 0){ // date 타입으로 변경 후 확인
                                    alert("종료일이 시작일보다 먼저입니다.");
                                }else{ // 정상적인 입력 시
                                    var obj = {
                                        "subject" : subject,
                                        "content" : content,
                                        "start" : start_date,
                                        "startTime" : start_time,
                                        "end" : end_date,
                                        "endTime" : end_time
                                    }//전송할 객체 생성

                                    console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                                }
                            });
                           
                        }	
                    }
	        }
	    // 데이터를 불러오는 곳(json 형태이며 여러 개면 json array)
	       

	    });
	    calendar.render();
	})
    </script>
			     <style>
			        #calendarBox{
			            width: 55%;
			            height: 90%;
			            padding-top: 10%;
			        	padding-left: 30%;
			            
			        }
			
			    </style>
		</head>
    <body>
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
                        <input type="text" class="form-control" id="sch_name" name="sch_name">
                        <label for="taskId" class="col-form-label">일정 내용</label>
                        <input type="text" class="form-control" id="sch_content" name="sch_content">
                        <label for="taskId" class="col-form-label">시작 날짜</label>
                        <input type="date" class="form-control" id="calendar_start_date" name="sch_start_date">
                       	<label for="taskId" class="col-form-label">시작 시간</label>
                        <input type="time"class="form-control" id="calendar_end_hour" name="sch_end_hour">
                         <label for="taskId" class="col-form-label">종료 날짜</label>
                        <input type="date" class="form-control" id="calendar_end_date" name="sch_end_date">
                        <label for="taskId" class="col-form-label">종료 시간</label>
                        <input type="time"class="form-control" id="calendar_end_hour" name="sch_end_hour">
                        
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn-register" id="addCalendar">등록</button>
                    <button type="button" class="btn-cancel" data-dismiss="modal"
                        id="sprintSettingModalClose">취소</button>
                </div>
    
            </div>
        </div>
    </div>




     <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/main.min.js"></script> 
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/locales-all.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
    


	
    
	</body>
</html>