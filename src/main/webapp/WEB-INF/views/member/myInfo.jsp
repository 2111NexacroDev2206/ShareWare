<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 정보 조회</title>
</head>
<body>
	<div class="">
		<form action="/member/myInfo.sw" method="post">
			<table border="1">
				<tr>
					<td>사원번호</td>
					<td>
						<input type="text" name="memberNum" value="${loginUser.memberNum }" readonly>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="memberName" value="${loginUser.memberName }">
					</td>
				</tr>
				<tr>
					<td>부서</td>
					<td>
						<input type="text" name="division" value="${loginUser.division }" readonly>
					</td>
				</tr>
				<tr>
					<td>직급</td>
					<td>
						<input type="text" name="rank" value="${loginUser.rank }">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address" value="${loginUser.address }">
					</td>
				</tr>
			</table>
			
		</form>
	</div>
	
	
</body>
</html>