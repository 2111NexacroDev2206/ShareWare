<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/main.min.css">
    <title>Document</title>
</head>
<body>
    <div id="mycalendar"></div>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/main.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/locales-all.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>




    

	<script>
	document.addEventListener("DOMContentLoaded",function(){
	    var calendarDiv = document.querySelector("#mycalendar");

	    var calendar;
	    calendar = new FullCalendar.Calendar(calendarDiv,{
	    	
	        initialView : "dayGridMonth",//"listWeek",
	        //데이터를 불러오는곳(json형태이며 여러개만 json array)
	        // events : [
	        //     {
	        //         "title":"Meeting",
	        //         "start":"2022-04-11T09:45:00",
	        //         extendedProps :{
	        //             "status" : "done",
	        //             "photoNo" : 1,
	        //             "photoContent":"flower.png"
	        //         }
	        //     },
	        //     {"title":"Birthday Party", "start":"2022-06-08T18:00:00"}
	        // ],

	        events: function(info,successCallback, failureCallback){
	        	var start= info.start.toISOString().slice(0, 7);
	            var end = info.end.toISOString().slice(0, 7);
	            var param = "";
	            param+="start="+start;
	            param+="&end="+end;
	            $.ajax({
	                url:"",
	                type : "",
	                data :param,
	                success : function(response){successCallback(response)},
	                error : function(){}
	            });
	        },
	        eventDidMount : function(info){
	            console.log(info.event.extendedProps.status);
	            console.log(info.event.extendedProps.photoNo);
	            console.log(info.event.extendedProps.photoContent);
	        },
	        eventClick: function(info) {
	        ("title : " + info.event.title);
	        $.ajax({
	            url:"",
	            type : "",
	            data :{},
	            success : function(){
	            	alert("yeh")
	            },
	            error : function(){}
	        });
	        }
	    });
	    calendar.render();
	})
	                
	</script>
</body>
</html>