<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
<title>프로젝트 메인 화면 </title>
<link href="/resources/css/project/project-main.css" rel="stylesheet">
</head>
<body>
<jsp:include page="projectMainMenu.jsp"></jsp:include>
		<div class="s-container">
		<br><br>
		<div class="important-table">
			<span>중요공지</span><button onclick="location.href='/project/importantList.sw?projectNo=${projectNo}'">+ 더보기</button>
			<hr class="line">
			<table>
				<c:forEach items="${iList }" var="important" varStatus="status">
					<tr>
						 <c:url var="iDetail" value="/project/importantDetail.sw">
							<c:param name="importantNo" value="${important.importantNo }"></c:param>
							<c:param name="projectNo" value="${projectNo }"></c:param>
						</c:url>
						<td id="intitle"><a href="${iDetail }"><li>${important.importantTitle }</li></a></td>
						<td id="indate">${important.importantDate }</td>
					  
					</tr>
				</c:forEach>
			</table>
		</div>
	
		<div class="work-table">
			<span>업무현황</span><button onclick="location.href='/project/workList.sw?projectNo=${projectNo}'">+더보기</button>
			<hr class="line">
			<table>
				<c:forEach items="${wList }" var="work" varStatus="status">
					<tr>
						<c:url var="wDetail" value="/project/workDetail.sw">
							<c:param name="workNo" value="${work.workNo }"></c:param>
							<c:param name="projectNo" value="${projectNo }"></c:param>
						</c:url>
						<td id="intitle-work"><a href="${wDetail }">${work.workTitle }</a></td>
						<td id="inwriter">${work.workWriter }</td>
						<td id="indate">${work.workDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br><br>
			<div>
				<div class="chart" style="position: relative; height:500px; width:500px;">
					<span id="chart-span">업무진행률</span><button id="chart-btn" onclick="chart()">입력</button>
					<canvas id="Chart" width="500" height="400"></canvas>
				</div>
				<div class="participant" >
					<span id="par-span">구성원</span>
					<br><br>
					<div style="overflow:scroll; width:300px; height:150px; padding:10px; border:solid 1px gray; border-radius:3px">
						<div id="manager">프로젝트 관리자 ${project.projectMade }</div>
						<c:forEach items="${pList }" var="participant">
							<div>${participant.division } ${participant.memberName } ${participant.rank }</div>
						</c:forEach>
					</div>
					
				</div>
			</div>
		</div>
		
<script>
// 'Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'
		var chartArea = document.getElementById('Chart').getContext('2d');
		var myChart = new Chart(chartArea, {
		  type: 'bar',
		  data: {
		      labels: [<c:forEach items="${cList }" var="workChart">'${workChart.projectWriter }',</c:forEach>],
		      datasets: [{
		          label: '진행현황',
		          data: [<c:forEach items="${cList }" var="workChart">${workChart.wpRate },</c:forEach>],
		          backgroundColor: 'rgba(117, 144, 194, 0.38)',
		          borderColor: 'rgb(47, 71, 117)',
		          borderWidth: 1
		      }]
		  },
		  options: {
			  responsive : false,
		      scales: {
		          y: {
		        	  suggestedMax: 100,
		              beginAtZero: true
		          }
		      }
		  }
		});
	
	function chart(){
		var chart=prompt("업무진행률을 입력하세요.(%)")
		var projectNo = "${projectNo }";
		var memNum = "${loginUser.memberNum }";
		var projectWriter = "${loginUser.memberName }";
		if(chart != null) {
			location.href = '/project/workChart.sw?projectNo=' + projectNo + '&memNum=' + memNum + '&projectWriter=' + projectWriter + '&wpRate=' + chart;
		}
		
	}
</script>
</body>
</html>