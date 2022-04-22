<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<tr>
			<th>날짜</th>
			<th>출근시간</th>
			<th>퇴근시간</th>
			<th>근무시간</th>
			<th>근무상태</th>
		</tr>
		<tr>
			<td>${attendance.attDate }</td>
			<td>${attendance.attStrTime }</td>
			<td>${attendance.attFinTime }</td>
			<td>${attendance.attTotalTime }</td>
			<td>${attendance.attStatus }</td>
		</tr>
	</div>
</body>
</html>