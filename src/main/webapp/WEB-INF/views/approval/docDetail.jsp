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
		<table id="table">
			<tr class="tr-s">
				<td class="td-1" rowspan="2">문서번호</td>
				<td class="td-2" rowspan="2">${appDoc.docNo }</td>
				<td class="td-3" rowspan="5" style="writing-mode: vertical-rl;">결재</td>
				<td class="td-4">담당</td>
				<td class="td-4" id="r-app0">${aList[0].rank }</td>
				<td class="td-4" id="r-app1">${aList[1].rank }</td>
				<td class="td-4" id="r-app2">${aList[2].rank }</td>
			</tr>
			<tr class="tr-s">
				<td class="td-6" rowspan="2" style="border-bottom: none;">
					<img alt="승인" src="/resources/img/app.png">
				</td>
				<td class="td-6" rowspan="2" style="border-bottom: none;">
					<c:if test="${aList[0].appStatus == '완료'}">
						<img alt="승인" src="/resources/img/app.png">
					</c:if>
					<c:if test="${aList[0].appStatus == '반려'}">
						<img alt="반려" src="/resources/img/rej.png">
					</c:if>
				</td>
				<td class="td-6" rowspan="2" style="border-bottom: none;">
					<c:if test="${aList[1].appStatus == '완료'}">
						<img alt="승인" src="/resources/img/app.png">
					</c:if>
					<c:if test="${aList[1].appStatus == '반려'}">
						<img alt="반려" src="/resources/img/rej.png">
					</c:if>
				</td>
				<td class="td-6" rowspan="2" style="border-bottom: none;">
					<c:if test="${aList[2].appStatus == '완료'}">
						<img alt="승인" src="/resources/img/app.png">
					</c:if>
					<c:if test="${aList[2].appStatus == '반려'}">
						<img alt="반려" src="/resources/img/rej.png">
					</c:if>
				</td>
			</tr>
			<tr class="tr-m">
				<td class="td-1">기안일</td>
				<td class="td-2">${appDoc.docDate }</td>
			</tr>
			<tr class="tr-s">
				<td class="td-1" rowspan="2">기안자</td>
				<td class="td-5" rowspan="2">${appDoc.memName }</td>
				<td class="td-6" style="border-top: none;">${appDoc.docDate }</td>
				<td class="td-6" style="border-top: none;">${aList[0].appDate }</td>
				<td class="td-6" style="border-top: none;">${aList[1].appDate }</td>
				<td class="td-6" style="border-top: none;">${aList[2].appDate }</td>
			</tr>
			<tr class="tr-s">
				<td class="td-5">${appDoc.memName }</td>
				<td class="td-5" id="name-app0">${aList[0].memberName }</td>
				<td class="td-5" id="name-app1">${aList[1].memberName }</td>
				<td class="td-5" id="name-app2">${aList[2].memberName }</td>
			</tr>
			<tr class="tr-m">
				<td class="td-1">참조자</td>
				<td colspan="6" id="ref-list" class="indent">
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
			<tr id="tr-title" class="tr-m">
				<td class="td-1">제목</td>
				<td colspan="6" class="indent">${appDoc.docTitle }</td>
			</tr>
			<c:set var="formName" value="${appDoc.formName}" />
			<c:if test="${formName eq '휴가신청서'}">
                <tr class="tr-m">
                    <td class="td-1">휴가종류</td>
                    <td colspan="6" class="indent">
                        ${appDoc.leaveType }
                    </td>
                </tr>
                <tr class="tr-m">
                    <td class="td-1">휴가기간</td>
                    <td colspan="6" id="td-leave-date" class="indent">
                    	<c:if test="${appDoc.leaveType ne '반차'}">
                        	${appDoc.leaveStart } ~ ${appDoc.leaveEnd }
                        </c:if>
                        <c:if test="${appDoc.leaveType eq '반차'}">
                        	${appDoc.leaveStart }
                        	&nbsp;&nbsp;${appDoc.leaveTime }
                        </c:if>
                        	&nbsp;&nbsp;휴가 일수 : ${appDoc.leaveDay }
                    </td>
                </tr>
                <tr class="tr-m">
                    <td class="td-1">연차일수</td>
                    <td colspan="6" id="td-leave-day" class="indent">
                       	잔여 연차 : <c:if test="${appDoc.leaveLeft != null}">${appDoc.leaveLeft}</c:if><c:if test="${appDoc.leaveLeft == null}">0</c:if>
                       	&nbsp;&nbsp;신청 연차 : <c:if test="${appDoc.leaveApply != null}">${appDoc.leaveApply}</c:if><c:if test="${appDoc.leaveApply == null}">0</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="td-1">휴가사유</td>
                    <td colspan="6" id="td-leave-reason" class="indent">${appDoc.docContent}</td>
                </tr>
			</c:if>
			<c:if test="${appDoc.formName ne '휴가신청서'}">
				<tr class="tr-m">
					<td colspan="7" class="td-content">내용</td>
				</tr>
				<tr>
					<td colspan="7" class="td-content-val">
						${appDoc.docContent }
					</td>
				</tr>
			</c:if>
		</table>
		<div class="div-span">
			<c:if test="${appFile != null }">
				<div class="div-file">
					<span class="material-icons" id="file-icon">attach_file</span>
					<span style="height: 24px">첨부 파일</span>
					<a href="../../../resources/auploadFiles/${appFile.fileReName }" download>${appFile.fileName}</a>
				</div>
			</c:if>
			<c:forEach items="${aList }" var="app">
				<c:if test="${app.rejReason != null }">
					<div class="div-rej">
						<span class="material-icons" id="rej-icon">block</span>
						<span>반려 사유</span>
						<span class="div-rejReason">${app.rejReason }</span>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<div class="div-btn">
			<c:if test="${type == 'draft'}">
				<input type="button" id="btn-cancel" value="상신 취소" class="i-left">
			</c:if>
			<c:if test="${type == 'app'}">
				<input type="button" id="btn-app" value="승인" class="i-left">
				<input type="button" id="btn-rej" value="반려">
			</c:if>
			<c:if test="${type == 'draft'}">
				<c:forEach items="${aList }" var="app">
					<c:if test="${app.appStatus == '반려' }">
						<input type="button" value="재상신" class="i-left" onclick="location.href='/approval/detail.sw?type=rej&docNo=${appDoc.docNo}&docStatus=${appDoc.docStatus }'">
					</c:if>
				</c:forEach>
			</c:if>
			<input type="button" value="목록" onclick="location.href='/approval/${type}ListView.sw'">
		</div>
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
			if(rejReason != null) { // 취소 누르면 null 반환하므로 null이 아닌 경우에만 처리
				var result = confirm("반려하시겠습니까?(반려 사유 : " + rejReason + ")");
				if(result == true) {
					location.href = '/approval/refStatus.sw?docNo=${appDoc.docNo}&type=${type}&rejReason=' + rejReason;
				}
			}
		})
	</script>
</body>
</html>