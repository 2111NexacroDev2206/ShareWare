<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 정보 조회</title>
<link href="/resources/css/member/myInfo-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="container">
		<div class="menu-title">
			<p>기본 정보 조회
			<i class="fa-solid fa-address-card"></i>
		</div>
		<table class="t-info">
			<tr>
				<td rowspan="5">
					<c:if test="${loginUser.photo != null }">
						<img src="../../resources/profile/${loginUser.photo }" alt="사진">
					</c:if>
					<c:if test="${loginUser.photo == null }">
						<span class="material-icons" style="font-size: 250px;display: block;text-align: center">
							account_circle
						</span>
					</c:if>
				</td>
				<td class="td-left">사원번호</td>
				<td colspan="2">
					${loginUser.memberNum }
				</td>
			</tr>
			<tr>
				<td class="td-left">이름</td>
				<td colspan="2">
					${loginUser.memberName }
				</td>
			</tr>
			<tr>
				<td class="td-left">부서</td>
				<td colspan="2">
					${loginUser.division }
				</td>
			</tr>
			<tr>
				<td class="td-left">직급</td>
				<td colspan="2">
					${loginUser.rank }
				</td>
			</tr>
			<tr>
				<td class="td-left">주소</td>
				<td colspan="2">
					${loginUser.address }
				</td>
			</tr>
			<tr>
				<td class="td-left">전화번호</td>
				<td>
					${loginUser.phone }
				</td>
				<td class="td-left">이메일</td>
				<td>
					${loginUser.mail }
				</td>
			</tr>
			<tr>
				<td class="td-left">입사일</td>
				<td>
					${loginUser.hireDate }
				</td>
				<td class="td-left">퇴사일</td>
				<td>
					${loginUser.retireDate }
				</td>
			</tr>
			<tr>
				<td class="td-left">생년월일</td>
				<td>
					${loginUser.birth }
				</td>
				<td class="td-left">성별</td>
				<td>
					${loginUser.gender }
				</td>
			</tr>
			<tr>
				<td class="td-left">계좌</td>
				<td>
					${loginUser.account }
				</td>
				<td class="td-left">은행</td>
				<td>
					${loginUser.bank }
				</td>
			</tr>
		</table>
	</div>
</body>
</html>