<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연차관리</title>
<style type="text/css">
	.stats-List{
	width: 500px;
	margin: 20px 0;
	font-size: 14px;
	text-align: center;
	border-collapse: collapse;
	border-top: 2px solid rgb(200, 200, 200);
	border-bottom: 2px solid rgb(200, 200, 200);
	}
	.stats-List tr {
		border-top: 1px solid rgb(200, 200, 200);
		height: 45px;
	}
	.stats-List tr:hover {
		background-color: rgb(250, 250, 250);
	}
	.stats-List th {
		background-color: rgb(240, 240, 240);
	}
	.stats-List .th-1 {
		width: 180px;
	}
	.stats-List .th-2 {
		width: 630px;
	}
	.stats-List .th-3 {
		width: 810px;
	}
	.stats-List a {
		text-decoration: none;
		color: black;
		cursor: pointer;
	}
	.stats-List span {
		padding: 5px 10px;
		border-radius: 4px;
		border: 1px;
		color: white;
	}
	</style>

<link href="/resources/css/approval/appList-style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->

<div class="s-container">
	<h2 id="h-title">연차관리</h2><br>
	<form action="/leave/searchDate.sw" method="post">
    	<div>검색일
			<jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate value="${now}" pattern="yyyy" var="yearStart"/>
			<select class="l-select" id="s-condition" name="date" style="text-align: left; width: 80px;">
				<option value="">선택</option>
				<c:forEach begin="0" end="${yearStart - 1980}" var="result" step="1">
					<option value="<c:out value="${yearStart-result}" />" <c:if test="${yearStart-result == detail.U_YEAR}"> selected="selected"</c:if>><c:out value="${yearStart-result}" /></option>
				</c:forEach>
			</select>
	        <input type="submit" value="검색">
    	</div><br>
    </form>
	<form action="/leave/leaveStatsView.sw" method="GET">
		<div>
			<table class="stats-List">
				<tr>
					<th class="th-1">총연차</th>
					<th class="th-1">사용연차</th>
					<th class="th-1">잔여연차</th>
				</tr>
					<tr>
						<td>${tLeaveCount}</td>
						<td>${uLeaveCount}</td>
						<td>${rLeaveCount}</td>
					</tr>	
			</table> 
			<h3 id="h-title" align="center">2022년도 조회</h3>
			<button id="app-btn" type="button" onclick="location.href='/approval/docWriteView.sw?formNo=3'">연차신청</button><br>
		</div>
		
		<div><br>
			<table class="t-List">
				<tr>
					<th class="th-1">No</th>
					<th class="th-1">휴가종류</th>
					<th class="th-1">사용일자</th>
					<th class="th-1">사용일수</th>
				</tr>
				
					<c:forEach items="${lList }" var="leaveList" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${leaveList.leaveType }</td>
							<td>${leaveList.leaveStart }~${leaveList.leaveEnd }</td>
							<td>${leaveList.leaveDay }</td>
						</tr>
					</c:forEach>
				
				<c:if test="${empty lList }">
					<tr>
						<td colspan='4'>검색된 연차가 없습니다</td>
					</tr>
				</c:if>
				
			</table>
		</div>	
		
	</form>
</div>
</body>
</html>