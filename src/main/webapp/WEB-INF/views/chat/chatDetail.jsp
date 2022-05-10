<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${chatRoomTitle }</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="/resources/css/chat/chatDetail-style.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Changa:wght@400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
	<div class="chatting">
		<div class="chat-header">
			<span class="chatRoomType">
				<c:if test="${chatRoomType == 0}"><!-- 1:1 채팅방 -->
					<span class="material-icons">
						account_circle
					</span>
				</c:if>
				<c:if test="${chatRoomType == 1}"><!-- 1:N 채팅방 -->
					<span class="material-icons">
						supervised_user_circle
					</span>
				</c:if>
			</span>
			<span class="chatRoomTitle">${chatRoomTitle }</span>
			<button class="more-btn">
				<span class="material-icons">
					more_horiz
				</span>
			</button>
		</div>
		<div class="chat-body">
			<c:forEach items="${cList}" var="chat">
				<c:if test="${chat.chatType == 1}"><!-- 공지 -->
					<div class="chat-notice">${chat.chatContent }</div>
				</c:if>
				<c:if test="${chat.chatType == 0}"><!-- 일반 -->
					<c:if test="${chat.memNum eq loginUser.memberNum}">
						<div class="chat-member">${chat.divName } ${chat.memName } ${chat.rankName }</div>
						<div class="chat-content">${chat.chatContent }</div>
					</c:if>
					<c:if test="${chat.memNum ne loginUser.memberNum}">
						<div class="chat-content me">${chat.chatContent }</div>
					</c:if>
				</c:if>
			</c:forEach>
		</div>
		<div class="chat-footer">
			<div><textarea id="textInput" style="white-space: pre;"></textarea></div>
			<button onclick="textSend('${loginUser.memberNum}')">전송</button>
		</div>
	</div>
	<script>
		// 엔터키 누르면 메세지 전송
		$("#textInput").keyup(function (e) {
			e.preventDefault();
			var code = e.keyCode ? e.keyCode : e.which;
			if(code == 13) { // 엔터키면
				if(e.shiftKey === true) {
					return false // shift 키가 눌러진 상태에서는 개행해서 입력 가능
				}else {
					textSend("${loginUser.memberNum}");
				}
			}
		})
	
		// 메세지 전송
		function textSend(memNum) {
			var text = $("#textInput").val();
			$("#textInput").val(""); // 메세지 입력창 초기화
			alert(memNum + text);
		}
	</script>
</body>
</html>