<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<link rel="stylesheet" href="../../../resources/css/notice/noticeDetail.css">
</head>
<body>
<jsp:include page="../notice/noticeMenu.jsp"></jsp:include>
	<div id="coreDiv">
		<div id="marging">
		</div>
		<div id="position">
			<div id="contents">
				<div class="WriteDiv">작성자 : ${notice.memberNum }</div>
				<div class="optionBtnDiv">
					<button type="button" id="return" onclick="location.href='/fileBoard/list.sw'">목록</button>
				</div>
				<div class="dateDiv">작성일 : ${notice.noticeDate}</div>
				<div id="notice-TileDiv">${notice.noticeTitle}</div>
				<div id="notice-ContentDiv">${notice.noticeContent}
				
					<c:if test="${notice.noticeImgName != null}">
						<img src = "../../../resources/loadFile/${notice.noticeImgRemane}" alt="${notice.noticeImgName}">
					</c:if>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>