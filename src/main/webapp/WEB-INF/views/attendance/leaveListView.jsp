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
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>

<div class="s-container">
	<h2 id="h-title">연차관리</h2><br>
	<form action="/leave/searchDate.sw" method="post">
    	<div>검색일
			<jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate value="${now}" pattern="yyyy" var="yearStart"/>
			<select id="u_year" name="date">         
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
			<table align="left" border="1">
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
		
		<div id="">
			<table align="center" id="" border="1" width="600px">
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