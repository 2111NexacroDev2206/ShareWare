<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/leave/leaveStatsView.sw" method="GET">
		<div>
			<table border="1">
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
	</form>		
</body>
</html>