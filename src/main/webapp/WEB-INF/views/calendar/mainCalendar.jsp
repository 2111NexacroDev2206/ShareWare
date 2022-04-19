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
                        <input type="text" class="form-control" id="sch_subject" name="sch_subject">
                        <label for="taskId" class="col-form-label">일정 내용</label>
                        <input type="text" class="form-control" id="sch_content" name="sch_content">
                        <label for="taskId" class="col-form-label">시작 날짜</label>
                        <input type="date" class="form-control" id="calendar_start_date" name="sch_start_date">
                        <label for="taskId" class="col-form-label">종료 시각(시각)</label>
                        <input type="time"class="form-control" id="calendar_end_hour" name="sch_end_hour">
                         <label for="taskId" class="col-form-label">종료 시각(분)</label>
                        <input type="date" class="form-control" id="calendar_end_min" name="sch_end_min">
                        <label for="taskId" class="col-form-label">종료 날짜</label>
                        <input type="date" class="form-control" id="calendar_end_date" name="sch_end_date">
                        <label for="taskId" class="col-form-label">시작 시각</label>
                        <input type="date" class="form-control" id="calendar_end_date" name="sch_end_date">
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