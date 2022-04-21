<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 정보 조회</title>
</head>
<body>
		
		<form method="post" action="upload" enctype="multipart/form-data">
	         <label>파일:</label>
	         <input multiple="multiple" type="file" name="file1">
        </form>
        
        
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
				
				<tr>
					<td>전화번호</td>
					<td>
						<input type="text" name="phone" value="${loginUser.address }">
					</td>
					<td>이메일</td>
					<td>
						<input type="text" name="mail" value="${loginUser.address }">
					</td>
				</tr>
				<tr>
					<td>입사일</td>
					<td>
						<input type="text" name="hireDate" value="${loginUser.hireDate }">
					</td>
					<td>퇴사일</td>
					<td>
						<input type="text" name="retireDate" value="${loginUser.retireDate }">
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" name="birth" value="${loginUser.birth }">
					</td>
					<td>성별</td>
					<td>
						<input type="text" name="gender" value="${loginUser.gender }">
					</td>
				</tr>
				<tr>
					<td>계좌</td>
					<td>
						<input type="text" name="account" value="${loginUser.account }">
					</td>
					<td>은행</td>
					<td>
						<input type="text" name="bank" value="${loginUser.bank }">
					</td>
				</tr>
			</table>
			
		</form>
	</div>
	
	
</body>
</html>