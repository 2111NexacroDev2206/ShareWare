<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>

<div class="s-container">
	<h2 id="h-title">연차관리</h2><br>
	<form action="/leave/leaveStatsView.sw" method="GET">
		<div>
			<table align="center" border="1">
				<tr>
					<td>총연차</td>
					<td>사용연차</td>
					<td>잔여연차</td>
				</tr>
					<tr>
						<td>${tLeaveCount}</td>
						<td>${uLeaveCount}</td>
						<td>${rLeaveCount}</td>
					</tr>	
			</table>
		</div>
	</form>	<br>
	
	<form action="/leave/searchDate.sw" method="post">
    	<div>
	      <input type="month" value="Sysdate" name="date">
	      <input type="submit" value="검색">
    	</div>
    
		<div id="">
			<table align="center" id="" border="1">
				<tr>
					<td>No</td>
					<td>휴가종류</td>
					<td>사용일자</td>
					<td>사용일수</td>
				</tr>
				
				<c:forEach items="${lList }" var="leaveList" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${leaveList.leaveType }</td>
						<td>${leaveList.leaveStart }~ ${leaveList.leaveEnd }</td>
						<td>${leaveList.leaveDay }</td>
					</tr>
				</c:forEach>
			</table>
		</div>	
	</form>
</div>
</body>
</html>