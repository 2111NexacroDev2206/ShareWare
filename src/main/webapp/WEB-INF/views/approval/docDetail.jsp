<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안 문서 상세</title>
<link href="/resources/css/approval/appWrite-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h1 id="h-title">${appDoc.formName }</h1>
		<table border="1" id="table">
			<tr>
				<td>문서번호</td>
				<td>${appDoc.docNo }</td>
				<td rowspan="3" style="writing-mode: vertical-rl;">결재</td>
				<td>담당</td>
				<td id="r-app0">${aList[0].rank }</td>
				<td id="r-app1">${aList[1].rank }</td>
				<td id="r-app2">${aList[2].rank }</td>
			</tr>
			<tr>
				<td>기안일</td>
				<td>${appDoc.docDate }</td>
				<td>${appDoc.docDate }</td>
				<td>${aList[0].appStatus }<br>${aList[0].appDate }</td>
				<td>${aList[1].appStatus }<br>${aList[1].appDate }</td>
				<td>${aList[2].appStatus }<br>${aList[2].appDate }</td>
			</tr>
			<tr>
				<td>기안자</td>
				<td>${appDoc.memName }</td>
				<td>${appDoc.memName }</td>
				<td id="name-app0">${aList[0].memberName }</td>
				<td id="name-app1">${aList[1].memberName }</td>
				<td id="name-app2">${aList[2].memberName }</td>
			</tr>
			<tr>
				<td>참조자</td>
				<td colspan="6" id="ref-list">
					<c:forEach items="${rList }" var="appRef" varStatus="index">
						<c:choose>
							<c:when test="${!index.last}">
								${appRef.division } ${appRef.memberName } ${appRef.rank },
							</c:when>
							<c:when test="${index.last}">
								${appRef.division } ${appRef.memberName } ${appRef.rank }
							</c:when>
    					</c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr id="tr-title">
				<td>제목</td>
				<td colspan="6">${appDoc.docTitle }</td>
			</tr>
			<c:set var="formName" value="${appDoc.formName}" />
			<c:if test="${formName eq '휴가신청서'}">
                <tr>
                    <td>휴가 종류</td>
                    <td colspan="6">
                        ${appDoc.leaveType }
                    </td>
                </tr>
                <tr>
                    <td>휴가 기간</td>
                    <td colspan="6" id="td-leave-date">
                    	<c:if test="${appDoc.leaveType ne '반차'}">
                        	${appDoc.leaveStart }~${appDoc.leaveEnd }
                        </c:if>
                        <c:if test="${appDoc.leaveType eq '반차'}">
                        	${appDoc.leaveStart }
                        	${appDoc.leaveTime }
                        </c:if>
                        	휴가 일수 : ${appDoc.leaveDay }
                    </td>
                </tr>
                <tr>
                    <td>연차 일수</td>
                    <td colspan="6" id="td-leave-day">
                        	잔여 연차 : <c:if test="${appDoc.leaveLeft != null}">${appDoc.leaveLeft}</c:if><c:if test="${appDoc.leaveLeft == null}">0</c:if>
                        	신청 연차 : <c:if test="${appDoc.leaveApply != null}">${appDoc.leaveApply}</c:if><c:if test="${appDoc.leaveApply == null}">0</c:if>
                    </td>
                </tr>
                <tr>
                    <td>휴가 사유</td>
                    <td colspan="6" id="td-leave-reason">${appDoc.docContent}</td>
                </tr>
			</c:if>
			<c:if test="${appDoc.formName ne '휴가신청서'}">
				<tr>
					<td colspan="7" align="center">내용</td>
				</tr>
				<tr>
					<td colspan="7">
						${appDoc.docContent }
					</td>
				</tr>
			</c:if>
		</table>
		<c:if test="${appFile != null }">
			<span>첨부 파일</span>
			<a href="../../../resources/auploadFiles/${appFile.fileReName }" download>${appFile.fileName}</a>
		</c:if>
		<c:forEach items="${aList }" var="app">
			<c:if test="${app.rejReason != null }">
				<span>반려 사유</span>
				<textarea readonly>${app.rejReason }</textarea>
			</c:if>
		</c:forEach>
		<c:if test="${type == 'draft'}">
			<input type="button" id="btn-cancel" value="상신 취소">
		</c:if>
		<c:if test="${type == 'app'}">
			<input type="button" id="btn-app" value="승인">
			<input type="button" id="btn-rej" value="반려">
		</c:if>
		<c:if test="${type == 'draft'}">
			<c:forEach items="${aList }" var="app">
				<c:if test="${app.rejReason != null }">
					<input type="button" value="재상신" onclick="location.href='/approval/detail.sw?type=rej&docNo=${appDoc.docNo}'">
				</c:if>
			</c:forEach>
		</c:if>
		<input type="button" value="목록" onclick="location.href='/approval/${type}ListView.sw'">
	</div>
	<script>
		if("${docStatus}" != "대기") { // 결재 문서함에서 문서 상태가 대기가 아닌 경우 상신 취소 버튼 숨기기
			$("#btn-app").css("display", "none");
			$("#btn-rej").css("display", "none");
		}
		if("${appDoc.docStatus}" != "대기") { // 기안 문서함에서 문서 상태가 대기가 아닌 경우 상신 취소 버튼 숨기기
			$("#btn-cancel").css("display", "none");
		}
		$("#btn-cancel").click(function() { // 상신 취소 클릭 시 확인창 뜨고 확인 누르면 상신 취소 실행
			var result = confirm("상신 취소하시겠습니까?");
			if(result == true) {
				location.href = '/approval/cancle.sw?type=${type}&docNo=${appDoc.docNo}';
			}
		})
		$("#btn-app").click(function() { // 승인 확인 창
			var result = confirm("승인하시겠습니까?");
			if(result == true) {
				location.href = '/approval/appStatus.sw?docNo=${appDoc.docNo}&type=${type}';
			}
		})
		$("#btn-rej").click(function() { // 반려 확인 창
			var rejReason = prompt("반려 사유를 입력해주세요");
			var result = confirm("반려하시겠습니까?(반려 사유 : " + rejReason + ")");
			if(result == true) {
				location.href = '/approval/refStatus.sw?docNo=${appDoc.docNo}&type=${type}&rejReason=' + rejReason;
			}
		})
	</script>
</body>
</html>